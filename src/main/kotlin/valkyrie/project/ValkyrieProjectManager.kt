package valkyrie.project

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileEvent
import valkyrie.project.workspace.ValkyrieWorkspace
import valkyrie.project.workspace.ValkyrieWorkspaceParser
import java.util.concurrent.ConcurrentHashMap

/**
 * Valkyrie 项目管理服务
 * 负责管理和缓存 workspace 和 project 信息
 */
class ValkyrieProjectManager(private val project: Project) {

    companion object {
        private val LOG = Logger.getInstance(ValkyrieProjectManager::class.java)

        fun getInstance(project: Project): ValkyrieProjectManager {
            return project.getService(ValkyrieProjectManager::class.java)
        }
    }

    private val workspaceParser = ValkyrieWorkspaceParser()
    private val projectParser = ValkyrieProjectParser()
    private val packageManager = ValkyriePackageManager.getInstance(project)

    // 缓存已解析的 workspace 和 project
    private val workspaceCache = ConcurrentHashMap<VirtualFile, ValkyrieWorkspace?>()
    private val projectCache = ConcurrentHashMap<VirtualFile, ValkyrieProject?>()

    init {
        // 监听文件系统变化，清理缓存
        project.messageBus.connect().subscribe(VirtualFileManager.VFS_CHANGES, object : BulkFileListener {
            override fun after(events: List<VFileEvent>) {
                events.forEach { event ->
                    val file = event.file
                    if (file != null && (file.name == ValkyrieWorkspaceParser.LEGIONS_JSON ||
                            file.name == ValkyrieProjectParser.LEGION_JSON)
                    ) {
                        clearCacheForFile(file)
                    }
                }
            }
        })
    }

    /**
     * 检查给定目录是否为 Valkyrie workspace
     */
    fun isValkyrieWorkspace(directory: VirtualFile): Boolean {
        return workspaceParser.isValkyrieWorkspace(directory)
    }

    /**
     * 检查给定目录是否为 Valkyrie 项目
     */
    fun isValkyrieProject(directory: VirtualFile): Boolean {
        return projectParser.isValkyrieProject(directory)
    }

    /**
     * 获取 workspace 信息，使用缓存
     */
    fun getWorkspace(directory: VirtualFile): ValkyrieWorkspace? {
        return workspaceCache.computeIfAbsent(directory) { dir ->
            try {
                workspaceParser.parseWorkspace(project, dir)
            } catch (e: Exception) {
                LOG.warn("Failed to parse workspace at ${dir.path}", e)
                null
            }
        }
    }

    /**
     * 获取项目信息，使用缓存
     */
    fun getProject(directory: VirtualFile): ValkyrieProject? {
        return projectCache.computeIfAbsent(directory) { dir ->
            try {
                projectParser.parseProject(project, dir)
            } catch (e: Exception) {
                LOG.warn("Failed to parse project at ${dir.path}", e)
                null
            }
        }
    }

    /**
     * 查找包含指定文件的 workspace
     */
    fun findWorkspaceForFile(file: VirtualFile): ValkyrieWorkspace? {
        var current = if (file.isDirectory) file else file.parent

        while (current != null) {
            if (isValkyrieWorkspace(current)) {
                return getWorkspace(current)
            }
            current = current.parent
        }

        return null
    }

    /**
     * 查找包含指定文件的项目
     */
    fun findProjectForFile(file: VirtualFile): ValkyrieProject? {
        var current = if (file.isDirectory) file else file.parent

        while (current != null) {
            if (isValkyrieProject(current)) {
                return getProject(current)
            }
            current = current.parent
        }

        return null
    }

    /**
     * 获取所有已知的 workspace
     */
    fun getAllWorkspaces(): List<ValkyrieWorkspace> {
        // 如果缓存为空，主动扫描项目根目录
        if (workspaceCache.isEmpty()) {
            scanProjectForWorkspaces()
        }
        return workspaceCache.values.filterNotNull()
    }
    
    /**
     * 扫描项目根目录查找所有工作空间
     */
    private fun scanProjectForWorkspaces() {
        val projectRoot = project.baseDir ?: return
        
        // 避免在ReadAction中执行耗时的文件系统操作
        // 使用后台线程执行扫描，避免阻塞UI线程和造成死锁
        ApplicationManager.getApplication().executeOnPooledThread {
            try {
                // 检查项目根目录本身是否为工作空间
                if (isValkyrieWorkspace(projectRoot)) {
                    // 在后台线程中使用 ReadAction 来安全访问 PSI
                    ReadAction.run<RuntimeException> {
                        getWorkspace(projectRoot)
                    }
                }
                
                // 递归扫描子目录（最多2层深度）
                scanDirectoryForWorkspaces(projectRoot, 0, 2)
            } catch (e: Exception) {
                LOG.warn("Error scanning project for workspaces: ${e.message}", e)
            }
        }
    }
    
    /**
     * 递归扫描目录查找工作空间
     */
    private fun scanDirectoryForWorkspaces(directory: VirtualFile, currentDepth: Int, maxDepth: Int) {
        if (currentDepth >= maxDepth || !directory.isDirectory) return
        
        try {
            directory.children.forEach { child ->
                if (child.isDirectory) {
                    if (isValkyrieWorkspace(child)) {
                        // 在后台线程中使用 ReadAction 来安全访问 PSI
                        ReadAction.run<RuntimeException> {
                            getWorkspace(child)
                        }
                    } else {
                        // 继续递归扫描
                        scanDirectoryForWorkspaces(child, currentDepth + 1, maxDepth)
                    }
                }
            }
        } catch (e: Exception) {
            LOG.warn("Failed to scan directory ${directory.path} for workspaces", e)
        }
    }

    /**
     * 获取所有已知的项目
     */
    fun getAllProjects(): List<ValkyrieProject> {
        return projectCache.values.filterNotNull()
    }

    /**
     * 获取指定 workspace 下的所有项目
     */
    fun getProjectsInWorkspace(workspace: ValkyrieWorkspace): List<ValkyrieProject> {
        return workspace.packages.mapNotNull { packageDir ->
            getProject(packageDir)
        }
    }

    /**
     * 刷新指定目录的缓存
     */
    fun refreshCache(directory: VirtualFile) {
        ApplicationManager.getApplication().runReadAction {
            workspaceCache.remove(directory)
            projectCache.remove(directory)

            // 重新解析
            if (isValkyrieWorkspace(directory)) {
                getWorkspace(directory)
            }
            if (isValkyrieProject(directory)) {
                getProject(directory)
            }
        }
    }

    /**
     * 清理所有缓存
     */
    fun clearAllCache() {
        workspaceCache.clear()
        projectCache.clear()
    }

    /**
     * 清理指定文件相关的缓存
     */
    private fun clearCacheForFile(file: VirtualFile) {
        val directory = if (file.isDirectory) file else file.parent ?: return

        // 清理直接相关的缓存
        workspaceCache.remove(directory)
        projectCache.remove(directory)

        // 清理可能受影响的父目录缓存
        var parent = directory.parent
        while (parent != null) {
            if (workspaceCache.containsKey(parent) || projectCache.containsKey(parent)) {
                workspaceCache.remove(parent)
                projectCache.remove(parent)
            }
            parent = parent.parent
        }
    }

    /**
     * 检查文件是否为 Valkyrie 相关文件
     */
    fun isValkyrieFile(file: VirtualFile): Boolean {
        if (file.isDirectory) return false

        return when (file.name) {
            ValkyrieWorkspaceParser.LEGIONS_JSON,
            ValkyrieProjectParser.LEGION_JSON -> true

            else -> file.extension == "vk" || file.extension == "valkyrie"
        }
    }

    /**
     * 获取文件的项目上下文信息
     */
    fun getFileContext(file: VirtualFile): ValkyrieFileContext? {
        val workspace = findWorkspaceForFile(file)
        val project = findProjectForFile(file)

        if (workspace == null && project == null) {
            return null
        }

        return ValkyrieFileContext(
            file = file,
            workspace = workspace,
            project = project,
            isInWorkspace = workspace != null,
            isInProject = project != null
        )
    }

    /**
     * 获取包管理器实例
     */
    fun getPackageManager(): ValkyriePackageManager {
        return packageManager
    }
}


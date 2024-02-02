package valkyrie.project.library

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.AdditionalLibraryRootsProvider
import com.intellij.openapi.roots.SyntheticLibrary
import com.intellij.openapi.vfs.VirtualFile
import valkyrie.index.ValkyrieProjectService

/**
 * Valkyrie 外部库根目录提供器
 * 将 Valkyrie 外部包添加到 External Libraries 节点中
 */
class ValkyrieLibraryRootsProvider : AdditionalLibraryRootsProvider() {
    
    companion object {
        // 缓存已经显示过通知的项目，避免重复通知
        private val notifiedProjects = mutableSetOf<String>()
    }
    
    override fun getAdditionalProjectLibraries(project: Project): Collection<SyntheticLibrary> {
        try {
            val projectService = ValkyrieProjectService.getInstance(project)
            val projectManager = projectService.getProjectManager()
            
            val libraries = mutableListOf<SyntheticLibrary>()
            
            // 添加标准库 @valkyrie/std
            addStandardLibrary(project, libraries)
            
            // 获取所有工作空间
            val workspaces = projectManager.getAllWorkspaces()
            
            for (workspace in workspaces) {
                // 为每个工作空间的外部包创建库
                val externalPackages = workspace.packages.filter { packageDir ->
                    // 判断是否为外部包（不在当前项目根目录下）
                    !packageDir.path.startsWith(project.basePath ?: "")
                }
                
                if (externalPackages.isNotEmpty()) {
                    val library = ValkyrieExternalLibrary(
                        name = "${workspace.name} External Packages",
                        sourceRoots = externalPackages
                    )
                    libraries.add(library)
                }
            }
            
            return libraries
        } catch (e: Exception) {
            // 如果服务未初始化或出现其他错误，返回空列表
            return emptyList()
        }
    }
    
    /**
     * 添加标准库 @valkyrie/std 到外部库列表
     */
    private fun addStandardLibrary(project: Project, libraries: MutableList<SyntheticLibrary>) {
        try {
            // 查找标准库路径
            val stdLibPaths = findStandardLibraryPaths(project)
            
            if (stdLibPaths.isNotEmpty()) {
                val stdLibrary = ValkyrieExternalLibrary(
                    name = "@valkyrie/std",
                    sourceRoots = stdLibPaths
                )
                libraries.add(stdLibrary)
            } else {
                // 如果找不到标准库，显示提示信息（但只显示一次）
                val projectPath = project.basePath ?: project.name
                if (!notifiedProjects.contains(projectPath)) {
                    try {
                        com.intellij.notification.NotificationGroupManager.getInstance()
                            .getNotificationGroup("Valkyrie")
                            ?.createNotification(
                                "Valkyrie Standard Library Not Found",
                                "Please install Valkyrie and set VALKYRIE_HOME environment variable to enable standard library support.",
                                com.intellij.notification.NotificationType.WARNING
                            )?.notify(project)
                        notifiedProjects.add(projectPath)
                    } catch (e: Exception) {
                        // 忽略通知错误
                    }
                }
            }
        } catch (e: Exception) {
            // 忽略标准库加载错误，不影响其他库的加载
        }
    }
    
    /**
     * 查找标准库路径
     */
    private fun findStandardLibraryPaths(project: Project): List<VirtualFile> {
        val stdLibPaths = mutableListOf<VirtualFile>()
        
        // 只从环境变量 VALKYRIE_HOME 加载标准库
        val valkyrieHome = System.getenv("VALKYRIE_HOME")
        if (valkyrieHome != null) {
            try {
                val homeFile = java.io.File(valkyrieHome)
                if (homeFile.exists() && homeFile.isDirectory) {
                    val packagesDir = java.io.File(homeFile, "packages")
                    if (packagesDir.exists() && packagesDir.isDirectory) {
                        val fileManager = com.intellij.openapi.vfs.VirtualFileManager.getInstance()
                        val packagesVirtualDir = fileManager.findFileByUrl(packagesDir.toURI().toString())
                        packagesVirtualDir?.let { vDir ->
                            // 在 packages 目录下查找标准库包
                            vDir.children.filter { it.isDirectory }.forEach { packageDir ->
                                stdLibPaths.add(packageDir)
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                // 忽略路径解析错误
            }
        }
        
        return stdLibPaths
    }
    
    override fun getRootsToWatch(project: Project): Collection<VirtualFile> {
        try {
            val projectService = ValkyrieProjectService.getInstance(project)
            val projectManager = projectService.getProjectManager()
            
            val watchRoots = mutableSetOf<VirtualFile>()
            
            // 监听所有工作空间的包目录
            val workspaces = projectManager.getAllWorkspaces()
            for (workspace in workspaces) {
                watchRoots.addAll(workspace.packages)
            }
            
            return watchRoots
        } catch (e: Exception) {
            // 如果服务未初始化或出现其他错误，返回空列表
            return emptyList()
        }
    }
}


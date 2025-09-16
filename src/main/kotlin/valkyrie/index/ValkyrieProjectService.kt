package valkyrie.index

import com.intellij.openapi.Disposable
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileEvent
import valkyrie.project.ValkyrieProjectManager
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.Service

/**
 * Valkyrie 项目服务
 * 管理符号索引的生命周期和项目结构
 */

@Service(Service.Level.PROJECT)
class ValkyrieProjectService(private val project: Project) : Disposable {
    
    private val fileListener = ValkyrieFileListener(project)
    private lateinit var projectManager: ValkyrieProjectManager
    
    init {
        // 延迟初始化 projectManager，确保所有服务都已注册
        projectManager = ValkyrieProjectManager.getInstance(project)
        // 注册文件监听器
        project.messageBus.connect(this).subscribe(VirtualFileManager.VFS_CHANGES, object : BulkFileListener {
            override fun after(events: List<VFileEvent>) {
                fileListener.handleEvents(events)
            }
        })
        
        // 移除重复的索引初始化，由ValkyrieStartupActivity负责
    }
    
    fun getSymbolIndex(): ValkyrieSymbolIndex {
        return ValkyrieSymbolIndex.getInstance(project)
    }
    
    fun getProjectManager(): ValkyrieProjectManager {
        return projectManager
    }
    
    override fun dispose() {
        // 清理文件监听器资源
        fileListener.dispose()
        
        // 清理项目管理器资源
        projectManager.clearAllCache()
    }
    
    companion object {
        fun getInstance(project: Project): ValkyrieProjectService {
            return project.getService(ValkyrieProjectService::class.java)
                ?: throw IllegalStateException("ValkyrieProjectService not found for project: ${project.name}")
        }
    }
}


package valkyrie.index

import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFileManager
import valkyrie.project.ValkyrieProjectManager

/**
 * Valkyrie 项目服务
 * 管理符号索引的生命周期和项目结构
 */

class ValkyrieProjectService(private val project: Project) : Disposable {
    
    private val fileListener = ValkyrieFileListener(project)
    private val projectManager = ValkyrieProjectManager.getInstance(project)
    
    init {
        // 注册文件监听器
        VirtualFileManager.getInstance().addVirtualFileListener(fileListener, this)
        
        // 初始化时构建索引
        ReadAction.run<RuntimeException> {
            ValkyrieSymbolIndex.getInstance(project).rebuildIndex()
        }
    }
    
    fun getSymbolIndex(): ValkyrieSymbolIndex {
        return ValkyrieSymbolIndex.getInstance(project)
    }
    
    fun getProjectManager(): ValkyrieProjectManager {
        return projectManager
    }
    
    override fun dispose() {
        // 清理资源
        projectManager.clearAllCache()
    }
    
    companion object {
        fun getInstance(project: Project): ValkyrieProjectService {
            return project.getService(ValkyrieProjectService::class.java)
        }
    }
}


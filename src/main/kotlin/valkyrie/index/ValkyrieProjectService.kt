package valkyrie.index

import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.intellij.openapi.vfs.VirtualFileManager
import valkyrie.project.ValkyrieProjectManager

/**
 * Valkyrie 项目服务
 * 管理符号索引的生命周期和项目结构
 */
@Service(Service.Level.PROJECT)
class ValkyrieProjectService(private val project: Project) : Disposable {
    
    private val symbolIndex = ValkyrieSymbolIndex(project)
    private val fileListener = ValkyrieFileListener(project)
    private val projectManager = ValkyrieProjectManager.getInstance(project)
    
    init {
        // 注册文件监听器
        VirtualFileManager.getInstance().addVirtualFileListener(fileListener, this)
        
        // 初始化时构建索引
        symbolIndex.rebuildIndex()
    }
    
    fun getSymbolIndex(): ValkyrieSymbolIndex {
        return symbolIndex
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

/**
 * Valkyrie 启动活动
 * 在项目启动时初始化服务
 */
class ValkyrieStartupActivity : StartupActivity {
    
    override fun runActivity(project: Project) {
        // 确保项目服务被初始化
        ValkyrieProjectService.getInstance(project)
    }
}
package valkyrie.index

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

/**
 * Valkyrie 启动活动
 * 在项目启动时初始化服务
 */
class ValkyrieStartupActivity : ProjectActivity {

    override suspend fun execute(project: Project) {
        // 确保项目服务被初始化
        ValkyrieProjectService.getInstance(project)
        
        // 初始化符号索引服务并在后台线程重建索引
        // 避免在项目启动时阻塞 EDT 线程
        ApplicationManager.getApplication().executeOnPooledThread {
            val symbolIndex = ValkyrieSymbolIndex.getInstance(project)
            symbolIndex.rebuildIndex()
        }
    }
}
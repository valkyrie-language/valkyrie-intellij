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
        
        // 只初始化符号索引服务，不立即重建索引
        // 索引将在首次需要时延迟构建，避免启动时的性能开销
        ValkyrieSymbolIndex.getInstance(project)
    }
}
package valkyrie.index

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
    }
}
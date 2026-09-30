package valkyrie.semantic.index

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

/**
 * Valkyrie 启动活动
 * 在项目启动时初始化服务
 */
class ValkyrieStartupActivity : ProjectActivity {

    override suspend fun execute(project: Project) {
        val projectService = ValkyrieProjectService.getInstance(project)
        projectService.getProjectManager().warmUpProjectStructure()
        ValkyrieSymbolIndex.getInstance(project)
    }
}
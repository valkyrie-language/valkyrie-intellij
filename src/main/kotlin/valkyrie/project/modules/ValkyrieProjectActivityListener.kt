package valkyrie.project.modules

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity


class ValkyrieProjectActivityListener : ProjectActivity {
    override suspend fun execute(project: Project) {
//        ModuleManager.getInstance(project).newModule("test.iml", "WEB_MODULE")
    }
}

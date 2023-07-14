package valkyrie.project.modules

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.startup.ProjectActivity


class LegionWorkspaceDetector : ProjectActivity {
    override suspend fun execute(project: Project) {

        val root = project.guessProjectDir()?.path ?: return

        WriteCommandAction.runWriteCommandAction(project) {
            val mm = ModuleManager.getInstance(project).getModifiableModel()
            val iml = "$root/.idea/modules/test.iml";
            println("ValkyrieProjectActivityListenerInner: $iml")
            val m2 = mm.newModule("$root/.idea/modules/test.iml", "WEB_MODULE")


//            println("ValkyrieProjectActivityListenerInner: ${m2.moduleFile}")
            mm.commit()
        }
    }
}

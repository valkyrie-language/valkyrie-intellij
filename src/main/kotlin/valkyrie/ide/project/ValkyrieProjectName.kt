package valkyrie.ide.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ex.ProjectNameProvider
import java.nio.file.Path

class ValkyrieProjectName : ProjectNameProvider {
    override fun getDefaultName(project: Project): String? {
        return "Valkyrie Project"
    }

    override fun getNameFile(project: Project): Path? {
        println("getNameFile(${project.basePath})")
        return null
    }
}
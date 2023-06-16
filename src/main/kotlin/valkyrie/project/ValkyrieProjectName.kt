package valkyrie.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ex.ProjectNameProvider
import java.nio.file.Path

@Suppress("UnstableApiUsage")
class ValkyrieProjectName : ProjectNameProvider {
    override fun getNameFile(project: Project): Path? {
        // legion.toml > name
        return null
    }
}

package valkyrie.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ex.ProjectNameProvider
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists


@Suppress("UnstableApiUsage")
class ValkyrieProjectName : ProjectNameProvider {
    override fun getNameFile(project: Project): Path? {
        // default path is `.idea/.name`
        return null
    }

    companion object {
        fun getRoot(project: Project): Path? {
            val root = project.basePath?.let { Paths.get(it) } ?: return null
            val ws = root.resolve("legions.json5");
            if (ws.exists()) {
                return ws
            } else {
                return null
            }
        }

    }
}

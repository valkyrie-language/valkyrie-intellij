package valkyrie.project.modules

import com.intellij.openapi.module.Module
import com.intellij.openapi.module.PrimaryModuleManager
import com.intellij.openapi.project.Project
import java.nio.file.Paths
import kotlin.io.path.exists

class ValkyrieRootModule : PrimaryModuleManager() {
    override fun getPrimaryModule(project: Project): Module? {
        val root = project.basePath?.let { Paths.get(it) } ?: return null
        val ws = root.resolve("legions.json5");
        return when {
            ws.exists() -> {
                ValkyrieModule(project)
            }

            else -> {
                null
            }
        }
    }
}



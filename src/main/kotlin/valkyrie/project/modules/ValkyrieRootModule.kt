package valkyrie.project.facet

import com.intellij.openapi.module.Module
import com.intellij.openapi.module.PrimaryModuleManager
import com.intellij.openapi.project.Project
import valkyrie.project.modules.ValkyrieModule
import java.nio.file.Paths
import kotlin.io.path.exists

class ValkyrieRootModule : PrimaryModuleManager() {
    override fun getPrimaryModule(project: Project): Module? {
        println("getPrimaryModule: $project{}")
        val root = project.basePath?.let { Paths.get(it) } ?: return null
        val ws = root.resolve("legions.json5");
        if (ws.exists()) {
            return ValkyrieModule()
        } else {
            return null
        }
    }
}



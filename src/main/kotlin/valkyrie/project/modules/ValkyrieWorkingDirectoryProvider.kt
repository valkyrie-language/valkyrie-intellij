package valkyrie.project.modules

import com.intellij.openapi.module.Module
import com.intellij.openapi.module.WorkingDirectoryProvider
import org.jetbrains.annotations.SystemIndependent

class ValkyrieWorkingDirectoryProvider : WorkingDirectoryProvider {
    override fun getWorkingDirectoryPath(module: Module): @SystemIndependent String? {
        println("ValkyrieWorkingDirectoryProvider: $module")
        return "workingDirectoryProvider"
    }
}


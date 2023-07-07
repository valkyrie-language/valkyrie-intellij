package valkyrie.project.modules

import com.intellij.openapi.module.Module
import com.intellij.openapi.module.WorkingDirectoryProvider

class ValkyrieWorkingDirectoryProvider : WorkingDirectoryProvider {
    override fun getWorkingDirectoryPath(module: Module?): String? {
        println("ValkyrieWorkingDirectoryProvider: $module");
        return "workingDirectoryProvider"
    }
}


package valkyrie.ide.project

import com.intellij.openapi.module.Module
import com.intellij.openapi.module.WorkingDirectoryProvider

class ValkyrieWorkingDirectory : WorkingDirectoryProvider {
    override fun getWorkingDirectoryPath(module: Module?): String? {
        if (module == null) return null
        println("getWorkingDirectoryPath(${module.moduleFilePath})")
        return null
    }
}
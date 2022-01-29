package valkyrie.ide.project.crate

import com.intellij.openapi.module.Module
import com.intellij.openapi.module.WorkingDirectoryProvider

class ValkyrieWorkingDirectory : WorkingDirectoryProvider {
    override fun getWorkingDirectoryPath(module: Module?): String? {
//        if (module !is ValkyriePackage) return null;
        println("getWorkingDirectoryPath(${module})")
        return null
    }
}


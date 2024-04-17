package valkyrie.project.facet

import com.intellij.openapi.module.Module
import com.intellij.openapi.module.WorkingDirectoryProvider

class workingDirectoryProvider : WorkingDirectoryProvider {
    override fun getWorkingDirectoryPath(module: Module?): String? {
        return "workingDirectoryProvider"
    }

}

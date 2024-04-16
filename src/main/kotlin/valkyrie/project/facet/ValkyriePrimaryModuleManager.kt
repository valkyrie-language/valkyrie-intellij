package valkyrie.project.facet

import com.intellij.openapi.module.Module
import com.intellij.openapi.module.PrimaryModuleManager
import com.intellij.openapi.project.Project

class ValkyriePrimaryModuleManager : PrimaryModuleManager() {
    override fun getPrimaryModule(project: Project): Module? {
        return null
    }
}

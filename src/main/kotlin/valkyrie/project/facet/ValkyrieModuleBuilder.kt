package valkyrie.project.facet

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.module.ModuleType

class ValkyrieModuleBuilder : ModuleBuilder() {
    override fun getModuleType(): ModuleType<*> {
        return ValkyrieModuleType(this)
    }

    override fun canCreateModule(): Boolean {
        return true
    }

    override fun validateModuleName(moduleName: String): Boolean {
        return super.validateModuleName(moduleName)
    }
}



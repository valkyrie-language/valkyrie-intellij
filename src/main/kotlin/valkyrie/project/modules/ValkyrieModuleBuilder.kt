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

    override fun getModuleFilePath(): String {
        return super.getModuleFilePath()
    }

    override fun getModuleFileDirectory(): String? {
        return super.getModuleFileDirectory()
    }

    override fun getName(): String {
        return "GetName23357"
    }

    override fun getPresentableName(): String {
        return "GetPresentableName233"
    }

    override fun getModuleTypeName(): String {
        return "GetModuleTypeNam123e"
    }


}



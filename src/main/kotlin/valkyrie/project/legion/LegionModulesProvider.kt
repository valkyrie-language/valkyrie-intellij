package valkyrie.project.legion

import com.intellij.facet.FacetModel
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModuleRootModel
import com.intellij.openapi.roots.ui.configuration.ModulesProvider

class LegionModulesProvider : ModulesProvider {
    private val _models: IdeModifiableModelsProvider

    constructor(models: IdeModifiableModelsProvider) {
        this._models = models
    }

    override fun getModules(): Array<Module> {
        for (module in _models.modules) {
            println("getModules: $module(${module.moduleFile})")
        }
        return _models.modules
    }

    override fun getModule(name: String): Module? {
        return _models.findIdeModule(name)
    }

    override fun getRootModel(module: Module): ModuleRootModel {
        println("getRootModel: $module(${module.moduleFile})")
        return _models.getModifiableRootModel(module)
    }

    override fun getFacetModel(module: Module): FacetModel {
        println("getFacetModel: $module(${module.moduleFile})")
        return _models.getModifiableFacetModel(module)
    }
}
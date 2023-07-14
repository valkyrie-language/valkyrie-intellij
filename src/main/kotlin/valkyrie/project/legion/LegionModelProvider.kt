package valkyrie.project.legion

import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.ModifiableModelsProviderExtension
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Pair


class LegionModelProvider : ModifiableModelsProviderExtension<LegionModel> {
    override fun create(project: Project, modelsProvider: IdeModifiableModelsProvider): Pair<Class<LegionModel>, LegionModel> {
        return Pair.create(LegionModel::class.java, LegionModel(project, modelsProvider))
    }
}


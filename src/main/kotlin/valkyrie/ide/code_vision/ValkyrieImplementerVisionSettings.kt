package valkyrie.ide.code_vision

import com.intellij.codeInsight.codeVision.CodeVisionProvider
import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingModel
import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingProvider
import com.intellij.openapi.project.Project

class ValkyrieImplementerVisionSettings : CodeVisionGroupSettingProvider {
    override val groupId: String = "implements"
    override val description: String = "Trace trait implements"
    override val groupName: String = "Implements"

    override fun createModel(project: Project): CodeVisionGroupSettingModel {
        return super.createModel(project)
    }

    override fun createSettingsModel(isEnabled: Boolean, providers: List<CodeVisionProvider<*>>): CodeVisionGroupSettingModel {
        return super.createSettingsModel(isEnabled, providers)
    }
}
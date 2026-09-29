package valkyrie.ide.code_vision

import com.intellij.codeInsight.codeVision.CodeVisionProvider
import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingModel
import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingProvider
import com.intellij.openapi.project.Project

/**
 * Code Vision 设置提供者
 */
class ValkyrieEffectVisionSetting : CodeVisionGroupSettingProvider {
    override val groupId: String = "effects"
    override val description: String = "Trace algebra effects"
    override val groupName: String = "Effects"

    override fun createModel(project: Project): CodeVisionGroupSettingModel {
        return super.createModel(project)
    }

    override fun createSettingsModel(isEnabled: Boolean, providers: List<CodeVisionProvider<*>>): CodeVisionGroupSettingModel {
        return super.createSettingsModel(isEnabled, providers)
    }
}


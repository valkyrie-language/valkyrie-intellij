package valkyrie.ide.code_vision

import com.intellij.codeInsight.codeVision.CodeVisionProvider
import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingModel
import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingProvider
import com.intellij.openapi.project.Project

/**
 * Code Vision 设置提供者
 */
class ValkyrieCodeVisionGroupSettingProvider : CodeVisionGroupSettingProvider {
    override val groupId: String = ValkyrieCodeVisionProvider.GROUP_ID
    override val description: String = "Show usage count for Valkyrie declarations"
    override val groupName: String = "Valkyrie"

    override fun createModel(project: Project): CodeVisionGroupSettingModel {
        return super.createModel(project)
    }

    override fun createSettingsModel(isEnabled: Boolean, providers: List<CodeVisionProvider<*>>): CodeVisionGroupSettingModel {
        return super.createSettingsModel(isEnabled, providers)
    }
}
package valkyrie.settings

import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingProvider

class codeVisionGroupSettingProvider : CodeVisionGroupSettingProvider {
    override val groupId = "effect"
    override val groupName = super.groupName
    override val description = super.description

}

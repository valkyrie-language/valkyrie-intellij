package valkyrie.settings

import com.intellij.codeInsight.codeVision.CodeVisionProvider
import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingModel
import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingProvider
import com.intellij.openapi.project.Project

class codeVisionGroupSettingProvider : CodeVisionGroupSettingProvider {
    override val groupId = "effect"
    override val groupName = super.groupName
    override val description = super.description

}

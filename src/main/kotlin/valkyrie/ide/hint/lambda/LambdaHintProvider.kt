package valkyrie.ide.hint.lambda

import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import com.intellij.codeInsight.hints.InlayGroup
import com.intellij.codeInsight.hints.InlayHintsProvider
import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.codeInsight.hints.SettingsKey
import com.intellij.lang.Language
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage


class LambdaHintProvider : InlayHintsProvider<LambdaHintSetting> {
    override val name = ValkyrieBundle.message("inlay.type.group.name")
    override val group = InlayGroup.LAMBDAS_GROUP
    override val key: SettingsKey<LambdaHintSetting> = SettingsKey("lambda")
    override val description = super.description
    override val previewText = null;
    override fun isLanguageSupported(language: Language): Boolean {
        return language is ValkyrieLanguage
    }

    override fun createSettings() = LambdaHintSetting()

    /// Editor > Inlay Hints > Types
    override fun createConfigurable(settings: LambdaHintSetting): LambdaHintSettingPanel {
        return LambdaHintSettingPanel(settings)
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: LambdaHintSetting, sink: InlayHintsSink): LambdaHintCollector {
        return LambdaHintCollector(settings)
    }


    override fun getCaseDescription(case: Case): String {
        return ValkyrieBundle.message("hint.${case.id}.detail")
    }

    override fun getProperty(key: String): String {
        return "LambdaHintProvider.getProperty"
    }
}



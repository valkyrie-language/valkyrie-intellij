package valkyrie.ide.hint.chain

import com.intellij.codeInsight.hints.*
import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import com.intellij.lang.Language
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage


class ChainHintProvider : InlayHintsProvider<ChainHintSetting> {
    override val name = ValkyrieBundle.message("inlay.type.name")
    override val group = InlayGroup.METHOD_CHAINS_GROUP
    override val key: SettingsKey<ChainHintSetting> = SettingsKey("chain")
    override val description = super.description
    override val previewText = null;
    override fun isLanguageSupported(language: Language): Boolean {
        return language is ValkyrieLanguage
    }

    override fun createSettings() = ChainHintSetting()
    override fun getCaseDescription(case: Case): String {
        return ValkyrieBundle.message("hint.${case.id}.detail")
    }

    override fun getProperty(key: String): String {
        return "LambdaHintProvider.getProperty"
    }

    override fun createConfigurable(settings: ChainHintSetting): ChainHintSettingPanel {
        return ChainHintSettingPanel(settings)
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: ChainHintSetting, sink: InlayHintsSink): ChainHintCollector {
        return ChainHintCollector(settings)
    }

    override fun getPlaceholdersCollectorFor(
        file: PsiFile,
        editor: Editor,
        settings: ChainHintSetting,
        sink: InlayHintsSink,
    ): InlayHintsCollector? {
        return ChainHintCollector(settings)
    }


}



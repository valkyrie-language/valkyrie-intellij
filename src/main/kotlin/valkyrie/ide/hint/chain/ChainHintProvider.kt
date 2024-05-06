package valkyrie.ide.hint.chain

import com.intellij.codeInsight.hints.*
import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle


class ChainHintProvider : InlayHintsProvider<ChainHintSetting> {
    private val rootKey = "v.chain.hints";
    override val name: String = ValkyrieBundle.message("inlay.type.group.name")
    override val group: InlayGroup = InlayGroup.METHOD_CHAINS_GROUP
    override val key: SettingsKey<ChainHintSetting> = SettingsKey(rootKey)
    override val description: String? = super.description
    override val previewText = javaClass.getResource("/templates/inlay-hint-chain.vk")?.readText();

    override fun createSettings() = ChainHintSetting()

    override fun createConfigurable(settings: ChainHintSetting): ChainHintSettingPanel {
        return ChainHintSettingPanel(settings)
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: ChainHintSetting, sink: InlayHintsSink): ChainHintCollector {
        return ChainHintCollector(settings)
    }

    override fun getCaseDescription(case: Case): String {
        return "getCaseDescription: ${case.id}"
    }

    override fun getPlaceholdersCollectorFor(
        file: PsiFile,
        editor: Editor,
        settings: ChainHintSetting,
        sink: InlayHintsSink,
    ): InlayHintsCollector? {
        return null
    }

    override fun getProperty(key: String): String {
        return "LambdaHintProvider.getProperty"
    }
}



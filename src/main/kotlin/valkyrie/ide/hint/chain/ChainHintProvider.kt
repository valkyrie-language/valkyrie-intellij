package valkyrie.ide.hint.chain

import com.intellij.codeInsight.hints.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle

@Suppress("UnstableApiUsage")
class ChainHintProvider : InlayHintsProvider<ChainHintSetting> {
    private val rootKey = "v.chain.hints";
    override val name: String = ValkyrieBundle.message("inlay.type.group.name")
    override val group: InlayGroup = InlayGroup.METHOD_CHAINS_GROUP
    override val key: SettingsKey<ChainHintSetting> = SettingsKey(rootKey)
    override val description: String? = super.description
    override val previewText = javaClass.getResource("/templates/inlay-hint-chain.vk")?.readText();

    override fun createSettings() = ChainHintSetting()

    /// 不知道干嘛的 显示在
    /// Editor > Inlay Hints > Types
    override fun createConfigurable(settings: ChainHintSetting): ChainHintSettingPanel {
        return ChainHintSettingPanel(settings)
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: ChainHintSetting, sink: InlayHintsSink): ChainHintCollector {
        return ChainHintCollector(settings)
    }

    // todo: getCasePreview
    override fun getCaseDescription(case: ImmediateConfigurable.Case): String {
        //return ValkyrieBundle.message(case.id)
        return case.id
    }

    override fun getProperty(key: String): String {
        return "LambdaHintProvider.getProperty"
    }
}



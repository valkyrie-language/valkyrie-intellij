package valkyrie.ide.hint.lambda

import com.intellij.codeInsight.hints.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle

@Suppress("UnstableApiUsage")
class LambdaHintProvider : InlayHintsProvider<LambdaHintSetting> {
    private val rootKey = "v.lambda.hints";
    override val name: String = ValkyrieBundle.message("inlay.type.group.name")
    override val group: InlayGroup = InlayGroup.LAMBDAS_GROUP
    override val key: SettingsKey<LambdaHintSetting> = SettingsKey(rootKey)
    override val description: String? = super.description
    override val previewText = javaClass.getResource("/templates/inlay-hint-lambda.vk")?.readText();
    override fun createSettings() = LambdaHintSetting()

    /// 不知道干嘛的 显示在
    /// Editor > Inlay Hints > Types
    override fun createConfigurable(settings: LambdaHintSetting): LambdaHintSettingPanel {
        return LambdaHintSettingPanel(settings)
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: LambdaHintSetting, sink: InlayHintsSink): LambdaHintCollector {
        return LambdaHintCollector(settings)
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



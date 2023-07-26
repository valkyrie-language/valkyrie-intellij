package valkyrie.ide.hint.type

import com.intellij.codeInsight.hints.*
import com.intellij.lang.Language
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage

//import valkyrie.language.psi_node.*

@Suppress("UnstableApiUsage", "PropertyName")
class TypeHintProvider : InlayHintsProvider<TypeHintSetting> {
    override val name = ValkyrieBundle.message("inlay.type.group.name")
    override val group = InlayGroup.TYPES_GROUP
    override val key: SettingsKey<TypeHintSetting> = SettingsKey("type")
    override val description = super.description
    override val previewText = null;
    override fun isLanguageSupported(language: Language): Boolean {
        return language is ValkyrieLanguage
    }

    override fun createSettings(): TypeHintSetting = TypeHintSetting()

    override fun getCaseDescription(case: ImmediateConfigurable.Case): String {
        return ValkyrieBundle.message("hint.${case.id}.detail")
    }

    /// 不知道干嘛的 显示在
    /// Editor > Inlay Hints > Types
    override fun createConfigurable(settings: TypeHintSetting): ImmediateConfigurable {
        return TypeHintSettingPanel(settings)
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: TypeHintSetting, sink: InlayHintsSink): InlayHintsCollector {
        return TypeHintCollector(settings)
    }

    override fun getProperty(key: String): String {
        return "ValkyrieInlayProvider.getProperty"
    }
}


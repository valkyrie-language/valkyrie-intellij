package valkyrie.ide.hint.type

import com.intellij.codeInsight.hints.*
import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import com.intellij.lang.Language
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage

//import valkyrie.language.psi_node.*


class TypeHintProvider : InlayHintsProvider<TypeHintSetting> {
    override val name = ValkyrieBundle.message("inlay.type.name")
    override val description = ValkyrieBundle.message("inlay.type.detail")
    override val group = InlayGroup.TYPES_GROUP
    override val key: SettingsKey<TypeHintSetting> = SettingsKey("type")
    override val previewText = null;
    override fun isLanguageSupported(language: Language): Boolean {
        return language is ValkyrieLanguage
    }

    override fun createSettings(): TypeHintSetting {
        return TypeHintSetting()
    }

    /** Editor > Inlay Hints > Types */
    override fun createConfigurable(settings: TypeHintSetting): ImmediateConfigurable {
        return TypeHintSettingPanel(settings)
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: TypeHintSetting, sink: InlayHintsSink): InlayHintsCollector {
        return TypeHintCollector(settings)
    }

    override fun getCaseDescription(case: Case): String {
        return ValkyrieBundle.message("inlay.${case.id}.detail")
    }
}


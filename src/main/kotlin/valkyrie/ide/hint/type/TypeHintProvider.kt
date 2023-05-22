package valkyrie.ide.hint.type

import com.intellij.codeInsight.hints.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle

//import valkyrie.language.psi_node.*

@Suppress("UnstableApiUsage", "PropertyName")
class TypeHintProvider : InlayHintsProvider<TypeHintSetting> {

    private val rootKey = "v.type.hints";

    override val name: String = ValkyrieBundle.message("inlay.type.group.name")
    override val group: InlayGroup = InlayGroup.TYPES_GROUP
    override val key: SettingsKey<TypeHintSetting>
        get() {
            return SettingsKey(rootKey)
        }
    override val description: String?
        get() {
            return super.description
        }

    override fun createSettings(): TypeHintSetting = TypeHintSetting()

    /// 显示在
    /// Editor > Inlay Hints > Types
    override val previewText: String = """
        let number = 1;
        let string = "string";
        let boolean = true;
        let array = [1, 2, 3];
        """.trimIndent()


    /// 不知道干嘛的 显示在
    /// Editor > Inlay Hints > Types
    override fun createConfigurable(settings: TypeHintSetting): ImmediateConfigurable {
        return TypeHintSettingPanel(settings)
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: TypeHintSetting, sink: InlayHintsSink): InlayHintsCollector {
        return TypeHintCollector(settings)
    }

    // todo: getCasePreview
    override fun getCaseDescription(case: ImmediateConfigurable.Case): String {
        //return ValkyrieBundle.message(case.id)
        return case.id
    }

    override fun getProperty(key: String): String {
        return "ValkyrieInlayProvider.getProperty"
    }


}


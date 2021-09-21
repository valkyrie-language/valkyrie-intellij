package valkyrie.ide.hint

import com.intellij.codeInsight.hints.*
import com.intellij.codeInsight.hints.presentation.PresentationFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.ui.dsl.builder.panel
import valkyrie.language.ValkyrieBundle
import valkyrie.language.psi_node.*
import javax.swing.JComponent

@Suppress("UnstableApiUsage")
class ValkyrieInlayTypeHint : InlayHintsProvider<ValkyrieInlayTypeHint.InlayTypeSetting> {
    data class InlayTypeSetting(
        var showObviousType: Boolean = false,
        var showForLoopType: Boolean = true,
        var showDefineParameterType: Boolean = true,
        var showDefineReturnType: Boolean = true,
        var showDefineEffectType: Boolean = true,
        var showClassFieldType: Boolean = true,
        var showBitFlagType: Boolean = true,
    )

    private val rootKey = "v.type.hints";

    override val name: String = ValkyrieBundle.message("inlay.type.group.name")
    override val group: InlayGroup = InlayGroup.TYPES_GROUP
    override val key: SettingsKey<InlayTypeSetting>
        get() {
            return SettingsKey(rootKey)
        }
    override val description: String?
        get() {
            return super.description
        }

    override fun createSettings(): InlayTypeSetting = InlayTypeSetting()

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
    override fun createConfigurable(settings: InlayTypeSetting): ImmediateConfigurable {
        return object : ImmediateConfigurable {
            override val mainCheckboxText: String
                get() = super.mainCheckboxText
            override val cases: List<ImmediateConfigurable.Case>
                get() = listOf(
                    ImmediateConfigurable.Case(
                        "Obvious types",
                        "hints.type.obvious",
                        settings::showObviousType, ValkyrieBundle.message("view.PropertiesGrouper")
                    ),
                    ImmediateConfigurable.Case(
                        "For loop types",
                        "hints.type.for",
                        settings::showForLoopType,
                        ValkyrieBundle.message("view.PropertiesGrouper")
                    ),
                    ImmediateConfigurable.Case(
                        "Define return types",
                        "hints.type.define",
                        settings::showDefineReturnType,
                        ValkyrieBundle.message("view.PropertiesGrouper")
                    ),
                    ImmediateConfigurable.Case(
                        "Bitflag types",
                        "hints.type.bitflag",
                        settings::showBitFlagType,
                        ValkyrieBundle.message("view.PropertiesGrouper")
                    ),
                )

            override fun reset() {
                super.reset()
            }

            override fun createComponent(listener: ChangeListener): JComponent {
                return panel {
                    row {
                        checkBox("Show obvious type").applyToComponent {
                            isSelected = settings.showObviousType
                            addActionListener {
                                settings.showObviousType = isSelected
                                listener.settingsChanged()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: InlayTypeSetting, sink: InlayHintsSink): InlayHintsCollector {
        return InlayTypeHint(settings)
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


@Suppress("UnstableApiUsage")
private class InlayTypeHint(private val settings: ValkyrieInlayTypeHint.InlayTypeSetting) : InlayHintsCollector {
    override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
        val inlay = PresentationFactory(editor);
        fun inline(start: Int, text: String, split: String = ":") {
            sink.addInlineElement(
                start, true,
                // click then replace
                inlay.roundWithBackgroundAndSmallInset(inlay.smallTextWithoutBackground("$split $text")), false
            )
        }
        when {
            settings.showForLoopType && element is ValkyriePatternItemNode -> {
                inline(element.identifier.textRange.endOffset, "Unknown")
            }

            settings.showDefineParameterType && element is ValkyrieDefineItemNode -> {
                val id = element.identifier ?: return true;
                if (id.text == "self") {
                    // skip
                } else if (element.typeExpression == null) {
                    id.textRange?.let {
                        inline(it.endOffset, "Unknown")
                    }
                }
            }

            settings.showDefineReturnType && element is ValkyrieDefineStatementNode -> {
                if (element.typeExpression == null) {
                    element.defineTuple?.textRange?.let {
                        inline(it.endOffset, "Unknown", split = "⟶")
                    }
                }
            }

            settings.showClassFieldType && element is ValkyrieClassFieldNode -> {
                if (element.typeExpression == null) {
                    inline(element.nameIdentifier.textRange.endOffset, "Unknown", split = ":")
                }
            }

            settings.showBitFlagType && element is ValkyrieBitflagStatementNode -> {
                if (element.typeExpression == null) {
                    inline(element.identifier.textRange.endOffset, "u32")
                }
            }
        }
        return true
    }


}


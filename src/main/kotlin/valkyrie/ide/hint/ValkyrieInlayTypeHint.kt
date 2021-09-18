package valkyrie.ide.hint

import com.intellij.codeInsight.hints.*
import com.intellij.codeInsight.hints.presentation.PresentationFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.ui.dsl.builder.panel
import valkyrie.ValkyrieBundle
import valkyrie.language.psi_node.ValkyrieBitflagStatementNode
import valkyrie.language.psi_node.ValkyrieDefineStatementNode
import valkyrie.language.psi_node.ValkyriePatternItemNode
import javax.swing.JComponent


@Suppress("UnstableApiUsage")
class ValkyrieInlayTypeHint : InlayHintsProvider<InlayTypeSetting> {
    private val rootKey = "v.type.hints";

    override val name: String = ValkyrieBundle.message("view.PropertiesGrouper")
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
                        "let type", "hints.type.let", settings::showForLambdas, ValkyrieBundle.message("view.PropertiesGrouper")
                    ),
                    ImmediateConfigurable.Case(
                        "def type", "hints.type.def", settings::showForLambdas, ValkyrieBundle.message("view.PropertiesGrouper")
                    ),
                )

            override fun reset() {
                super.reset()
            }

            override fun createComponent(listener: ChangeListener): JComponent {
                return panel {
                    row {
                        checkBox("Show bit flag type").applyToComponent {
                            isSelected = settings.showBitFlagType
                            addActionListener {
                                settings.showBitFlagType = isSelected
                                listener.settingsChanged()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: InlayTypeSetting, sink: InlayHintsSink): InlayHintsCollector? {
        return InlayTypeHint(settings)
    }

    // todo: getCasePreview
    override fun getCaseDescription(case: ImmediateConfigurable.Case): String? {
        return "getCaseDescription"
    }

    override fun getProperty(key: String): String? {
        return "ValkyrieInlayProvider.getProperty"
    }
}

data class InlayTypeSetting(
    var showBitFlagType: Boolean = true,
    var showForVariables: Boolean = true,
    var showForLambdas: Boolean = true,
    var showForIterators: Boolean = true,
    var showPatternItemType: Boolean = true,
    var showObviousTypes: Boolean = false,
)

@Suppress("UnstableApiUsage")
private class InlayTypeHint(private val settings: InlayTypeSetting) : InlayHintsCollector {
    override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
        val inlay = PresentationFactory(editor);
        fun inline(start: Int, text: String) {
            sink.addInlineElement(
                start,
                true,
                // click then replace
                inlay.roundWithBackgroundAndSmallInset(inlay.smallTextWithoutBackground(": $text")),
                false
            )
        }
        when {
            settings.showPatternItemType && element is ValkyriePatternItemNode -> {
                inline(element.identifier.textRange.endOffset, "Unknown")
            }

            element is ValkyrieDefineStatementNode -> {
                if (element.typeExpression == null) {
                    element.defineTuple?.textRange?.let {
                        inline(it.endOffset, "Unknown")
                    }
                }
            }

            element is ValkyrieBitflagStatementNode -> {
                if (element.typeExpression == null) {
                    inline(element.identifier.textRange.endOffset, "u32")
                }
            }
        }
        return true
    }


}


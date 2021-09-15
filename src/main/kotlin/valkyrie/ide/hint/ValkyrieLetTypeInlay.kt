package valkyrie.ide.hint

import com.intellij.codeInsight.hints.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.ui.dsl.builder.panel
import valkyrie.ValkyrieBundle
import javax.swing.JComponent


@Suppress("UnstableApiUsage")
class ValkyrieLetTypeInlay : InlayHintsProvider<ValkyrieInlaySettings> {
    private val rootKey = "v.type.hints";

    override val name: String = ValkyrieBundle.message("view.PropertiesGrouper")
    override val group: InlayGroup = InlayGroup.TYPES_GROUP
    override val key: SettingsKey<ValkyrieInlaySettings>
        get() {
            return SettingsKey(rootKey)
        }
    override val description: String?
        get() {
            return super.description
        }

    override fun createSettings(): ValkyrieInlaySettings = ValkyrieInlaySettings()

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
    override fun createConfigurable(settings: ValkyrieInlaySettings): ImmediateConfigurable {
        return object : ImmediateConfigurable {
            override val mainCheckboxText: String
                get() = super.mainCheckboxText
            override val cases: List<ImmediateConfigurable.Case>
                get() = listOf(
                    ImmediateConfigurable.Case(
                        "let type",
                        "hints.type.let",
                        settings::showForLambdas,
                        ValkyrieBundle.message("view.PropertiesGrouper")
                    ),
                    ImmediateConfigurable.Case(
                        "def type",
                        "hints.type.def",
                        settings::showForLambdas,
                        ValkyrieBundle.message("view.PropertiesGrouper")
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

    // todo: getCasePreview
    override fun getCaseDescription(case: ImmediateConfigurable.Case): String? {
        return "getCaseDescription"
    }

    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: ValkyrieInlaySettings, sink: InlayHintsSink): InlayHintsCollector? {
        return object : InlayHintsCollector {
            override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
                return true
            }
        }
    }

//    override fun getProperty(key: String): String? {
//        return "ValkyrieInlayProvider.getProperty"
//    }


}


package valkyrie.project.facet.iris

import com.intellij.facet.ui.FacetEditorContext
import com.intellij.facet.ui.FacetEditorTab
import com.intellij.ui.dsl.builder.panel
import valkyrie.language.ValkyrieBundle
import javax.swing.JComponent

class ValkyrieFacetConfigDependency(val context: FacetEditorContext?) : FacetEditorTab() {
    private var targetPlatform: String = "JVM 1.8"
    private var reportCompilerWarnings: Boolean = true
    private var role: LegionRoleData = LegionRoleData()
    private var additionalCommandLineParameters: String = ""

    override fun createComponent(): JComponent {
        val panel = panel {
            // 输出目录
            row {
                label("Path:")
                textFieldWithBrowseButton(
                    browseDialogTitle = "Select Output Directory",
                    fileChosen = { selectedFile -> selectedFile.path }
                )
                    .applyToComponent {

                    }
            }

            row {
                label("Role:")
                comboBox(role.roleNameAvailable()).applyToComponent {
                    selectedItem = role.roleName
                    addActionListener {
                        role.roleName = selectedItem?.toString()
                    }
                }
            }

            row {
                label("Version:")
                comboBox(role.roleVersionAvailable()).applyToComponent {
                    selectedItem = role.roleVersion
                    addActionListener {
                        role.roleVersion = selectedItem?.toString()
                    }
                }
            }

            row {
                label("Compiler:")
                comboBox(role.roleVersionAvailable()).applyToComponent {
                    selectedItem = role.roleVersion
                    addActionListener {
                        role.roleVersion = selectedItem?.toString()
                    }
                }
            }

            row {
                label("Platform:")
                comboBox(listOf("Valkyrie Runtime", "WASI Preview 2")).applyToComponent {
                    selectedItem = targetPlatform
                    addActionListener {
                        targetPlatform = selectedItem.toString()
                    }
                }
            }

            row {
                checkBox("Report compiler warnings").applyToComponent {
                    isSelected = reportCompilerWarnings
                    addActionListener {
                        reportCompilerWarnings = isSelected
                    }
                }
            }

            row {
                label("Additional Command Line Parameters:")
                textField().applyToComponent {
                    text = additionalCommandLineParameters
                    addActionListener {
                        additionalCommandLineParameters = text
                    }
                }
            }


        }

        return panel
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun getDisplayName(): String {
        return ValkyrieBundle.message("facet.panel.dependency")
    }

    override fun getHelpTopic(): String? {
        return "getHelpTopic"
    }

    override fun reset() {
        super.reset()
    }

    override fun apply() {
        super.apply()
    }


}
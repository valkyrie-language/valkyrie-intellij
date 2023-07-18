package valkyrie.project.facet.iris

import com.intellij.facet.ui.FacetEditorContext
import com.intellij.facet.ui.FacetEditorTab
import com.intellij.ui.dsl.builder.panel
import valkyrie.language.ValkyrieBundle
import javax.swing.JComponent

class LegionRoleData {
    var roleName: String? = "Saber"
    var roleVersion: String? = null

    constructor()

    fun roleNameAvailable(): List<String> {
        return listOf(
            "Saber",
            "Browser",
            "Caster",
            "Archer",
            "Swordmaster",
            "Sorcerer",
            "Warrior",
            "Mage",
            "Assassin",
            "Ranger",
            "Bard",
            "Rogue",
            "Ninja",
            "Samurai",
            "Monk",
            "Priest",
            "Wizard",
            "Warlock",
            "Druid",
            "Paladin",
            "Dark Knight"
        )
    }

    fun roleVersionAvailable(): List<String> {
        return listOf("2024.1.0.0", "2024.0.0.0", "nightly (2024.4.1)")
    }

}

class ValkyrieFacetConfigFramework(val context: FacetEditorContext?) : FacetEditorTab() {
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
        return ValkyrieBundle.message("facet.panel.framework")
    }

    override fun getHelpTopic(): String? {
        return "getHelpTopic"
    }

    override fun getDisplayNameFast(): String? {
        return "super.getDisplayNameFast()"
    }

    override fun reset() {
        super.reset()
    }

    override fun apply() {
        super.apply()
    }
}

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

    override fun getDisplayNameFast(): String? {
        return "super.getDisplayNameFast()"
    }

    override fun reset() {
        super.reset()
    }

    override fun apply() {
        super.apply()
    }


}
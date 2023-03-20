package valkyrie.ide.project.library

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.libraries.LibraryKind
import com.intellij.openapi.roots.ui.configuration.LibrarySettingsProvider
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class ValkyrieLibrarySettings : LibrarySettingsProvider() {
    override fun getLibraryKind(): LibraryKind = ValkyrieLibraryType.kind
    override fun getAdditionalSettingsConfigurable(project: Project?): Configurable {
        return LibrarySettingConfigurable()
    }
}

private class LibrarySettingConfigurable : Configurable {
    override fun createComponent(): JComponent? {
        return panel {
            row("LibrarySettingConfigurable.createComponent") {
                textField()
            }
        }
    }

    override fun isModified(): Boolean {
        return true
    }

    override fun apply() {

    }

    override fun getDisplayName(): String {
        return "LibrarySettingConfigurable.getDisplayName"
    }

    override fun getHelpTopic(): String? {
        return "LibrarySettingConfigurable.getHelpTopic"
    }

    override fun focusOn(label: String) {

    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return super.getPreferredFocusedComponent()
    }

    override fun disposeUIResources() {
        super.disposeUIResources()
    }
}
package valkyrie.ide.project.library

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.libraries.LibraryKind
import com.intellij.openapi.roots.ui.configuration.LibrarySettingsProvider
import javax.swing.JComponent

class ValkyrieLibrarySettings : LibrarySettingsProvider() {
    override fun getLibraryKind(): LibraryKind {
        return ValkyrieLibraryType.kind
    }

    override fun getAdditionalSettingsConfigurable(project: Project?): Configurable {
        return LibrarySettingConfigurable()
    }
}

private class LibrarySettingConfigurable : Configurable {
    override fun createComponent(): JComponent? {
        return null
    }

    override fun isModified(): Boolean {
        return true
    }

    override fun apply() {

    }

    override fun getDisplayName(): String {
        return "LibrarySettingConfigurable"
    }
}
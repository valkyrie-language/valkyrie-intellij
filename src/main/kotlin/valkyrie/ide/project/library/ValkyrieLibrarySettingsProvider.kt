package valkyrie.ide.project.`package`.library

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.libraries.LibraryKind
import com.intellij.openapi.roots.ui.configuration.LibrarySettingsProvider

class ValkyrieLibrarySettingsProvider : LibrarySettingsProvider() {
    override fun getLibraryKind(): LibraryKind {
        TODO("Not yet implemented")
    }

    override fun getAdditionalSettingsConfigurable(project: Project?): Configurable {
        TODO("Not yet implemented")
    }
}
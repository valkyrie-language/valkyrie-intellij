package valkyrie.project

import com.intellij.facet.ui.ValidationResult
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.DirectoryProjectGenerator
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class directoryProjectGenerator : DirectoryProjectGenerator<Any?> {
    override fun getName(): String {
        return "directoryProjectGenerator"
    }

    override fun getLogo(): Icon? {
        return ValkyrieIconProvider.Instance.Valkyrie
    }

    override fun generateProject(project: Project, baseDir: VirtualFile, settings: Any, module: Module) {

    }

    override fun validate(baseDirPath: String): ValidationResult {
        return ValidationResult.OK
    }
}

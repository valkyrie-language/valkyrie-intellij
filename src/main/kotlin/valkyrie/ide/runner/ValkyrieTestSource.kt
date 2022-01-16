package valkyrie.ide.runner

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.TestSourcesFilter
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.findPsiFile
import valkyrie.language.ast.ValkyrieNamespaceStatement
import valkyrie.language.file.ValkyrieFileType
import valkyrie.language.psi.childOfType

class ValkyrieTestSource : TestSourcesFilter() {
    override fun isTestSource(file: VirtualFile, project: Project): Boolean {
        if (file.fileType != ValkyrieFileType) return false
        return file.findPsiFile(project)?.childOfType<ValkyrieNamespaceStatement>()?.isTestFile() ?: false
    }
}
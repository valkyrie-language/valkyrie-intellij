package valkyrie.ide.runner

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.TestSourcesFilter
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.findPsiFile
import valkyrie.language.ast.isTestFile
import valkyrie.language.file.ValkyrieFileType
import valkyrie.language.psi.childOfType
import valkyrie.language.psi_node.ValkyrieNamespaceStatementNode

class ValkyrieTestSource : TestSourcesFilter() {
    override fun isTestSource(file: VirtualFile, project: Project): Boolean {
        if (file.fileType != ValkyrieFileType) return false
        return file.findPsiFile(project)?.childOfType<ValkyrieNamespaceStatementNode>().isTestFile()
    }
}
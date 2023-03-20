package valkyrie.ide.runner

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.TestSourcesFilter
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.findPsiFile
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.file.ValkyrieFileType

class ValkyrieTestSource : TestSourcesFilter() {
    override fun isTestSource(file: VirtualFile, project: Project): Boolean {
        if (file.fileType != ValkyrieFileType) return false
        val root = file.findPsiFile(project) as? ValkyrieFileNode;
        return root?.namespace?.isTestFile() ?: false
    }
}
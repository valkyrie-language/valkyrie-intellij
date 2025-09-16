package valkyrie.psi.nodes

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import valkyrie.language.ValkyrieIcons
import valkyrie.language.ValkyrieComponentLanguage
import valkyrie.language.file.ValkyrieComponentFileType

/**
 * Valkyrie Component 文件 PSI 实现
 */
class ValkyrieComponentFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieComponentLanguage) {
    
    override fun getFileType(): FileType = ValkyrieComponentFileType.INSTANCE
    
    override fun toString(): String = "Valkyrie Component File"
    
    override fun getPresentation(): ItemPresentation {
        val fileName = name ?: "<unnamed>"
        return PresentationData(
            fileName,
            "Valkyrie Component file",
            ValkyrieIcons.FILE,
            null
        )
    }
}
package valkyrie.psi.nodes

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import valkyrie.language.ValkyrieIcons
import valkyrie.language.dialect_std.ValkyrieLanguage
import valkyrie.language.dialect_std.ValkyrieFileType

/**
 * Valkyrie 文件 PSI 实现
 */
class ValkyrieFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage) {
    
    override fun getFileType(): FileType = ValkyrieFileType.INSTANCE
    
    override fun toString(): String = "Valkyrie File"
    
    override fun getPresentation(): ItemPresentation {
        val fileName = name ?: "<unnamed>"
        return PresentationData(
            fileName,
            "Valkyrie file",
            ValkyrieIcons.FILE,
            null
        )
    }
}
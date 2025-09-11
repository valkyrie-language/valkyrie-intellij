package valkyrie.psi.nodes

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieFileType

/**
 * Valkyrie 文件 PSI 实现
 */
class ValkyrieFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage.INSTANCE) {
    
    override fun getFileType(): FileType = ValkyrieFileType.INSTANCE
    
    override fun toString(): String = "Valkyrie File"
}
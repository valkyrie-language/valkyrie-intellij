package valkyrie.psi.nodes

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import valkyrie.language.ValkyrieIcons
import valkyrie.language.ValkyrieTemplateLanguage
import valkyrie.language.file.ValkyrieTemplateFileType

/**
 * Valkyrie 模板文件 PSI 实现
 */
class ValkyrieTemplateFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieTemplateLanguage) {
    
    override fun getFileType(): FileType = ValkyrieTemplateFileType.INSTANCE
    
    override fun toString(): String = "Valkyrie Template File"
    
    override fun getPresentation(): ItemPresentation {
        val fileName = name ?: "<unnamed>"
        return PresentationData(
            fileName,
            "Valkyrie template file",
            ValkyrieIcons.FILE,
            null
        )
    }
}
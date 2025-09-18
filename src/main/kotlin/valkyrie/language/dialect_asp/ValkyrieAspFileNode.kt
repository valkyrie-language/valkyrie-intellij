package valkyrie.language.dialect_asp

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import valkyrie.language.ValkyrieIcons

/**
 * Valkyrie 模板文件 PSI 实现
 */
class ValkyrieAspFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieAspLanguage) {

    override fun getFileType(): FileType = ValkyrieAspFileType.INSTANCE

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
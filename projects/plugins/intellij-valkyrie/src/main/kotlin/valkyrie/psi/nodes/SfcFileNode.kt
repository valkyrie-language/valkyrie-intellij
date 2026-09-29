package valkyrie.psi.nodes

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import valkyrie.language.ValkyrieIcons
import valkyrie.language.dialect_sfc.ValkyrieSfcFileType
import valkyrie.language.dialect_sfc.ValkyrieSfcLanguage

/**
 * Valkyrie SFC 文件 PSI 实现
 */
class SfcFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieSfcLanguage.INSTANCE) {

    override fun getFileType(): FileType = ValkyrieSfcFileType.INSTANCE

    override fun getPresentation(): ItemPresentation {
        val fileName = name ?: "<unnamed>"
        return PresentationData(
            fileName,
            "Valkyrie SFC file",
            ValkyrieIcons.FILE,
            null
        )
    }

    override fun toString(): String = "SfcFileNode"
}

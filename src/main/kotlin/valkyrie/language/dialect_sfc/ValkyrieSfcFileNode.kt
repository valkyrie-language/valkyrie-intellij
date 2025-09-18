package valkyrie.language.dialect_sfc

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import valkyrie.language.ValkyrieIcons

/**
 * Valkyrie Component 文件 PSI 实现
 */
class ValkyrieSfcFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieSfcLanguage) {

    override fun getFileType(): FileType = ValkyrieSfcFileType.INSTANCE

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
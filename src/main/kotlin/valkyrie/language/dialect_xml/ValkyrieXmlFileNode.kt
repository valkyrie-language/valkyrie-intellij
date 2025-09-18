package valkyrie.language.dialect_xml

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import valkyrie.language.ValkyrieIcons

/**
 * Valkyrie XML 文件 PSI 实现
 */
class ValkyrieXmlFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieXmlLanguage) {

    override fun getFileType(): FileType = ValkyrieXmlFileType.INSTANCE

    override fun toString(): String = "Valkyrie XML File"

    override fun getPresentation(): ItemPresentation {
        val fileName = name ?: "<unnamed>"
        return PresentationData(
            fileName,
            "Valkyrie XML file",
            ValkyrieIcons.FILE,
            null
        )
    }
}
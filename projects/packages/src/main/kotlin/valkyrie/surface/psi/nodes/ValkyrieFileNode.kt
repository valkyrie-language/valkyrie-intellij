package valkyrie.surface.psi.nodes

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import valkyrie.surface.file.ValkyrieIcons
import valkyrie.surface.file.ValkyrieFileType
import valkyrie.surface.file.ValkyrieLanguage

/**
 * Valkyrie 文件 PSI 实现
 */
class ValkyrieFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage.INSTANCE) {

    override fun getFileType(): FileType = ValkyrieFileType.INSTANCE

    override fun getPresentation(): ItemPresentation {
        val fileName = name ?: "<unnamed>"
        return PresentationData(
            fileName,
            "Valkyrie file",
            ValkyrieIcons.FILE,
            null
        )
    }

    override fun toString(): String = "ValkyrieFileNode"
}
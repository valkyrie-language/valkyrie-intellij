package awsl.surface.file

import awsl.surface.file.AwslBundle
import awsl.surface.file.AwslLanguage
import awsl.editing.structure.AwslIconProvider
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class AwpFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, awsl.surface.file.AwslLanguage.INSTANCE) {
    override fun getFileType(): FileType = AwpFileType.INSTANCE

    override fun toString(): String = awsl.surface.file.AwslBundle.message("action.create_file")
}

class AwpFileType private constructor() : LanguageFileType(awsl.surface.file.AwslLanguage.INSTANCE) {
    override fun getName(): String = "AWSL"

    override fun getDisplayName(): String = awsl.surface.file.AwslBundle.message("filetype.awsl.display")

    override fun getDescription(): String = awsl.surface.file.AwslBundle.message("filetype.awsl.description")

    override fun getDefaultExtension(): String = "awp"

    override fun getIcon(): Icon = AwslIconProvider.AwslFile

    companion object {
        @JvmStatic
        val INSTANCE = AwpFileType()
    }
}
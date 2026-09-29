package awsl.surface.file

import awsl.surface.file.AwslBundle
import awsl.surface.file.AwslLanguage
import awsl.editing.structure.AwslIconProvider
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class AwslFileType private constructor() : LanguageFileType(awsl.surface.file.AwslLanguage.INSTANCE) {
    override fun getName(): String = fileID

    override fun getDisplayName(): String = fileName

    override fun getDescription(): String = fileDescription

    override fun getDefaultExtension(): String = fileExtension

    override fun getIcon(): Icon = AwslIconProvider.AwslFile

    companion object {
        @JvmStatic
        val INSTANCE = AwslFileType()
        const val fileID = "AWSL";
        const val fileExtension = "awsl;awc;"
        val fileName = awsl.surface.file.AwslBundle.message("filetype.awsl.name")
        val fileDescription = awsl.surface.file.AwslBundle.message("filetype.awsl.description")
    }
}

class AwslFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, awsl.surface.file.AwslLanguage.INSTANCE) {
    override fun getFileType(): FileType = AwslFileType.INSTANCE

    override fun toString(): String = AwslFileType.fileName
}

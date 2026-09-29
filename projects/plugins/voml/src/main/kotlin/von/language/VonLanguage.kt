package von.language

import voml.language.VomlBundle
import von.ide.icons.VonIcons
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class VonLanguage private constructor() : Language("VON") {
    companion object {
        @JvmStatic
        val INSTANCE = VonLanguage()
    }
}

class VonFileType private constructor() : LanguageFileType(VonLanguage.INSTANCE) {
    override fun getName(): String = VomlBundle.message("filetype.von.name")

    override fun getDescription(): String = VomlBundle.message("filetype.von.description")

    override fun getDefaultExtension(): String = "von"

    override fun getIcon(): Icon = VonIcons.FILE

    companion object {
        @JvmStatic
        val INSTANCE = VonFileType()
    }
}

class VonFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, VonLanguage.INSTANCE) {
    override fun getFileType(): FileType = VonFileType.INSTANCE

    override fun toString(): String = VomlBundle.message("filetype.von.create")
}

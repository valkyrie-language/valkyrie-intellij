package valkyrie.language.file

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.Nls
import valkyrie.language.ValkyrieIcons
import valkyrie.language.ValkyrieTemplateLanguage
import javax.swing.Icon

/**
 * Valkyrie 模板文件类型定义
 */
class ValkyrieTemplateFileType private constructor() : LanguageFileType(ValkyrieTemplateLanguage) {
    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieTemplateFileType()
    }

    override fun getName(): String = "valkyrie-template"

    override fun getDisplayName(): @Nls String {
        return "Valkyrie Template"
    }

    override fun getDescription(): String = "Valkyrie Template File"

    override fun getDefaultExtension(): String = "vkt"

    override fun isReadOnly(): Boolean {
        return super.isReadOnly()
    }

    override fun getIcon(): Icon? = ValkyrieIcons.FILE
}
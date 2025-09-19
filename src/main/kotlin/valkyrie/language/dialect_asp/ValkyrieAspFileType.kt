package valkyrie.language.dialect_asp

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.Nls
import valkyrie.language.ValkyrieIcons
import javax.swing.Icon

/**
 * Valkyrie 模板文件类型定义
 */
class ValkyrieAspFileType private constructor() : LanguageFileType(ValkyrieAspLanguage) {
    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieAspFileType()
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
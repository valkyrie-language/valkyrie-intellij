package valkyrie.language.dialect_markup

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.Nls
import valkyrie.language.ValkyrieIcons
import javax.swing.Icon

/**
 * Valkyrie Mark 文件类型定义
 */
class ValkyrieMarkFileType private constructor() : LanguageFileType(ValkyrieMarkLanguage) {
    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieMarkFileType()
    }

    override fun getName(): String = "valkyrieMark"

    override fun getDisplayName(): @Nls String {
        return "Valkyrie Mark"
    }

    override fun getDescription(): String = "Valkyrie Mark File"

    override fun getDefaultExtension(): String = "vkm"

    override fun isReadOnly(): Boolean {
        return super.isReadOnly()
    }

    override fun getIcon(): Icon? = ValkyrieIcons.FILE
}
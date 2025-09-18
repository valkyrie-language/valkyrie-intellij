package valkyrie.language.dialect_std

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.Nls
import valkyrie.language.ValkyrieIcons
import javax.swing.Icon

/**
 * Valkyrie 文件类型定义
 */
class ValkyrieFileType private constructor() : LanguageFileType(ValkyrieLanguage) {
    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieFileType()
    }

    override fun getName(): String = "valkyrie"

    override fun getDisplayName(): @Nls String {
        return "Valkyrie"
    }

    override fun getDescription(): String = "Valkyrie Language File"

    override fun getDefaultExtension(): String = "vk"

    override fun isReadOnly(): Boolean {
        return super.isReadOnly()
    }

    override fun getIcon(): Icon? = ValkyrieIcons.FILE
}
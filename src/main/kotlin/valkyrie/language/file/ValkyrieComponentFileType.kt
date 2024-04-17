package valkyrie.language.file

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.Nls
import valkyrie.language.ValkyrieIcons
import valkyrie.language.ValkyrieComponentLanguage
import javax.swing.Icon

/**
 * Valkyrie Component 文件类型定义
 */
class ValkyrieComponentFileType private constructor() : LanguageFileType(ValkyrieComponentLanguage) {
    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieComponentFileType()
    }

    override fun getName(): String = "valkyrie-component"

    override fun getDisplayName(): @Nls String {
        return "Valkyrie Component"
    }

    override fun getDescription(): String = "Valkyrie Component File"

    override fun getDefaultExtension(): String = "vkc"

    override fun isReadOnly(): Boolean {
        return super.isReadOnly()
    }

    override fun getIcon(): Icon? = ValkyrieIcons.FILE
}
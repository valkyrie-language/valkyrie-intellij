package valkyrie.language.dialect_sfc

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.Nls
import valkyrie.language.ValkyrieIcons
import javax.swing.Icon

/**
 * Valkyrie Component 文件类型定义
 */
class ValkyrieSfcFileType private constructor() : LanguageFileType(ValkyrieSfcLanguage) {
    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieSfcFileType()
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
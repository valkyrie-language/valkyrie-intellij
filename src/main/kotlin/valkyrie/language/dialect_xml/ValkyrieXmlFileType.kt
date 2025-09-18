package valkyrie.language.dialect_xml

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.Nls
import valkyrie.language.ValkyrieIcons
import javax.swing.Icon

/**
 * Valkyrie XML 文件类型定义
 */
class ValkyrieXmlFileType private constructor() : LanguageFileType(ValkyrieXmlLanguage) {
    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieXmlFileType()
    }

    override fun getName(): String = "valkyrie-xml"

    override fun getDisplayName(): @Nls String {
        return "Valkyrie XML"
    }

    override fun getDescription(): String = "Valkyrie XML File"

    override fun getDefaultExtension(): String = "vkx"

    override fun isReadOnly(): Boolean {
        return super.isReadOnly()
    }

    override fun getIcon(): Icon? = ValkyrieIcons.FILE
}
package valkyrie.language.file

import com.intellij.openapi.fileTypes.LanguageFileType
import valkyrie.language.ValkyrieLanguage
import javax.swing.Icon

/**
 * Valkyrie 文件类型定义
 */
class ValkyrieFileType private constructor() : LanguageFileType(ValkyrieLanguage.INSTANCE) {
    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieFileType()
    }

    override fun getName(): String = "Valkyrie"
    
    override fun getDescription(): String = "Valkyrie Language File"
    
    override fun getDefaultExtension(): String = "vk"
    
    override fun getIcon(): Icon? = ValkyrieIcons.FILE
}
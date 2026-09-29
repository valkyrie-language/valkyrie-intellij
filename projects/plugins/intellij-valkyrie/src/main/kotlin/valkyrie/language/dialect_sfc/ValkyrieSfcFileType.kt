package valkyrie.language.dialect_sfc

import com.intellij.openapi.fileTypes.LanguageFileType
import valkyrie.language.ValkyrieIcons
import valkyrie.language.dialect_sfc.ValkyrieSfcLanguage

/**
 * Valkyrie SFC 文件类型
 */
class ValkyrieSfcFileType private constructor() : LanguageFileType(ValkyrieSfcLanguage.INSTANCE) {
    companion object {
        val INSTANCE = ValkyrieSfcFileType()
    }

    override fun getName(): String = "Valkyrie SFC"
    override fun getDescription(): String = "Valkyrie Single File Component"
    override fun getDefaultExtension(): String = "vx"
    override fun getIcon() = ValkyrieIcons.FILE
}

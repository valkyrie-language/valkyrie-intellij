package valkyrie.language.dialect_sfc

import com.intellij.lang.Language

/**
 * Valkyrie SFC 语言定义
 */
class ValkyrieSfcLanguage private constructor() : Language("valkyrie-component") {
    companion object {
        val INSTANCE = ValkyrieSfcLanguage()
    }
}

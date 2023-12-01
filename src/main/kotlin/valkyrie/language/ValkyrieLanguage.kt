package valkyrie.language

import com.intellij.lang.Language

/**
 * Valkyrie 语言定义
 */
class ValkyrieLanguage private constructor() : Language("valkyrie") {
    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieLanguage()
    }

    override fun getDisplayName(): String = "Valkyrie"
    
    override fun isCaseSensitive(): Boolean = true
}
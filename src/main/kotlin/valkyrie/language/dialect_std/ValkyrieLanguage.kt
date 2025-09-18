package valkyrie.language.dialect_std

import com.intellij.lang.Language

/**
 * Valkyrie 语言定义
 */
object ValkyrieLanguage : Language("valkyrie") {
    
    override fun getDisplayName(): String = "Valkyrie"
    
    override fun isCaseSensitive(): Boolean = true
}
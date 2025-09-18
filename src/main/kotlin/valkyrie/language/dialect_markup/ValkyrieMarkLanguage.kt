package valkyrie.language.dialect_markup

import com.intellij.lang.Language

/**
 * Valkyrie Mark 语言定义
 * 
 * 用于 .vkm 文件，支持可编程文档语法
 */
object ValkyrieMarkLanguage : Language("ValkyrieMark", "text/markdown") {
    
    override fun getDisplayName(): String = "Valkyrie Mark"
    
    override fun isCaseSensitive(): Boolean = true
}
package valkyrie.language.dialect_asp

import com.intellij.lang.Language

/**
 * Valkyrie 模板语言定义
 * 
 * 用于 .vkt 文件，支持在文本中嵌入 Valkyrie 代码块
 */
object ValkyrieAspLanguage : Language("valkyrie-template", "text/html") {
    
    override fun getDisplayName(): String = "Valkyrie Template"
    
    override fun isCaseSensitive(): Boolean = true
}
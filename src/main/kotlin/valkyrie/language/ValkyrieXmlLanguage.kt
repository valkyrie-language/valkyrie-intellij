package valkyrie.language

import com.intellij.lang.Language

/**
 * Valkyrie XML 语言定义
 * 
 * 用于 .vkx 文件，支持声明式 UI 语法
 */
object ValkyrieXmlLanguage : Language("valkyrie-xml", "application/xml") {
    
    override fun getDisplayName(): String = "Valkyrie XML"
    
    override fun isCaseSensitive(): Boolean = true
}
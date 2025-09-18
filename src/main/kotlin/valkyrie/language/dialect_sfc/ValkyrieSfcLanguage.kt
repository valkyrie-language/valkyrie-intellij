package valkyrie.language.dialect_sfc

import com.intellij.lang.Language

/**
 * Valkyrie Component 语言定义
 * 
 * 用于 .vkc 文件，支持组件定义语法
 * 完全兼容 HTML void tags，支持任意 HTML 复制粘贴
 */
object ValkyrieSfcLanguage : Language("valkyrie-component", "text/html") {
    
    override fun getDisplayName(): String = "Valkyrie Component"
    
    override fun isCaseSensitive(): Boolean = true
}
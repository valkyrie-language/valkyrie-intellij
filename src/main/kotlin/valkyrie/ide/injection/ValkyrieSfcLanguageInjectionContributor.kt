package valkyrie.ide.injection

import com.intellij.lang.Language
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement
import com.intellij.psi.xml.XmlTag
import valkyrie.psi.parsers.ValkyrieTypes
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * Valkyrie SFC 语言注入贡献者
 * 
 * 支持在 SFC 文件的 style 标签中根据 lang 属性注入对应的语言：
 * - CSS (默认)
 * - SCSS/Sass
 * - Less
 * - Stylus
 * - PostCSS
 */
class ValkyrieSfcLanguageInjectionContributor : LanguageInjectionContributor {
    
    companion object {
        // 支持的样式语言映射
        private val STYLE_LANGUAGE_MAP = mapOf(
            "css" to "CSS",
            "scss" to "SCSS",
            "sass" to "Sass",
            "less" to "Less", 
            "stylus" to "Stylus",
            "styl" to "Stylus",
            "postcss" to "PostCSS"
        )
        
        // 默认样式语言
        private const val DEFAULT_STYLE_LANGUAGE = "SCSS"
    }
    
    override fun getInjection(context: PsiElement): Injection? {
        // 检查是否是 SFC style 标签的内容
        if (isStyleContent(context)) {
            val styleTag = findParentStyleTag(context)
            if (styleTag != null) {
                val langAttribute = getLangAttribute(styleTag)
                val languageId = getStyleLanguageId(langAttribute)
                
                // 尝试获取对应的语言
                val language = Language.findLanguageByID(languageId)
                if (language != null) {
                    return SimpleInjection(
                        language,
                        "", // prefix
                        "", // suffix  
                        null // support id
                    )
                }
            }
        }
        
        return null
    }
    
    /**
     * 检查元素是否是 style 标签的内容
     */
    private fun isStyleContent(element: PsiElement): Boolean {
        // 检查父元素是否是 SFC_STYLE
        val parent = element.parent
        if (parent is ValkyrieElementNode) {
            return parent.node?.elementType == ValkyrieTypes.SFC_STYLE
        }
        
        return false
    }
    
    /**
     * 查找父级的 style 标签
     */
    private fun findParentStyleTag(element: PsiElement): PsiElement? {
        var current = element.parent
        while (current != null) {
            if (current is ValkyrieElementNode && current.node?.elementType == ValkyrieTypes.SFC_STYLE) {
                return current
            }
            if (current is XmlTag && current.name == "style") {
                return current
            }
            current = current.parent
        }
        return null
    }
    
    /**
     * 获取 style 标签的 lang 属性值
     */
    private fun getLangAttribute(styleTag: PsiElement): String? {
        when (styleTag) {
            is XmlTag -> {
                return styleTag.getAttributeValue("lang")
            }
            is ValkyrieElementNode -> {
                // 在 Valkyrie 的 AST 中查找 lang 属性
                // 遍历子节点寻找属性
                val children = styleTag.children
                for (child in children) {
                    if (child.text.contains("lang=")) {
                        // 简单的属性值提取
                        val text = child.text
                        val langMatch = Regex("""lang\s*=\s*['"]([^'"]+)['"]""").find(text)
                        return langMatch?.groupValues?.get(1)
                    }
                }
            }
        }
        return null
    }
    
    /**
     * 根据 lang 属性值获取对应的语言 ID
     */
    private fun getStyleLanguageId(langAttribute: String?): String {
        if (langAttribute.isNullOrBlank()) {
            return DEFAULT_STYLE_LANGUAGE
        }
        
        val normalizedLang = langAttribute.lowercase().trim()
        return STYLE_LANGUAGE_MAP[normalizedLang] ?: DEFAULT_STYLE_LANGUAGE
    }
}
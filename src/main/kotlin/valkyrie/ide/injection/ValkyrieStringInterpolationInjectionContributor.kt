package valkyrie.ide.injection

import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.parsers.ValkyrieTypes
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * Valkyrie 字符串插值语言注入贡献者
 * 
 * 支持在 Valkyrie 字符串字面量中注入 Valkyrie 语言，用于插值表达式：
 * - 双引号字符串: "value: ${expression}"
 * - 反引号字符串: `value: ${expression}`
 */
class ValkyrieStringInterpolationInjectionContributor : LanguageInjectionContributor {
    
    companion object {
        // 支持插值的字符串前缀
        private val INTERPOLATION_PREFIXES = setOf("\"", "`")
    }
    
    override fun getInjection(context: PsiElement): Injection? {
        // 检查是否为支持插值的字符串字面量
        if (!isInterpolatableString(context)) {
            return null
        }
        
        val text = context.text
        // 检查是否包含插值表达式
        if (!containsInterpolation(text)) {
            return null
        }
        
        // 注入 Valkyrie 语言
        return SimpleInjection(
            ValkyrieLanguage.INSTANCE,
            "", // prefix - 不需要前缀
            "", // suffix - 不需要后缀
            null // support id
        )
    }
    
    /**
     * 检查元素是否为支持插值的字符串字面量
     */
    private fun isInterpolatableString(element: PsiElement): Boolean {
        // 检查是否为字符串字面量
        if (element is ValkyrieElementNode) {
            val elementType = element.node?.elementType
            if (elementType == ValkyrieTypes.STRING_LITERAL) {
                val text = element.text
                return INTERPOLATION_PREFIXES.any { prefix -> text.startsWith(prefix) }
            }
        }
        return false
    }
    
    /**
     * 检查字符串是否包含插值表达式
     */
    private fun containsInterpolation(text: String): Boolean {
        // 简单的插值模式匹配: ${...}
        return text.contains("\${") && text.contains("}")
    }
}
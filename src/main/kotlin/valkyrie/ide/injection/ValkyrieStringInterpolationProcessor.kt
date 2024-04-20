package valkyrie.ide.injection

import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.parsers.ValkyrieTypes
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * 字符串插值处理器
 * 负责在字符串字面量中注入Valkyrie语言，支持插值表达式
 */
class ValkyrieStringInterpolationProcessor : MultiHostInjector {

    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        // 检查是否为字符串字面量且支持插值
        if (!isStringLiteral(context) || !isInterpolationEnabled(context)) {
            return
        }

        val text = context.text
        val interpolations = findInterpolations(text)
        
        if (interpolations.isEmpty()) {
            return
        }

        // 注册语言注入
        registrar.startInjecting(ValkyrieLanguage.INSTANCE)
        
        for (interpolation in interpolations) {
            val range = TextRange(interpolation.startOffset, interpolation.endOffset)
            registrar.addPlace(null, null, context as PsiLanguageInjectionHost, range)
        }
        
        registrar.doneInjecting()
    }

    override fun elementsToInjectIn(): List<Class<out PsiElement>> {
        return listOf(ValkyrieElementNode::class.java)
    }

    /**
     * 检查是否为字符串字面量
     */
    private fun isStringLiteral(element: PsiElement): Boolean {
        return element.node?.elementType == ValkyrieTypes.STRING_LITERAL
    }

    /**
     * 检查字符串字面量是否支持插值
     */
    private fun isInterpolationEnabled(element: PsiElement): Boolean {
        val text = element.text
        // 双引号字符串和反引号字符串支持插值
        return text.startsWith("\"") || text.startsWith("`")
    }

    /**
     * 查找字符串中的插值表达式
     */
    private fun findInterpolations(text: String): List<InterpolationRange> {
        val interpolations = mutableListOf<InterpolationRange>()
        val regex = Regex("""\$\{([^}]*(?:\{[^}]*\}[^}]*)*)\}""")
        
        regex.findAll(text).forEach { match ->
            val fullMatch = match.value
            val expression = match.groupValues[1]
            
            // 跳过空表达式
            if (expression.isNotBlank()) {
                interpolations.add(
                    InterpolationRange(
                        startOffset = match.range.first + 2, // 跳过 ${
                        endOffset = match.range.last,        // 不包含 }
                        expression = expression
                    )
                )
            }
        }
        
        return interpolations
    }

    /**
     * 插值范围数据类
     */
    private data class InterpolationRange(
        val startOffset: Int,
        val endOffset: Int,
        val expression: String
    )
}
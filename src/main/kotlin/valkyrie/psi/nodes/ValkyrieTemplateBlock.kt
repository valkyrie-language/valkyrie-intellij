package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * 模板语法块实现 <$ ... $>
 * 用于在编译期生成代码
 */
class ValkyrieTemplateBlock(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取开始标记 <$
     */
    fun getStartToken(): PsiElement? {
        return findChildByType(ValkyrieTokenTypes.TEMPLATE_START)
    }
    
    /**
     * 获取结束标记 $>
     */
    fun getEndToken(): PsiElement? {
        return findChildByType(ValkyrieTokenTypes.TEMPLATE_END)
    }
    
    /**
     * 获取模板内容文本
     */
    fun getTemplateContentText(): String {
        return getInnerText()
    }
    
    /**
     * 获取模板类型
     */
    fun getTemplateType(): TemplateType {
        val innerText = getInnerText()
        return when {
            innerText.contains("if ") -> TemplateType.CONDITIONAL
            innerText.contains("for ") -> TemplateType.LOOP
            innerText.contains("while ") -> TemplateType.WHILE_LOOP
            innerText.contains("match ") -> TemplateType.MATCH
            else -> TemplateType.INTERPOLATION
        }
    }
    
    /**
     * 检查是否为插值表达式
     */
    fun isInterpolation(): Boolean {
        return getTemplateType() == TemplateType.INTERPOLATION
    }
    
    /**
     * 检查是否为控制流语句
     */
    fun isControlFlow(): Boolean {
        val type = getTemplateType()
        return type == TemplateType.CONDITIONAL || 
               type == TemplateType.LOOP || 
               type == TemplateType.WHILE_LOOP ||
               type == TemplateType.MATCH
    }
    
    /**
     * 获取插值表达式文本
     */
    fun getInterpolationExpressionText(): String? {
        return if (isInterpolation()) getInnerText() else null
    }
    
    /**
     * 获取条件语句文本
     */
    fun getIfStatementText(): String? {
        return if (getTemplateType() == TemplateType.CONDITIONAL) getInnerText() else null
    }
    
    /**
     * 获取循环语句文本
     */
    fun getForStatementText(): String? {
        return if (getTemplateType() == TemplateType.LOOP) getInnerText() else null
    }
    
    /**
     * 获取 while 循环语句文本
     */
    fun getWhileStatementText(): String? {
        return if (getTemplateType() == TemplateType.WHILE_LOOP) getInnerText() else null
    }
    
    /**
     * 获取匹配语句文本
     */
    fun getMatchStatementText(): String? {
        return if (getTemplateType() == TemplateType.MATCH) getInnerText() else null
    }
    
    /**
     * 获取模板的文本内容（不包括 <$ 和 $>）
     */
    fun getInnerText(): String {
        val startToken = getStartToken()
        val endToken = getEndToken()
        
        if (startToken == null || endToken == null) {
            return text
        }
        
        val startOffset = startToken.textRange.endOffset - textRange.startOffset
        val endOffset = endToken.textRange.startOffset - textRange.startOffset
        
        return if (startOffset < endOffset) {
            text.substring(startOffset, endOffset).trim()
        } else {
            ""
        }
    }
    
    /**
     * 检查语法是否完整
     */
    fun isComplete(): Boolean {
        return getStartToken() != null && getEndToken() != null
    }
    
    /**
     * 获取生成的代码预览
     */
    fun getGeneratedCodePreview(): String {
        return when (getTemplateType()) {
            TemplateType.INTERPOLATION -> {
                val expr = getInterpolationExpressionText()
                "// Generated: ${expr ?: "<expression>"}"
            }
            TemplateType.CONDITIONAL -> {
                "// Generated: conditional code block"
            }
            TemplateType.LOOP -> {
                "// Generated: loop-generated code block"
            }
            TemplateType.WHILE_LOOP -> {
                "// Generated: while-loop-generated code block"
            }
            TemplateType.MATCH -> {
                "// Generated: match-generated code block"
            }
            else -> {
                "// Generated: template expression"
            }
        }
    }
    
    /**
     * 获取模板上下文信息
     */
    fun getTemplateContext(): TemplateContext {
        return TemplateContext(
            type = getTemplateType(),
            isComplete = isComplete(),
            innerText = getInnerText(),
            generatedPreview = getGeneratedCodePreview()
        )
    }
}

/**
 * 模板类型枚举
 */
enum class TemplateType {
    INTERPOLATION,  // 插值表达式 <$ expression $>
    CONDITIONAL,    // 条件语句 <$ if ... $>
    LOOP,          // 循环语句 <$ for ... $>
    WHILE_LOOP,    // while 循环 <$ while ... $>
    MATCH,         // 匹配语句 <$ match ... $>
    EXPRESSION     // 普通表达式
}

/**
 * 模板上下文信息
 */
data class TemplateContext(
    val type: TemplateType,
    val isComplete: Boolean,
    val innerText: String,
    val generatedPreview: String
)
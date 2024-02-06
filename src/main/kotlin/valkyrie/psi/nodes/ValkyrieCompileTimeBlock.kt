package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.navigation.CompileTimeContext
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * 编译期表达式块实现 <{ ... }>
 * 用于在编译期执行代码并返回值
 */
class ValkyrieCompileTimeBlock(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取开始标记 <{
     */
    fun getStartToken(): PsiElement? {
        return findChildByType(ValkyrieTokenTypes.COMPILE_TIME_BLOCK_START)
    }
    
    /**
     * 获取结束标记 }>
     */
    fun getEndToken(): PsiElement? {
        return findChildByType(ValkyrieTokenTypes.COMPILE_TIME_BLOCK_END)
    }
    
    /**
     * 获取块内的所有语句
     */
    fun getStatements(): List<ValkyrieElementNode> {
        val statements = mutableListOf<ValkyrieElementNode>()
        var child = firstChild
        while (child != null) {
            if (child is ValkyrieElementNode && 
                child.node.elementType != ValkyrieTokenTypes.COMPILE_TIME_BLOCK_START &&
                child.node.elementType != ValkyrieTokenTypes.COMPILE_TIME_BLOCK_END) {
                statements.add(child)
            }
            child = child.nextSibling
        }
        return statements
    }
    
    /**
     * 获取最后一个表达式（作为返回值）
     */
    fun getReturnExpression(): ValkyrieElementNode? {
        val statements = getStatements()
        return statements.lastOrNull()
    }
    
    /**
     * 获取所有变量声明
     */
    fun getVariableDeclarations(): List<PsiElement> {
        return children.filter { it.text.contains("let ") }
    }
    
    /**
     * 检查是否为空块
     */
    fun isEmpty(): Boolean {
        return getStatements().isEmpty()
    }
    
    /**
     * 检查是否只包含表达式（无副作用）
     */
    fun isPureExpression(): Boolean {
        val statements = getStatements()
        return statements.size == 1
    }
    
    /**
     * 获取块的文本内容（不包括 <{ 和 }>）
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
     * 获取编译期求值的上下文信息
     */
    fun getCompileTimeContext(): CompileTimeContext {
        return CompileTimeContext(
            variables = getVariableDeclarations().associate {
                it.text to "unknown"
            },
            returnExpression = getReturnExpression(),
            isPure = isPureExpression()
        )
    }
}


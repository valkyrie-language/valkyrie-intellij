package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Catch 语句 PSI 节点
 * 用于异常处理和 effect 处理
 */
class ValkyrieCatchStatement(node: ASTNode) : ValkyrieElementNode(node) {

    /**
     * 获取错误变量标识符（可选）
     */
    fun getErrorVariable(): ValkyrieIdentifierNode? {
        // catch 关键字后面的第一个标识符
        val catchKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.CATCH)
        return catchKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieIdentifierNode::class.java)
        }
    }

    /**
     * 获取 catch 块体
     */
    fun getCatchBody(): ValkyrieBlockStatementNode? {
        return findChildByClass(ValkyrieBlockStatementNode::class.java)
    }

    /**
     * 获取所有 catch case
     */
    fun getCatchCases(): List<ValkyrieCatchCase> {
        return PsiTreeUtil.findChildrenOfType(this, ValkyrieCatchCase::class.java).toList()
    }

    /**
     * 获取所有 match case（在 catch 块中）
     */
    fun getMatchCases(): List<ValkyrieElementNode> {
        return PsiTreeUtil.findChildrenOfType(this, ValkyrieElementNode::class.java).filter { 
            it.node.elementType.toString().contains("MATCH_CASE")
        }
    }

    /**
     * 获取 else 子句
     */
    fun getElseClause(): ValkyrieElseClauseNode? {
        return findChildByClass(ValkyrieElseClauseNode::class.java)
    }

    /**
     * 检查是否有错误变量
     */
    fun hasErrorVariable(): Boolean {
        return getErrorVariable() != null
    }

    /**
     * 检查是否有 catch cases
     */
    fun hasCatchCases(): Boolean {
        return getCatchCases().isNotEmpty() || getMatchCases().isNotEmpty()
    }

    /**
     * 获取处理的 effect 类型列表
     * 从 catch cases 中提取
     */
    fun getHandledEffects(): List<String> {
        val effects = mutableListOf<String>()
        
        // 从 catch cases 中提取 effect 类型
        getCatchCases().forEach { catchCase ->
            catchCase.getPattern()?.text?.let { pattern ->
                effects.add(pattern)
            }
        }
        
        // 从 match cases 中提取 effect 类型
        getMatchCases().forEach { matchCase ->
            matchCase.firstChild?.text?.let { pattern ->
                effects.add(pattern)
            }
        }
        
        return effects.distinct()
    }

    /**
     * 获取 catch 语句的文本范围（用于 code vision）
     */
    fun getCatchKeywordRange(): com.intellij.openapi.util.TextRange? {
        val catchKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.CATCH)
        return catchKeyword?.textRange
    }

    override fun toString(): String = "ValkyrieCatchStatement"
}
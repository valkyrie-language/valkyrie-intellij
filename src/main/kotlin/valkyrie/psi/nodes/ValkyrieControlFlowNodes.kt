package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Loop 语句节点
 */
class ValkyrieLoopStatement(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getBody(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.LBRACE)?.let { lbrace ->
            PsiTreeUtil.getNextSiblingOfType(lbrace, ValkyrieElementNode::class.java)
        }
    }
    
    fun getLabel(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER_STD)
    }
    
    override fun toString(): String = "ValkyrieLoopStatement"
}

/**
 * Return 语句节点
 */
class ValkyrieReturnStatement(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getExpression(): PsiElement? {
        val returnKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.RETURN)
        return returnKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }
    
    override fun toString(): String = "ValkyrieReturnStatement"
}

/**
 * Break 语句节点
 */
class ValkyrieBreakStatement(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getLabel(): PsiElement? {
        val breakKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.BREAK)
        return breakKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }
    
    override fun toString(): String = "ValkyrieBreakStatement"
}

/**
 * Continue 语句节点
 */
class ValkyrieContinueStatement(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getLabel(): PsiElement? {
        val continueKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.CONTINUE)
        return continueKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }
    
    override fun toString(): String = "ValkyrieContinueStatement"
}

/**
 * Yield 语句节点
 */
class ValkyrieYieldStatement(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getExpression(): PsiElement? {
        val yieldKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.YIELD)
        return yieldKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }
    
    override fun toString(): String = "ValkyrieYieldStatement"
}

/**
 * Raise 语句节点
 */
class ValkyrieRaiseStatement(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getExpression(): PsiElement? {
        val raiseKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.RAISE)
        return raiseKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }
    
    override fun toString(): String = "ValkyrieRaiseStatement"
}

/**
 * Catch Case 节点
 */
class ValkyrieCatchCase(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getPattern(): PsiElement? {
        val catchKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.CATCH)
        return catchKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }
    
    fun getBody(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.LBRACE)?.let { lbrace ->
            PsiTreeUtil.getNextSiblingOfType(lbrace, ValkyrieElementNode::class.java)
        }
    }
    
    override fun toString(): String = "ValkyrieCatchCase"
}
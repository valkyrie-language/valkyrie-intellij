package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.ValkyrieElementTypes

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

/**
 * 赋值语句节点
 */
class ValkyrieAssignStatement(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getLeftExpression(): PsiElement? {
        return children.firstOrNull { it.node.elementType == ValkyrieElementTypes.EXPRESSION }
    }
    
    fun getRightExpression(): PsiElement? {
        return children.lastOrNull { it.node.elementType == ValkyrieElementTypes.EXPRESSION }
    }
    
    fun getAssignOperator(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.PLUS_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.MINUS_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.MULTIPLY_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.DIVIDE_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.MODULO_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.POWER_ASSIGN)
    }
    
    override fun toString(): String = "ValkyrieAssignStatement"
}

/**
 * Resume 语句节点
 */
class ValkyrieResumeStatement(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getLabel(): PsiElement? {
        val resumeKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.RESUME)
        return resumeKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }
    
    fun getExpression(): PsiElement? {
        return children.lastOrNull { it.node.elementType == ValkyrieElementTypes.EXPRESSION }
    }
    
    override fun toString(): String = "ValkyrieResumeStatement"
}
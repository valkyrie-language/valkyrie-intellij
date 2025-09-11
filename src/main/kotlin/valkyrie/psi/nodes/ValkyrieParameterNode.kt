package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Parameter 实现
 */
class ValkyrieParameterNode(node: ASTNode) : ValkyrieElementNode(node) {

    fun getParameterName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER_STD)?.text
    }

    fun getTypeReference(): ValkyrieTypeReferenceNode? {
        return findChildByClass(ValkyrieTypeReferenceNode::class.java)
    }
    
    /**
     * 获取参数的修饰符列表
     */
    fun getModifiers(): ValkyrieModifierListNode? {
        return findChildByClass(ValkyrieModifierListNode::class.java)
    }
    
    /**
     * 检查参数是否有mut修饰符
     */
    fun isMutable(): Boolean {
        return getModifiers()?.hasModifier("mut") == true
    }
}
package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode

/**
 * Imply 语句实现
 * 用于 trait 实现声明
 */
class ValkyrieImplyStatement(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {
    
    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun setName(name: @NlsSafe String): PsiElement? {
        TODO("Not yet implemented")
    }

    /**
     * 获取实现的 trait 名称
     */
    fun getTraitName(): String? {
        return nameIdentifier?.text
    }

    /**
     * 获取目标类型（冒号后的类型）
     */
    fun getTargetType(): ValkyrieTypeReferenceNode? {
        return findChildByClass(ValkyrieTypeReferenceNode::class.java)
    }

    /**
     * 获取泛型参数列表
     */
    fun getGenericParameters(): PsiElement? {
        return findChildByClass(ValkyrieElementNode::class.java)
    }

    /**
     * 获取实现体
     */
    fun getImplyBody(): ValkyrieObjectBodyNode? {
        return findChildByClass(ValkyrieObjectBodyNode::class.java)
    }

    /**
     * 获取实现体中的所有方法
     */
    fun getMethods(): List<ValkyrieMethodDeclaration> {
        val body = getImplyBody() ?: return emptyList()
        return PsiTreeUtil.findChildrenOfType(body, ValkyrieMethodDeclaration::class.java).toList()
    }

    /**
     * 检查是否有泛型参数
     */
    fun hasGenericParameters(): Boolean {
        return getGenericParameters() != null
    }
}
package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.traits.HasAnnotation
import valkyrie.psi.traits.HasTypeParameter

/**
 * Trait 别名声明实现
 * 用于处理 trait 别名语法：trait A = B + C
 */
class ValkyrieTraitAliasDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner, HasAnnotation, HasTypeParameter {
    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun setName(name: String): PsiElement {
        val nameIdentifier = getNameIdentifier()
        if (nameIdentifier is ValkyrieIdentifierNode) {
            return nameIdentifier.setName(name)
        }
        return this
    }

    /**
     * 获取别名的目标类型表达式
     * 例如在 "trait A = B + C" 中，返回 "B + C" 部分
     */
    fun getAliasTarget(): PsiElement? {
        // 查找赋值符号后的类型表达式
        return PsiTreeUtil.findChildOfType(this, ValkyrieTypeReferenceNode::class.java)
    }

    override val typeParameters: List<ValkyrieTypeParameterItem>
        get() = TODO("Not yet implemented")
}
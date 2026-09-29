package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiQualifiedNamedElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.traits.HasTypeParameter

/**
 * Imply 语句实现
 * 用于 trait 实现声明
 *
 * ```valkyrie
 * imply module::Class { }
 * ```
 */
class ValkyrieImplyStatement(node: ASTNode) : ValkyrieElementNode(node),
    PsiQualifiedNamedElement,
    HasTypeParameter  {


    override fun getNavigationElement(): PsiElement {
        return super.getNavigationElement()
    }

    override fun getQualifiedName(): String? {
        val targetType = getTargetType()
        return targetType?.text
    }

    override fun getName(): String? {
        return super.getName()
    }

    override fun setName(name: String): PsiElement {
        return this
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

    override val typeParameters: List<ValkyrieTypeParameterItem>
        get() {
            val genericParams = getGenericParameters()
            return if (genericParams != null) {
                PsiTreeUtil.findChildrenOfType(genericParams, ValkyrieTypeParameterItem::class.java).toList()
            } else {
                emptyList()
            }
        }
}
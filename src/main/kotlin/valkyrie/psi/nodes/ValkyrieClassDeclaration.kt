package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.traits.HasAnnotation
import valkyrie.psi.traits.HasInheritParameter
import valkyrie.psi.traits.HasObjectBody
import valkyrie.psi.traits.HasTypeParameter

/**
 * Class 语句实现
 */
class ValkyrieClassDeclaration(node: ASTNode) : ValkyrieElementNode(node),
    PsiNameIdentifierOwner,
    HasAnnotation,       // ↯attribute class X { }
    HasTypeParameter,    // class X<T> { }
    HasInheritParameter, // class X(A) { }
    HasObjectBody        // class X { object_body }
{
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

    override val typeParameters: List<ValkyrieTypeParameterItem>
        get() = findChildByClass(ValkyrieGenericList::class.java)?.typeParameters ?: emptyList()
    override val inheritParameters: List<ValkyrieTermParameterItem>
        get() = getClassInherit()?.getInheritItems()?.mapNotNull { it as? ValkyrieTermParameterItem } ?: emptyList()

    /**
     * 获取类继承信息
     */
    fun getClassInherit(): ValkyrieInheritList? {
        return findChildByClass(ValkyrieInheritList::class.java)
    }

    /**
     * 获取所有父类
     */
    fun getParentClasses(): List<String> {
        return getClassInherit()?.getParentClassNames() ?: emptyList()
    }
}


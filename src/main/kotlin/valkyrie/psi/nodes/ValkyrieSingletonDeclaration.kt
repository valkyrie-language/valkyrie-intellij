package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.traits.HasAnnotation
import valkyrie.psi.traits.HasHighlighter
import valkyrie.psi.traits.HasInheritParameter
import valkyrie.psi.traits.HasObjectBody
import valkyrie.psi.traits.HasTypeParameter
import valkyrie.ide.highlight.ValkyrieColor

/**
 * Singleton 语句实现
 */
class ValkyrieSingletonDeclaration(node: ASTNode) : ValkyrieElementNode(node),
    PsiNameIdentifierOwner,
    HasAnnotation,       // ↯attribute singleton X { }
    HasTypeParameter,    // singleton X<T> { }
    HasInheritParameter, // singleton X(A) { }
    HasObjectBody,       // singleton X { object_body }
    HasHighlighter
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

    override val highlightColor: ValkyrieColor
        get() = ValkyrieColor.SINGLETON_DECLARATION
    
    override val highlightElement: PsiElement?
        get() = nameIdentifier

    override fun toString(): String {
        return "ValkyrieSingletonDeclaration(${name ?: "<anonymous>"})"
    }
}
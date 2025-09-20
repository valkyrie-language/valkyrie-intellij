package valkyrie.psi.nodes

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.language.ValkyrieIcons
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.reference.ValkyrieReference
import valkyrie.psi.traits.*

/**
 * Class 语句实现
 */
class ValkyrieClassDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner, HasHighlighter,
    HasAnnotation,       // ↯attribute class X { }
    HasTypeParameter,    // class X<T> { }
    HasInheritParameter, // class X(A) { }
    HasObjectBody        // class X { object_body }
{
    override val highlightColor: ValkyrieColor
        get() = ValkyrieColor.SYM_CLASS

    override val highlightElement: PsiElement?
        get() = nameIdentifier


    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)
    }

    override fun getIdentifyingElement(): PsiElement? {
        return super.getIdentifyingElement()
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

    /**
     * 获取引用对象，用于支持 Ctrl+Click 导航
     */
    override fun getReference(): PsiReference? {
        val nameIdentifier = getNameIdentifier()
        if (nameIdentifier is ValkyrieIdentifierNode) {
            return ValkyrieReference(nameIdentifier)
        }
        return null
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData(
            "${name ?: "<anonymous-class>"}",
            "${typeParameters.joinToString(",")}",
            ValkyrieIcons.CLASS,
            highlightColor.textAttributesKey
        )
    }

    override fun toString(): String {
        return "ValkyrieClassDeclaration(${name ?: "<anonymous>"})"
    }
}


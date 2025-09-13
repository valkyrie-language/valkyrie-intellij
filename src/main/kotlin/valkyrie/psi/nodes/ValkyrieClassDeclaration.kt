package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.traits.*

/**
 * Class 语句实现
 */
class ValkyrieClassDeclaration(node: ASTNode) : ValkyrieElementNode(node),
    PsiNameIdentifierOwner,
    HasHighlighter,
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
        // 根据语法定义 declare-class ::= annotations KW_CLASS identifier-safe
        // class 关键词和标识符是同级子节点，需要找到 KW_CLASS 后面的标识符
        val children = node.getChildren(null)
        var foundClass = false
        for (child in children) {
            if (child.elementType.toString() == "KW_CLASS") {
                foundClass = true
                continue
            }
            if (foundClass && child.psi is ValkyrieIdentifierNode) {
                return child.psi
            }
        }
        // 备用方案：查找第一个标识符节点
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


    override fun toString(): String {
        return "ValkyrieClassDeclaration(${name ?: "<anonymous>"})";
    }


}


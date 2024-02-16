package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.traits.HasAnnotation
import valkyrie.psi.traits.HasObjectBody

/**
 * Class 语句实现
 */
class ValkyrieClassDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner, HasAnnotation, HasObjectBody {
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

    fun getClassBody(): ValkyrieObjectBodyNode? {
        return getObjectBody()
    }

    fun isStatic(): Boolean {
        return hasModifier("static")
    }

    fun isMutable(): Boolean {
        return hasModifier("mut")
    }

    /**
     * 获取类继承信息
     */
    fun getClassInherit(): ValkyrieClassInheritNode? {
        return findChildByClass(ValkyrieClassInheritNode::class.java)
    }

    /**
     * 获取所有父类
     */
    fun getParentClasses(): List<String> {
        return getClassInherit()?.getParentClassNames() ?: emptyList()
    }

    /**
     * 获取重命名继承映射
     */
    fun getRenameMapping(): Map<String, String> {
        return getClassInherit()?.getRenameMapping() ?: emptyMap()
    }

    /**
     * 是否有继承
     */
    fun hasInheritance(): Boolean {
        return getClassInherit() != null
    }

    /**
     * 是否有重命名继承
     */
    fun hasRenamedInheritance(): Boolean {
        return getClassInherit()?.hasRenamedInheritance() ?: false
    }
}


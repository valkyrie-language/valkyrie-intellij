package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElementNode

/**
 * Class 语句实现
 */
class ValkyrieClassDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {
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

    fun getClassBody(): ValkyrieObjectBodyNode? {
        return findChildByClass(ValkyrieObjectBodyNode::class.java)
    }

    fun getModifierNodes(): List<ValkyrieModifierNode> {
        return findChildrenByClass(ValkyrieModifierNode::class.java).toList()
    }
    
    fun hasModifier(name: String): Boolean {
        return getModifierNodes().any { it.isModifier(name) }
    }
    
    fun isStatic(): Boolean {
        return hasModifier("static")
    }
    
    fun isMutable(): Boolean {
        return hasModifier("mut")
    }

    fun getAnnotations(): List<ValkyrieAnnotationNode> {
        return findChildrenByClass(ValkyrieAnnotationNode::class.java).toList()
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


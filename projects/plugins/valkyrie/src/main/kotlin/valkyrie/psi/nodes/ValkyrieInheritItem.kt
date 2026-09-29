package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * 继承项节点实现
 * 支持重命名继承语法: renamed: ParentClass
 */
class ValkyrieInheritItem(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取重命名标识符（如果存在）
     * 例如在 "renamed: ParentClass" 中返回 "renamed"
     */
    fun getRenameIdentifier(): PsiElement? {
        // 查找第一个标识符，如果后面跟着冒号，则这是重命名标识符
        val identifier = findChildByType<PsiElement>(ValkyrieTypes.SYMBOL_XID) ?: findChildByType<PsiElement>(ValkyrieTypes.SYMBOL_RAW)
        if (identifier != null) {
            val nextSibling = identifier.nextSibling
            if (nextSibling?.node?.elementType == ValkyrieTypes.COLON) {
                return identifier
            }
        }
        return null
    }
    
    /**
     * 获取类型表达式（父类类型）
     */
    fun getTypeExpression(): ValkyrieTypeExpression? {
        return findChildByClass(ValkyrieTypeExpression::class.java)
    }
    
    /**
     * 获取父类名称
     */
    fun getParentClassName(): String? {
        return getTypeExpression()?.text
    }
    
    /**
     * 获取重命名名称
     */
    fun getRenameName(): String? {
        return getRenameIdentifier()?.text
    }
    
    /**
     * 是否是重命名继承
     */
    fun isRenamedInheritance(): Boolean {
        return getRenameIdentifier() != null
    }
    
    /**
     * 获取注解列表
     */
    fun getAnnotations(): List<ValkyrieAnnotationNode> {
        return findChildrenByClass(ValkyrieAnnotationNode::class.java).toList()
    }
    
    override fun toString(): String = "ValkyrieInheritItem"
}
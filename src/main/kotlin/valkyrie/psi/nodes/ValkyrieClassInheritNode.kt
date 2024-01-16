package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElementNode

/**
 * 类继承节点实现
 * 处理 class A(B, renamed: C, D) 中的继承部分
 */
class ValkyrieClassInheritNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取所有继承项
     */
    fun getInheritItems(): List<ValkyrieInheritItemNode> {
        return findChildrenByClass(ValkyrieInheritItemNode::class.java).toList()
    }
    
    /**
     * 获取普通继承项（没有重命名的）
     */
    fun getNormalInheritItems(): List<ValkyrieInheritItemNode> {
        return getInheritItems().filter { !it.isRenamedInheritance() }
    }
    
    /**
     * 获取重命名继承项
     */
    fun getRenamedInheritItems(): List<ValkyrieInheritItemNode> {
        return getInheritItems().filter { it.isRenamedInheritance() }
    }
    
    /**
     * 根据重命名查找继承项
     */
    fun findInheritItemByRename(renameName: String): ValkyrieInheritItemNode? {
        return getRenamedInheritItems().find { it.getRenameName() == renameName }
    }
    
    /**
     * 根据父类名查找继承项
     */
    fun findInheritItemByParentName(parentName: String): ValkyrieInheritItemNode? {
        return getInheritItems().find { it.getParentClassName() == parentName }
    }
    
    /**
     * 获取所有父类名称
     */
    fun getParentClassNames(): List<String> {
        return getInheritItems().mapNotNull { it.getParentClassName() }
    }
    
    /**
     * 获取所有重命名映射
     */
    fun getRenameMapping(): Map<String, String> {
        return getRenamedInheritItems().associate { 
            it.getRenameName()!! to it.getParentClassName()!! 
        }
    }
    
    /**
     * 是否有重命名继承
     */
    fun hasRenamedInheritance(): Boolean {
        return getRenamedInheritItems().isNotEmpty()
    }
    
    override fun toString(): String = "ValkyrieClassInherit"
}
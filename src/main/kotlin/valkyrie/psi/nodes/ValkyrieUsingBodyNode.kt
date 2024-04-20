package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * Using 语句的 body 节点
 * 支持格式:
 * - using { a.b as c }
 * - using a.{ b { c.d as e}, f, g; h }
 * 括号内 , ; 空格皆可表示间隔
 */
class ValkyrieUsingBodyNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取 body 中的所有 using item 列表
     * 例如: using { a, b as c, d.e } -> [UsingItem(a), UsingItem(b as c), UsingItem(d.e)]
     */
    fun getUsingItems(): List<ValkyrieUsingItemNode> {
        return findChildrenByClass(ValkyrieUsingItemNode::class.java).toList()
    }
    
    /**
     * 添加新的 using item
     */
    fun addUsingItem(item: ValkyrieUsingItemNode) {
        // 这个方法在实际使用中可能需要更复杂的实现
        // 目前只是占位符
    }
    
    /**
     * 检查 body 是否为空
     */
    fun isEmpty(): Boolean {
        return getUsingItems().isEmpty()
    }
    
    /**
     * 获取 body 中 using item 的数量
     */
    fun getItemCount(): Int {
        return getUsingItems().size
    }
    
    /**
     * 根据路径查找特定的 using item
     */
    fun findItemByPath(path: String): ValkyrieUsingItemNode? {
        return getUsingItems().find { it.getFullPath() == path }
    }
    
    /**
     * 根据别名查找特定的 using item
     */
    fun findItemByAlias(alias: String): ValkyrieUsingItemNode? {
        return getUsingItems().find { it.getAlias() == alias }
    }
    
    /**
     * 获取所有通配符导入的 item
     */
    fun getWildcardItems(): List<ValkyrieUsingItemNode> {
        return getUsingItems().filter { it.isWildcardImport() }
    }
    
    /**
     * 获取所有带别名的 item
     */
    fun getAliasedItems(): List<ValkyrieUsingItemNode> {
        return getUsingItems().filter { it.getAlias() != null }
    }
    
    /**
     * 获取所有嵌套 body 的 item
     */
    fun getNestedBodyItems(): List<ValkyrieUsingItemNode> {
        return getUsingItems().filter { it.getUsingBody() != null }
    }
    
    override fun toString(): String {
        val items = getUsingItems()
        return if (items.isNotEmpty()) {
            "UsingBody(${items.size} items: ${items.joinToString(", ") { it.getFullPath() }})"
        } else {
            "UsingBody(empty)"
        }
    }
}
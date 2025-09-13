package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieElementTypes

/**
 * Using 语句中的单个项目节点
 * 支持格式:
 * - using a;
 * - using a.*;
 * - using a::*;
 * - using a as b;
 * - using a {};
 * - using a.{};
 * - using a::{};
 */
class ValkyrieUsingItemNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取基础路径标识符列表
     * 例如: a.b.c -> ["a", "b", "c"]
     */
    fun getBasicPath(): List<String> {
        val paths = mutableListOf<String>()
        val namespacePath = findChildByType<PsiElement>(ValkyrieElementTypes.NAMESPACE_PATH)
        
        namespacePath?.let { path ->
            val identifiers = PsiTreeUtil.findChildrenOfType(path, ValkyrieIdentifierNode::class.java)
            paths.addAll(identifiers.map { it.getName() })
        }
        
        return paths
    }
    
    /**
     * 获取别名标识符
     * 例如: using a as b -> "b"
     */
    fun getAlias(): String? {
        // 查找 'as' 关键字后的标识符
        var foundAs = false
        var child = firstChild
        
        while (child != null) {
            if (foundAs && child is ValkyrieIdentifierNode) {
                return child.getName()
            }
            if (child.text == "as") {
                foundAs = true
            }
            child = child.nextSibling
        }
        
        return null
    }
    
    /**
     * 获取 using body 节点
     * 例如: using a { ... } 中的 { ... } 部分
     */
    fun getUsingBody(): ValkyrieUsingBodyNode? {
        return findChildByClass(ValkyrieUsingBodyNode::class.java)
    }
    
    /**
     * 检查是否为通配符导入
     * 例如: using a.* 或 using a::*
     */
    fun isWildcardImport(): Boolean {
        var child = firstChild
        while (child != null) {
            if (child.text == "*") {
                return true
            }
            child = child.nextSibling
        }
        return false
    }
    
    /**
     * 获取完整的导入路径字符串
     */
    fun getFullPath(): String {
        val paths = getBasicPath()
        return if (paths.isNotEmpty()) {
            paths.joinToString(".")
        } else {
            ""
        }
    }
    
    override fun toString(): String {
        val path = getFullPath()
        val alias = getAlias()
        val hasBody = getUsingBody() != null
        
        return when {
            alias != null -> "UsingItem($path as $alias)"
            hasBody -> "UsingItem($path { ... })"
            isWildcardImport() -> "UsingItem($path.*)"
            else -> "UsingItem($path)"
        }
    }
}
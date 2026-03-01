package valkyrie.psi.nodes.dialect_sfc

import com.intellij.lang.ASTNode
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * SFC Template 节点的专门实现
 * 解决PSI树遍历中的空指针问题
 */
class ValkyrieSfcTemplateNode(node: ASTNode) : ValkyrieElementNode(node) {

    override fun toString(): String = "SFC Template"

}
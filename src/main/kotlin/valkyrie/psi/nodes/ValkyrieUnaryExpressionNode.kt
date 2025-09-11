package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElementNode

/**
 * 一元表达式实现
 */
class ValkyrieUnaryExpressionNode(node: ASTNode) : ValkyrieElementNode(node)
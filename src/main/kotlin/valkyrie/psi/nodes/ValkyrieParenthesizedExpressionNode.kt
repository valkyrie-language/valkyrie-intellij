package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElementNode

/**
 * 括号表达式实现
 */
class ValkyrieParenthesizedExpressionNode(node: ASTNode) : ValkyrieTermExpression(node)
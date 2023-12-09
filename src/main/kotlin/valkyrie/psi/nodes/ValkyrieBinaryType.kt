package valkyrie.psi.nodes

import com.intellij.lang.ASTNode

/**
 * 二元表达式实现, 主要是 T | U
 */
class ValkyrieBinaryType(node: ASTNode) : ValkyrieTypeExpression(node)

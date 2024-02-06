package valkyrie.ide.navigation

import valkyrie.psi.ValkyrieElementNode

/**
 * 编译期上下文信息
 */
data class CompileTimeContext(
    val variables: Map<String?, String?>,
    val returnExpression: ValkyrieElementNode?,
    val isPure: Boolean
)
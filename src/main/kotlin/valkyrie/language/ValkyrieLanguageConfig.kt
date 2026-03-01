package valkyrie.language

data class ValkyrieLanguageConfig(
    val allow_x_grammar: Boolean = false,
    val allow_v_grammar: Boolean = false,
    /**
     * 允许旧的 `for` 语法，`for <pattern> in <expression> { ... }`
     */
    val allow_legacy_for: Boolean = false,
    /**
     * 允许旧的 `struct` 语法，`struct <name> { ... }`
     */
    val allow_legacy_struct: Boolean = false,
    /**
     * 允许旧的 `function` 语法，`fn <name> { ... }`，`fun <name> { ... }`，`function <name> { ... }`
     */
    val allow_legacy_function: Boolean = false,
)

/**
 * Valkyrie 配置别名，为了向后兼容
 */
typealias ValkyrieConfig = ValkyrieLanguageConfig
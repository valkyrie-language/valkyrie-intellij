package valkyrie.ide.navigation

/**
 * 模板类型枚举
 */
enum class TemplateType {
    INTERPOLATION,  // 插值表达式 <$ expression $>
    CONDITIONAL,    // 条件语句 <$ if ... $>
    LOOP,          // 循环语句 <$ for ... $>
    WHILE_LOOP,    // while 循环 <$ while ... $>
    MATCH,         // 匹配语句 <$ match ... $>
    EXPRESSION     // 普通表达式
}
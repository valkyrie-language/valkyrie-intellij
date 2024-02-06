package valkyrie.ide.navigation

/**
 * 元编程类型枚举
 */
enum class MetaType {
    MICRO,    // 计算层 - 运行期执行
    MEZZO,    // 内省层 - 编译期类型查询
    MACRO,    // 构造层 - 编译期代码生成
    UNKNOWN   // 未知类型
}
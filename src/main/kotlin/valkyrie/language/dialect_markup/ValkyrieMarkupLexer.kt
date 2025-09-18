package valkyrie.language.dialect_markup

import valkyrie.psi.lexers.LexerFlavor
import valkyrie.psi.lexers.ValkyrieLexerBase

/**
 * Mark Valkyrie 词法分析器
 *
 * 用于解析可编程文档文件 (.vkm)
 * 支持 Markdown 语法和嵌入的 Valkyrie 代码
 *
 * 示例：
 * ```
 * # 文档标题
 *
 * 这是普通的 Markdown 文本。
 *
 * let name = "World"
 *
 * ## 动态内容
 *
 * Hello, { name }!
 *
 * <div class="highlight">
 *   { if showDetails }
 *     详细信息在这里...
 *   { end }
 * </div>
 * ```
 */
class ValkyrieMarkupLexer : ValkyrieLexerBase(LexerFlavor.MARK) {

    /**
     * Mark 方言的特殊处理逻辑已在基类中实现
     * - 默认状态为 STATE_MARK_TEXT，解析 Markdown 文本
     * - 检测行首的 Valkyrie 关键字时切换到 STATE_LANGUAGE
     * - 遇到 < 或 { 时切换到 STATE_LANGUAGE，解析标签或表达式
     * - 根据上下文返回相应的文本状态
     */
}
package valkyrie.psi.lexers

/**
 * Valkyrie 词法分析器方言枚举
 *
 * 每种方言代表一种不同的语言环境和用途：
 * - STANDARD: 纯 Valkyrie 代码 (.vk)
 * - TEMPLATE: 模板文本生成 (.vkt)
 * - XML: 声明式 UI (.vkx)
 * - MARK: 可编程文档 (.vkm)
 */
enum class LexerFlavor(val extension: String?, val description: String) {
    /**
     * 标准 Valkyrie 代码
     * 用于编写后端服务、命令行工具、算法、业务逻辑等
     */
    STANDARD("vk", "Standard Valkyrie Code"),

    /**
     * 字符串方言
     * 用于字符串模板和插值表达式
     * 语法：默认是纯文本，使用 {...} 嵌入 Valkyrie 表达式
     */
    STRING(null, "String Interpolation"),

    /**
     * 模板文本生成
     * 用于生成 HTML、配置文件等基于文本的格式
     * 语法：默认是纯文本，使用 <$...$> 嵌入 Valkyrie 代码
     */
    TEMPLATE(null, "Template Text Generation"),

    /**
     * 声明式 UI
     * 用于构建可复用的 UI 组件，类似 Vue 组件
     * 语法：类 XML 标签语法，使用 {...} 嵌入 Valkyrie 表达式
     */
    XML("vkx", "Declarative UI"),

    /**
     * 可编程文档
     * 用于创建交互式文档、设计系统网站、个人博客等
     * 语法：默认是 Markdown，可以直接使用组件和动态值
     */
    MARK(null, "Programmable Documentation"),
    
    /**
     * 组件文件
     * 用于定义可复用的 UI 组件，类似 VKX 但专门用于组件定义
     * 语法：类 XML 标签语法，使用 {...} 嵌入 Valkyrie 表达式
     */
    COMPONENT(null, "Component Definition")
}
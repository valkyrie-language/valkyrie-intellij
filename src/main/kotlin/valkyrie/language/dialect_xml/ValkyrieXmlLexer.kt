package valkyrie.language.dialect_xml

import valkyrie.language.ValkyrieLanguageConfig
import valkyrie.psi.lexers.ValkyrieLexer
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Valkyrie XML 词法分析器
 * 用于解析 Valkyrie XML 方言
 */
class ValkyrieXmlLexer : ValkyrieLexer(ValkyrieLanguageConfig()) {

    companion object {
        // XML 特定的词法分析器状态
        protected const val STATE_XML = 1 // 用于解析 XML 标签的状态
    }

    /**
     * 中央调度方法：根据当前状态调用相应的处理函数
     * 扩展以支持 XML 状态
     */
    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_LANGUAGE -> processLanguage()
            STATE_XML -> processXml()
            else -> processLanguage() // 安全回退
        }
    }

    /**
     * 处理 XML 标签
     */
    protected fun processXml() {
        val ch = buffer[currentOffset]
        when {
            ch.isWhitespace() -> readWhitespace()
            ch == '<' -> processXmlTagStart()
            ch == '>' -> processXmlTagEnd()
            else -> processXmlContent()
        }
    }

    /**
     * 处理 XML 标签开始
     */
    protected fun processXmlTagStart() {
        currentOffset++
        currentTokenType = ValkyrieTypes.ANGLE_L
    }

    /**
     * 处理 XML 标签结束
     */
    protected fun processXmlTagEnd() {
        currentOffset++
        currentTokenType = ValkyrieTypes.ANGLE_R
    }

    /**
     * 处理 XML 内容
     */
    protected fun processXmlContent() {
        while (currentOffset < endOffset && buffer[currentOffset] != '<' && buffer[currentOffset] != '>') {
            currentOffset++
        }
        currentTokenType = ValkyrieTypes.STRING_TEXT
    }
}

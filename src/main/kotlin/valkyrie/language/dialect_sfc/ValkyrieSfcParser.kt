package valkyrie.psi.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * Valkyrie SFC (Single File Component) 专用解析器
 * 专门处理 .vkc 文件的解析逻辑
 */
class ValkyrieSfcParser : ValkyrieParser() {
    
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        builder.setDebugMode(true)
        val rootMarker = builder.mark()
        
        // 专门处理SFC文件的解析逻辑
        while (!builder.eof()) {
            val initialPosition = builder.currentOffset
            
            // 尝试解析SFC特定的语句
            val parsed = when {
                // 解析template标签
                isTemplateTag(builder) -> {
                    parseSfcTemplateStatement(this, builder)
                }
                // 解析script标签
                isScriptTag(builder) -> {
                    parseSfcScriptStatement(this, builder)
                }
                // 解析style标签
                isStyleTag(builder) -> {
                    parseSfcStyleStatement(this, builder)
                }
                // 处理XML注释
                builder.tokenType == XmlTokenType.XML_COMMENT_START -> {
                    parseXmlComment(builder)
                    true
                }
                // 处理空白字符
                builder.tokenType == XmlTokenType.XML_WHITE_SPACE -> {
                    builder.advanceLexer()
                    true
                }
                // 处理其他XML内容
                builder.tokenType == XmlTokenType.XML_DATA_CHARACTERS -> {
                    builder.advanceLexer()
                    true
                }
                // 尝试使用父类的parseStatement方法
                else -> {
                    parseStatement(builder)
                }
            }
            
            // 如果没有任何进展，强制前进一个token避免无限循环
            if (builder.currentOffset == initialPosition) {
                if (!builder.eof()) {
                    builder.advanceLexer()
                }
            }
        }
        
        rootMarker.done(root)
        return builder.treeBuilt
    }
    
    /**
     * 解析SFC文件的主要逻辑
     */
    private fun parseSfcFile(builder: PsiBuilder) {
        while (!builder.eof()) {
            when {
                // 解析template标签
                isTemplateTag(builder) -> {
                    parseSfcTemplateStatement(this, builder)
                }
                // 解析script标签
                isScriptTag(builder) -> {
                    parseSfcScriptStatement(this, builder)
                }
                // 解析style标签
                isStyleTag(builder) -> {
                    parseSfcStyleStatement(this, builder)
                }
                // 处理XML注释
                builder.tokenType == XmlTokenType.XML_COMMENT_START -> {
                    parseXmlComment(builder)
                }
                // 处理空白字符
                builder.tokenType == XmlTokenType.XML_WHITE_SPACE -> {
                    builder.advanceLexer()
                }
                // 处理其他XML内容
                builder.tokenType == XmlTokenType.XML_DATA_CHARACTERS -> {
                    builder.advanceLexer()
                }
                // 跳过未识别的token
                else -> {
                    builder.advanceLexer()
                }
            }
        }
    }
    
    /**
     * 检查是否是template标签
     */
    private fun isTemplateTag(builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }
        
        val nextToken = builder.lookAhead(1)
        return when (nextToken) {
            ValkyrieTokenTypes.XML_TEMPLATE -> true
            XmlTokenType.XML_NAME -> {
                // 检查标签名是否为"template"
                val marker = builder.mark()
                builder.advanceLexer() // 跳过 '<'
                val tagName = builder.tokenText
                marker.rollbackTo()
                tagName == "template"
            }
            else -> false
        }
    }
    
    /**
     * 检查是否是script标签
     */
    private fun isScriptTag(builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }
        
        val nextToken = builder.lookAhead(1)
        return when (nextToken) {
            ValkyrieTokenTypes.XML_SCRIPT -> true
            XmlTokenType.XML_NAME -> {
                val marker = builder.mark()
                builder.advanceLexer() // 跳过 '<'
                val tagName = builder.tokenText
                marker.rollbackTo()
                tagName == "script"
            }
            else -> false
        }
    }
    
    /**
     * 检查是否是style标签
     */
    private fun isStyleTag(builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }
        
        val nextToken = builder.lookAhead(1)
        return when (nextToken) {
            ValkyrieTokenTypes.XML_STYLE -> true
            XmlTokenType.XML_NAME -> {
                val marker = builder.mark()
                builder.advanceLexer() // 跳过 '<'
                val tagName = builder.tokenText
                marker.rollbackTo()
                tagName == "style"
            }
            else -> false
        }
    }
    
    /**
     * 解析XML注释
     */
    private fun parseXmlComment(builder: PsiBuilder) {
        val marker = builder.mark()
        
        // 消费注释开始
        if (builder.tokenType == XmlTokenType.XML_COMMENT_START) {
            builder.advanceLexer()
        }
        
        // 消费注释内容
        while (!builder.eof() && builder.tokenType != XmlTokenType.XML_COMMENT_END) {
            builder.advanceLexer()
        }
        
        // 消费注释结束
        if (builder.tokenType == XmlTokenType.XML_COMMENT_END) {
            builder.advanceLexer()
        }
        
        marker.done(ValkyrieElementTypes.XML_COMMENT)
    }
}
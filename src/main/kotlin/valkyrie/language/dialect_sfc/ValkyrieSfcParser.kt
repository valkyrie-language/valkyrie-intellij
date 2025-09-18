package valkyrie.psi.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.xml.XmlElementType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes

// 假设这些类型已经定义在你的项目中
// import valkyrie.psi.ValkyrieElementTypes.*
// import valkyrie.psi.ValkyrieTokenTypes.*

/**
 * Valkyrie SFC (Single File Component) 专用解析器
 * 专门处理 .vkc 文件的解析逻辑
 */
class ValkyrieSfcParser : ValkyrieParser() {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()

        // 循环解析顶层SFC块
        while (!builder.eof()) {
            val initialPosition = builder.currentOffset

            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> {
                    // 查看下一个 token 来决定是哪个 SFC 块
                    val tagName = peekTokenText(builder, 1)
                    when (tagName) {
                        "template" -> parseTag(builder, ValkyrieElementTypes.SFC_TEMPLATE)
                        "script" -> parseTag(builder, ValkyrieElementTypes.SFC_SCRIPT)
                        "style" -> parseTag(builder, ValkyrieElementTypes.SFC_STYLE)
                        else -> {
                            // 允许其他顶层标签，但标记为错误
                            val errorMarker = builder.mark()
                            // 使用通用的解析器来消费掉这个意外的标签，避免解析器卡住
                            parseTag(builder, ValkyrieElementTypes.XML_ELEMENT)
                            errorMarker.error("Only <template>, <script>, or <style> tags are allowed at the top level")
                        }
                    }
                }

                XmlTokenType.XML_COMMENT_START -> parseComment(builder)
                XmlTokenType.XML_WHITE_SPACE -> builder.advanceLexer() // 忽略顶层空白
                else -> {
                    // 捕获所有其他意外的 token
                    builder.mark().error("Unexpected token at top level")
                    builder.advanceLexer()
                }
            }

            // 安全机制：如果解析器没有前进，则强制前进一个token以避免无限循环
            if (!builder.eof() && builder.currentOffset == initialPosition) {
                builder.mark().error("Parser stalled")
                builder.advanceLexer()
            }
        }

        rootMarker.done(root)
        return builder.treeBuilt
    }

    /**
     * 安全地预览未来 token 的文本，不移动解析器指针
     */
    private fun peekTokenText(builder: PsiBuilder, steps: Int): String? {
        if (steps <= 0) return builder.tokenText
        val mark = builder.mark()
        var currentStep = 0
        while (currentStep < steps && !builder.eof()) {
            builder.advanceLexer()
            currentStep++
        }
        val text = if (!builder.eof()) builder.tokenText else null
        mark.rollbackTo()
        return text
    }

    /**
     * 包含通用XML解析逻辑的伴生对象
     */
    companion object ValkyrieXmlParser {

        /**
         * 解析一个完整的XML标签，从 '<' 开始
         * @param builder PsiBuilder
         * @param rootType 整个标签的根节点类型 (e.g., SFC_TEMPLATE, XML_ELEMENT)
         */
        fun parseTag(builder: PsiBuilder, rootType: IElementType) {
            assert(builder.tokenType == XmlTokenType.XML_START_TAG_START)
            val tagMarker = builder.mark()

            // 1. 解析开始标签
            val tagName = parseStartTag(builder)

            // 如果标签是自闭合的 (e.g., <br/>), 则直接结束
            if (builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
                builder.advanceLexer() // 消费 '/>'
                tagMarker.done(rootType)
                return
            }

            // 消费 '>'
            if (builder.tokenType == XmlTokenType.XML_TAG_END) {
                builder.advanceLexer()
            } else {
                builder.error("Expected '>' or '/>'")
                tagMarker.done(rootType) // 即使有错也要关闭节点
                return
            }

            // 2. 解析标签内容
            parseContent(builder)

            // 3. 解析结束标签
            parseEndTag(builder, tagName)

            tagMarker.done(rootType)
        }

        /**
         * 解析开始标签部分： '<' tagName attr1="val1" ...
         * 返回标签名
         */
        private fun parseStartTag(builder: PsiBuilder): String? {
            val startTagMarker = builder.mark()
            builder.advanceLexer() // 消费 '<'

            var tagName: String? = null
            if (builder.tokenType == XmlTokenType.XML_TAG_NAME) {
                tagName = builder.tokenText
                builder.advanceLexer() // 消费 tagName
            } else {
                builder.error("Tag name expected")
            }

            // 解析属性
            while (builder.tokenType == XmlTokenType.XML_NAME) {
                parseAttribute(builder)
            }

            startTagMarker.done(ValkyrieElementTypes.XML_START_TAG)
            return tagName
        }

        /**
         * 解析单个属性： name="value"
         */
        private fun parseAttribute(builder: PsiBuilder) {
            val attrMarker = builder.mark()
            builder.advanceLexer() // 消费属性名 (XML_NAME)

            if (builder.tokenType == XmlTokenType.XML_EQ) {
                builder.advanceLexer() // 消费 '='
                if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN) {
                    builder.advanceLexer() // 消费属性值
                } else {
                    builder.error("Attribute value expected")
                }
            }
            attrMarker.done(ValkyrieElementTypes.XML_ATTRIBUTE)
        }

        /**
         * 解析标签内容：文本、注释、嵌套标签等
         */
        private fun parseContent(builder: PsiBuilder) {
            val contentMarker = builder.mark()
            while (!builder.eof() && builder.tokenType != XmlTokenType.XML_END_TAG_START) {
                val initialPos = builder.currentOffset
                when (builder.tokenType) {
                    XmlTokenType.XML_START_TAG_START -> parseTag(builder, ValkyrieElementTypes.XML_ELEMENT)
                    XmlTokenType.XML_COMMENT_START -> parseComment(builder)
                    // 处理所有应被视为文本的token
                    XmlTokenType.XML_DATA_CHARACTERS,
                    XmlTokenType.XML_CHAR_ENTITY_REF,
                    XmlTokenType.XML_ENTITY_REF_TOKEN -> {
                        val textMarker = builder.mark()
                        builder.advanceLexer()
                        textMarker.done(ValkyrieElementTypes.XML_TEXT_NODE)
                    }
                    // TODO: 在这里可以添加对 `{...}` 插槽的解析
                    // ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(builder)
                    else -> {
                        // 保护机制，防止未知token导致无限循环
                        builder.error("Unexpected token in tag content")
                        builder.advanceLexer()
                    }
                }
                // 如果解析器没有前进，强制前进以避免死循环
                if (builder.currentOffset == initialPos) {
                    builder.advanceLexer()
                }
            }
            contentMarker.done(ValkyrieElementTypes.XML_TAG_CONTENT)
        }

        /**
         * 解析结束标签： '</' tagName '>'
         */
        private fun parseEndTag(builder: PsiBuilder, expectedTagName: String?) {
            if (builder.tokenType != XmlTokenType.XML_END_TAG_START) {
                // 如果没有找到结束标签，报告错误。这对于像<template>这样的顶层块是严重错误。
                if (expectedTagName != null) {
                    builder.error("Expected closing tag for '<$expectedTagName>'")
                }
                return
            }

            val endTagMarker = builder.mark()
            builder.advanceLexer() // 消费 '</'

            if (builder.tokenType == XmlTokenType.XML_TAG_NAME) {
                if (expectedTagName != null && builder.tokenText != expectedTagName) {
                    builder.error("Mismatched closing tag. Expected '</$expectedTagName>', but found '</${builder.tokenText}>'")
                }
                builder.advanceLexer() // 消费 tagName
            } else {
                builder.error("Tag name expected in closing tag")
            }

            if (builder.tokenType == XmlTokenType.XML_TAG_END) {
                builder.advanceLexer() // 消费 '>'
            } else {
                builder.error("Expected '>' to close the tag")
            }
            endTagMarker.done(ValkyrieElementTypes.XML_END_TAG)
        }

        /**
         * 解析XML注释
         */
        fun parseComment(builder: PsiBuilder) {
            val marker = builder.mark()
            if (builder.tokenType == XmlTokenType.XML_COMMENT_START) {
                while (!builder.eof() && builder.tokenType != XmlTokenType.XML_COMMENT_END) {
                    builder.advanceLexer()
                }
                if (builder.tokenType == XmlTokenType.XML_COMMENT_END) {
                    builder.advanceLexer()
                }
            }
            marker.done(XmlElementType.XML_COMMENT)
        }
    }
}
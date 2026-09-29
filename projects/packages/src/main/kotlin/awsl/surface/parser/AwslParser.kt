package awsl.surface.parser

import awsl.surface.psi.AwslTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType

/**
 * AWSL 语言手动实现的语法解析器
 */
class AwslParser : PsiParser {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()

        while (!builder.eof()) {
            parseTopStatement(builder)
        }

        rootMarker.done(root)
        return builder.treeBuilt
    }

    /**
     * 解析顶层语句
     */
    private fun parseTopStatement(builder: PsiBuilder) {
        when (builder.tokenType) {
            AwslTypes.COMMENT_DOCUMENT -> {
                builder.advanceLexer()
            }
            AwslTypes.STRING -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(AwslTypes.STRING_LITERAL)
            }
            else -> {
                parseCodeStatement(builder)
            }
        }
    }

    /**
     * 解析代码语句
     */
    private fun parseCodeStatement(builder: PsiBuilder) {
        when (builder.tokenType) {
            AwslTypes.HTML_START_TEXT_L -> parseHtmlText(builder)
            AwslTypes.HTML_START_CODE_L -> parseHtmlCode(builder)
            AwslTypes.IF -> parseIfStatement(builder)
            AwslTypes.FOR -> parseForStatement(builder)
            AwslTypes.SYMBOL -> {
                builder.advanceLexer()
            }
            else -> {
                builder.advanceLexer()
            }
        }
    }

    /**
     * 解析 HTML 文本标签 <tag>...</tag>
     */
    private fun parseHtmlText(builder: PsiBuilder) {
        val marker = builder.mark()

        // 解析开始标签
        parseHtmlStartText(builder)

        // 解析内容
        while (!builder.eof() &&
            builder.tokenType != AwslTypes.HTML_END_L &&
            builder.tokenType != AwslTypes.HTML_START_CODE_L) {
            when (builder.tokenType) {
                AwslTypes.HTML_STRING_TOKEN -> builder.advanceLexer()
                AwslTypes.HTML_ESCAPE_TOKEN -> builder.advanceLexer()
                AwslTypes.HTML_START_TEXT_L -> parseHtmlText(builder)
                AwslTypes.HTML_SELF_CLOSE -> parseHtmlSelfClose(builder)
                else -> builder.advanceLexer()
            }
        }

        // 解析代码片段（如果有）
        if (builder.tokenType == AwslTypes.HTML_START_CODE_L) {
            parseHtmlCode(builder)
        }

        // 解析结束标签
        if (builder.tokenType == AwslTypes.HTML_END_L) {
            parseHtmlEnd(builder)
        }

        marker.done(AwslTypes.HTML_TEXT)
    }

    /**
     * 解析 HTML 开始标签 <tag>
     */
    private fun parseHtmlStartText(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 <
        if (builder.tokenType == AwslTypes.HTML_START_TEXT_L) {
            builder.advanceLexer()
        }

        // 解析标签内部（标签名、泛型、属性）
        parseHtmlInner(builder)

        // 消费 >
        if (builder.tokenType == AwslTypes.HTML_START_R) {
            builder.advanceLexer()
        }

        marker.done(AwslTypes.HTML_START_TEXT)
    }

    /**
     * 解析 HTML 代码标签 <\tag>...</tag>
     */
    private fun parseHtmlCode(builder: PsiBuilder) {
        val marker = builder.mark()

        // 解析开始标签 <\...>
        parseHtmlStartCode(builder)

        // 解析代码内容
        while (!builder.eof() && builder.tokenType != AwslTypes.HTML_END_L) {
            parseCodeStatement(builder)
        }

        // 解析结束标签
        if (builder.tokenType == AwslTypes.HTML_END_L) {
            parseHtmlEnd(builder)
        }

        marker.done(AwslTypes.HTML_CODE)
    }

    /**
     * 解析 HTML 代码开始标签 <\tag>
     */
    private fun parseHtmlStartCode(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 <\
        if (builder.tokenType == AwslTypes.HTML_START_CODE_L) {
            builder.advanceLexer()
        }

        // 解析标签内部
        parseHtmlInner(builder)

        // 消费 >
        if (builder.tokenType == AwslTypes.HTML_START_R) {
            builder.advanceLexer()
        }

        marker.done(AwslTypes.HTML_START_CODE)
    }

    /**
     * 解析 HTML 自闭合标签 <tag/>
     */
    private fun parseHtmlSelfClose(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 <
        if (builder.tokenType == AwslTypes.HTML_START_TEXT_L) {
            builder.advanceLexer()
        }

        // 解析标签内部
        parseHtmlInner(builder)

        // 消费 />
        if (builder.tokenType == AwslTypes.HTML_SELF_END_R) {
            builder.advanceLexer()
        }

        marker.done(AwslTypes.HTML_SELF_CLOSE)
    }

    /**
     * 解析 HTML 结束标签 </tag>
     */
    private fun parseHtmlEnd(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 </
        if (builder.tokenType == AwslTypes.HTML_END_L) {
            builder.advanceLexer()
        }

        // 解析标签名（如果有）
        if (builder.tokenType == AwslTypes.HTML_TAG_SYMBOL ||
            builder.tokenType == AwslTypes.HTML_TAG_RAW ||
            builder.tokenType == AwslTypes.HTML_TAG_SCRIPT ||
            builder.tokenType == AwslTypes.HTML_TAG_DIRECTIVE) {
            builder.advanceLexer()
        }

        // 消费 >
        if (builder.tokenType == AwslTypes.HTML_END_R) {
            builder.advanceLexer()
        }

        marker.done(AwslTypes.HTML_END)
    }

    /**
     * 解析标签内部（标签名、泛型、属性）
     */
    private fun parseHtmlInner(builder: PsiBuilder) {
        var condDirective = false
        // 解析标签名
        if (builder.tokenType == AwslTypes.HTML_TAG_SYMBOL ||
            builder.tokenType == AwslTypes.HTML_TAG_RAW ||
            builder.tokenType == AwslTypes.HTML_TAG_SCRIPT ||
            builder.tokenType == AwslTypes.HTML_TAG_DIRECTIVE) {
            val tagMarker = builder.mark()
            if (builder.tokenType == AwslTypes.HTML_TAG_DIRECTIVE) {
                condDirective = builder.tokenText == "if" || builder.tokenText == "else-if"
            }
            builder.advanceLexer()
            tagMarker.done(AwslTypes.HTML_TAG)
        }

        if (condDirective) {
            parseDirectiveCondition(builder)
            return
        }

        // 解析泛型（如果有）
        if (builder.tokenType == AwslTypes.GENERIC_L) {
            parseGeneric(builder)
        }

        // 解析属性
        while (!builder.eof() &&
            builder.tokenType != AwslTypes.HTML_START_R &&
            builder.tokenType != AwslTypes.HTML_SELF_END_R &&
            builder.tokenType != AwslTypes.GENERIC_R) {
            when (builder.tokenType) {
                AwslTypes.SYMBOL -> parseHtmlAttribute(builder)
                com.intellij.psi.TokenType.WHITE_SPACE -> builder.advanceLexer()
                else -> builder.advanceLexer()
            }
        }
    }

    /**
     * `<if atom>` or `<if (complex expr)>` — not bare `<if !foo || bar>`.
     */
    private fun parseDirectiveCondition(builder: PsiBuilder) {
        val marker = builder.mark()
        if (builder.tokenType == AwslTypes.PARENTHESIS_L) {
            parseDirectiveParenExpression(builder)
        } else if (builder.tokenType == AwslTypes.SYMBOL || builder.tokenType == AwslTypes.BOOLEAN) {
            builder.advanceLexer()
        } else {
            builder.error("Expected atom or parenthesized expression after <if>")
        }
        marker.done(AwslTypes.HTML_DIRECTIVE_COND)
    }

    private fun parseDirectiveParenExpression(builder: PsiBuilder) {
        builder.advanceLexer() // (
        var depth = 1
        while (!builder.eof() && depth > 0) {
            when (builder.tokenType) {
                AwslTypes.PARENTHESIS_L -> {
                    depth++
                    builder.advanceLexer()
                }
                AwslTypes.PARENTHESIS_R -> {
                    depth--
                    builder.advanceLexer()
                }
                else -> builder.advanceLexer()
            }
        }
    }

    /**
     * 解析 HTML 属性
     */
    private fun parseHtmlAttribute(builder: PsiBuilder) {
        val marker = builder.mark()

        // 解析属性名
        val keyMarker = builder.mark()
        builder.advanceLexer()
        keyMarker.done(AwslTypes.HTML_KEY)

        // 检查是否是键值对
        if (builder.tokenType == AwslTypes.EQ) {
            builder.advanceLexer()
            parseValue(builder)
            marker.done(AwslTypes.HTML_KV)
        } else {
            marker.drop()
        }
    }

    /**
     * 解析泛型 <T>
     */
    private fun parseGeneric(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 <
        if (builder.tokenType == AwslTypes.GENERIC_L) {
            builder.advanceLexer()
        }

        // 解析泛型项
        while (!builder.eof() && builder.tokenType != AwslTypes.GENERIC_R) {
            when (builder.tokenType) {
                AwslTypes.SYMBOL -> {
                    val itemMarker = builder.mark()
                    builder.advanceLexer()

                    // 检查是否有嵌套泛型
                    if (builder.tokenType == AwslTypes.GENERIC_L) {
                        parseGeneric(builder)
                    }

                    itemMarker.done(AwslTypes.GENERIC_ITEM)
                }
                AwslTypes.COMMA -> builder.advanceLexer()
                com.intellij.psi.TokenType.WHITE_SPACE -> builder.advanceLexer()
                else -> builder.advanceLexer()
            }
        }

        // 消费 >
        if (builder.tokenType == AwslTypes.GENERIC_R) {
            builder.advanceLexer()
        }

        marker.done(AwslTypes.GENERIC)
    }

    /**
     * 解析 if 语句
     */
    private fun parseIfStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 if
        if (builder.tokenType == AwslTypes.IF) {
            builder.advanceLexer()
        }

        // 解析条件表达式
        parseExpression(builder)

        // 解析代码块
        parseBraceBlock(builder)

        // 解析 else（如果有）
        if (builder.tokenType == AwslTypes.ELSE) {
            parseElseStatement(builder)
        }

        marker.done(AwslTypes.IF_STATEMENT)
    }

    /**
     * 解析 else 语句
     */
    private fun parseElseStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 else
        if (builder.tokenType == AwslTypes.ELSE) {
            builder.advanceLexer()
        }

        // 解析代码块
        parseBraceBlock(builder)

        marker.done(AwslTypes.ELSE_STATEMENT)
    }

    /**
     * 解析 for 语句
     */
    private fun parseForStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 for
        if (builder.tokenType == AwslTypes.FOR) {
            builder.advanceLexer()
        }

        // 解析模式（变量名）
        if (builder.tokenType == AwslTypes.SYMBOL) {
            val patternMarker = builder.mark()
            builder.advanceLexer()
            patternMarker.done(AwslTypes.PATTERN)
        }

        // 消费 in
        if (builder.tokenType == AwslTypes.IN) {
            builder.advanceLexer()
        }

        // 解析表达式
        parseExpression(builder)

        // 解析代码块
        parseBraceBlock(builder)

        // 解析 else（如果有）
        if (builder.tokenType == AwslTypes.ELSE) {
            parseElseStatement(builder)
        }

        marker.done(AwslTypes.FOR_STATEMENT)
    }

    /**
     * 解析代码块 {...}
     */
    private fun parseBraceBlock(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 {
        if (builder.tokenType == AwslTypes.BRACE_L) {
            builder.advanceLexer()
        }

        // 解析代码块内容
        while (!builder.eof() && builder.tokenType != AwslTypes.BRACE_R) {
            when (builder.tokenType) {
                AwslTypes.SEMICOLON -> builder.advanceLexer()
                else -> parseCodeStatement(builder)
            }
        }

        // 消费 }
        if (builder.tokenType == AwslTypes.BRACE_R) {
            builder.advanceLexer()
        }

        marker.done(AwslTypes.BRACE_BLOCK)
    }

    /**
     * 解析表达式
     */
    private fun parseExpression(builder: PsiBuilder) {
        when (builder.tokenType) {
            AwslTypes.SYMBOL -> {
                builder.advanceLexer()
            }
            AwslTypes.STRING -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(AwslTypes.STRING_LITERAL)
            }
            AwslTypes.INTEGER, AwslTypes.DECIMAL -> {
                val marker = builder.mark()
                builder.advanceLexer()
                if (builder.tokenType == AwslTypes.NUMBER_UNIT) {
                    builder.advanceLexer()
                }
                marker.done(AwslTypes.NUMBER_LITERAL)
            }
            AwslTypes.BRACE_L -> {
                parseDict(builder)
            }
            AwslTypes.BRACKET_L -> {
                parseList(builder)
            }
            else -> {
                builder.advanceLexer()
            }
        }
    }

    /**
     * 解析字典 {...}
     */
    private fun parseDict(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 {
        if (builder.tokenType == AwslTypes.BRACE_L) {
            builder.advanceLexer()
        }

        // 解析键值对列表
        while (!builder.eof() && builder.tokenType != AwslTypes.BRACE_R) {
            when (builder.tokenType) {
                AwslTypes.SEMICOLON -> builder.advanceLexer()
                AwslTypes.SYMBOL -> parsePair(builder)
                else -> builder.advanceLexer()
            }
        }

        // 消费 }
        if (builder.tokenType == AwslTypes.BRACE_R) {
            builder.advanceLexer()
        }

        marker.done(AwslTypes.DICT)
    }

    /**
     * 解析键值对 key: value
     */
    private fun parsePair(builder: PsiBuilder) {
        val marker = builder.mark()

        // 解析键
        val keyMarker = builder.mark()
        builder.advanceLexer()
        keyMarker.done(AwslTypes.KEY)

        // 消费 :
        if (builder.tokenType == AwslTypes.COLON) {
            builder.advanceLexer()
        }

        // 解析值
        parseValue(builder)

        marker.done(AwslTypes.PAIR)
    }

    /**
     * 解析值
     */
    private fun parseValue(builder: PsiBuilder) {
        val marker = builder.mark()

        when (builder.tokenType) {
            AwslTypes.BRACE_L -> {
                parseDict(builder)
                marker.done(AwslTypes.VALUE)
            }
            AwslTypes.BRACKET_L -> {
                parseList(builder)
                marker.done(AwslTypes.VALUE)
            }
            AwslTypes.STRING -> {
                val stringMarker = builder.mark()
                builder.advanceLexer()
                stringMarker.done(AwslTypes.STRING_LITERAL)
                marker.done(AwslTypes.VALUE)
            }
            AwslTypes.INTEGER, AwslTypes.DECIMAL -> {
                val numberMarker = builder.mark()
                builder.advanceLexer()
                if (builder.tokenType == AwslTypes.NUMBER_UNIT) {
                    builder.advanceLexer()
                }
                numberMarker.done(AwslTypes.NUMBER_LITERAL)
                marker.done(AwslTypes.VALUE)
            }
            AwslTypes.SYMBOL -> {
                builder.advanceLexer()
                marker.done(AwslTypes.VALUE)
            }
            else -> {
                marker.drop()
            }
        }
    }

    /**
     * 解析列表 [...]
     */
    private fun parseList(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 [
        if (builder.tokenType == AwslTypes.BRACKET_L) {
            builder.advanceLexer()
        }

        // 解析值列表
        while (!builder.eof() && builder.tokenType != AwslTypes.BRACKET_R) {
            when (builder.tokenType) {
                AwslTypes.COMMA -> builder.advanceLexer()
                else -> parseValue(builder)
            }
        }

        // 消费 ]
        if (builder.tokenType == AwslTypes.BRACKET_R) {
            builder.advanceLexer()
        }

        marker.done(AwslTypes.LIST)
    }
}

package voml.language.parser

import voml.language.psi.VomlTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType

class VomlParser : PsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()
        while (!builder.eof()) {
            if (!parseExpression(builder)) {
                builder.error("Expected expression")
                builder.advanceLexer()
            }
        }
        rootMarker.done(root)
        return builder.treeBuilt
    }

    private fun parseExpression(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        val parsed = parseScope(builder) ||
            consume(builder, VomlTypes.BACK_TOP) ||
            parseIncludeStatement(builder) ||
            parseInheritStatement(builder) ||
            parseExportStatement(builder) ||
            parseInsertPair(builder) ||
            parseInsertItem(builder) ||
            parseAnnotation(builder) ||
            parseTable(builder) ||
            consume(builder, VomlTypes.SEMICOLON)
        if (!parsed) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.EXPRESSION)
        return true
    }

    private fun parseScope(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parsePaired(builder) { parseScopeInner(it) }) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.SCOPE)
        return true
    }

    private fun parseScopeInner(builder: PsiBuilder): Boolean {
        val hasPrefix = consume(builder, VomlTypes.ACCENT) ||
            consume(builder, VomlTypes.ANGLE_R) ||
            consumeAngleLPlus(builder)
        if (hasPrefix) {
            return parseScopePath(builder)
        }
        if (consumeAngleLPlus(builder)) {
            parseScopePath(builder)
            return true
        }
        return false
    }

    private fun parseScopePath(builder: PsiBuilder): Boolean {
        if (!parseScopeKey(builder)) {
            return false
        }
        while (consume(builder, VomlTypes.DOT)) {
            if (!parseScopeKey(builder)) {
                return false
            }
        }
        return true
    }

    private fun parseScopeKey(builder: PsiBuilder): Boolean =
        parseStringInline(builder) ||
            parseScopeSymbol(builder) ||
            consume(builder, VomlTypes.INTEGER)

    private fun parseScopeSymbol(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.SCOPE_SYMBOL)
        return true
    }

    private fun parseIncludeStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.INCLUDE)) {
            marker.drop()
            return false
        }
        parseStringPrefix(builder)
        if (!parseStringInline(builder)) {
            marker.error("Expected string")
            return false
        }
        if (consume(builder, VomlTypes.AS)) {
            if (!parseKeySymbol(builder)) {
                marker.error("Expected symbol after as")
            }
        } else if (!parsePaired(builder) { parseIncludeInner(it) }) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.INCLUDE_STATEMENT)
        return true
    }

    private fun parseIncludeInner(builder: PsiBuilder): Boolean {
        if (!parseIncludeItem(builder)) {
            return true
        }
        while (true) {
            if (consume(builder, VomlTypes.COMMA)) {
                if (!parseIncludeItem(builder)) {
                    break
                }
                continue
            }
            break
        }
        consume(builder, VomlTypes.COMMA)
        return true
    }

    private fun parseIncludeItem(builder: PsiBuilder): Boolean {
        if (builder.tokenType != VomlTypes.SYMBOL) {
            return false
        }
        val marker = builder.mark()
        parseKeySymbol(builder)
        if (consume(builder, VomlTypes.AS)) {
            if (!parseKeySymbol(builder)) {
                marker.error("Expected symbol after as")
            }
            marker.drop()
            return true
        }
        marker.rollbackTo()
        return parseKeySymbol(builder)
    }

    private fun parseInheritStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.INHERIT)) {
            marker.drop()
            return false
        }
        if (!parsePredefinedSymbol(builder)) {
            parseStringPrefix(builder)
            if (!parseStringInline(builder)) {
                marker.error("Expected symbol or string")
            }
        }
        marker.done(VomlTypes.INHERIT_STATEMENT)
        return true
    }

    private fun parseExportStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.EXPORT)) {
            marker.drop()
            return false
        }
        parseStringPrefix(builder)
        if (!parseStringInline(builder)) {
            marker.error("Expected string")
        }
        marker.done(VomlTypes.EXPORT_STATEMENT)
        return true
    }

    private fun parseInsertPair(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseInsertDot(builder)
        if (!parsePair(builder)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.INSERT_PAIR)
        return true
    }

    private fun parseInsertItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parseInsertStar(builder) || !parseValue(builder)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.INSERT_ITEM)
        return true
    }

    private fun parseInsertDot(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.DOT)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.INSERT_DOT)
        return true
    }

    private fun parseInsertStar(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.STAR)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.INSERT_STAR)
        return true
    }

    private fun parseAnnotation(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parseAnnotationMark(builder) || !parsePaired(builder) { parseAnnoInner(it) }) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.ANNOTATION)
        return true
    }

    private fun parseAnnotationMark(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.AT) || !consume(builder, VomlTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.ANNOTATION_MARK)
        return true
    }

    private fun parseAnnoInner(builder: PsiBuilder): Boolean {
        if (!parseAnnoItem(builder)) {
            return true
        }
        while (consume(builder, VomlTypes.COMMA) && parseAnnoItem(builder)) {
        }
        consume(builder, VomlTypes.COMMA)
        return true
    }

    private fun parseAnnoItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (parseKeySymbol(builder) && consume(builder, VomlTypes.EQ) && parseAnnoValue(builder)) {
            marker.drop()
            return true
        }
        marker.rollbackTo()
        return parseAnnoValue(builder)
    }

    private fun parseAnnoValue(builder: PsiBuilder): Boolean =
        parseValue(builder) || parsePredefinedSymbol(builder)

    private fun parseTable(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseTypeHint(builder)
        if (!parsePaired(builder) { parseTableInner(it) }) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.TABLE)
        return true
    }

    private fun parseTableInner(builder: PsiBuilder): Boolean {
        if (!parseTableItem(builder)) {
            return true
        }
        while (true) {
            if (consume(builder, VomlTypes.COMMA)) {
                if (!parseTableItem(builder)) {
                    break
                }
                continue
            }
            break
        }
        consume(builder, VomlTypes.COMMA)
        return true
    }

    private fun parseTableItem(builder: PsiBuilder): Boolean =
        parsePair(builder) || parseValue(builder)

    private fun parsePair(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parseSymbolPath(builder) || !parseEq(builder) || !parseValue(builder)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.PAIR)
        return true
    }

    private fun parseSymbolPath(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parseKey(builder)) {
            marker.drop()
            return false
        }
        while (consume(builder, VomlTypes.DOT)) {
            if (!parseKey(builder)) {
                marker.error("Expected key after dot")
                break
            }
        }
        marker.done(VomlTypes.SYMBOL_PATH)
        return true
    }

    private fun parseKey(builder: PsiBuilder): Boolean =
        parseStringInline(builder) ||
            parseKeySymbol(builder) ||
            consume(builder, VomlTypes.INTEGER)

    private fun parseKeySymbol(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.KEY_SYMBOL)
        return true
    }

    private fun parseEq(builder: PsiBuilder): Boolean =
        consume(builder, VomlTypes.EQ) || consume(builder, VomlTypes.COLON)

    private fun parseValue(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        val parsed = consume(builder, VomlTypes.NULL) ||
            consume(builder, VomlTypes.BOOLEAN) ||
            parseNum(builder) ||
            parseRef(builder) ||
            parseStr(builder) ||
            parseTable(builder) ||
            parseAnnotation(builder)
        if (!parsed) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.VALUE)
        return true
    }

    private fun parseNum(builder: PsiBuilder): Boolean {
        consume(builder, VomlTypes.SIGN)
        val parsed = consume(builder, VomlTypes.INTEGER) ||
            consume(builder, VomlTypes.DECIMAL) ||
            consume(builder, VomlTypes.DECIMAL_BAD) ||
            consume(builder, VomlTypes.BYTE)
        if (parsed) {
            parseNumberSuffix(builder)
        }
        return parsed
    }

    private fun parseNumberSuffix(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.NUMBER_SUFFIX)
        return true
    }

    private fun parseRef(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.CITE) || !parseSymbolPath(builder)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.REF)
        return true
    }

    private fun parseStr(builder: PsiBuilder): Boolean {
        parseStringPrefix(builder)
        return parseStringInline(builder) || parseStringMulti(builder)
    }

    private fun parseStringPrefix(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.STRING_PREFIX)
        return true
    }

    private fun parseStringInline(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.STRING)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.STRING_INLINE)
        return true
    }

    private fun parseStringMulti(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.QUOTATION)) {
            marker.drop()
            return false
        }
        while (parseChar(builder)) {
        }
        if (!consume(builder, VomlTypes.QUOTATION)) {
            marker.error("Expected closing quote")
        }
        marker.done(VomlTypes.STRING_MULTI)
        return true
    }

    private fun parseChar(builder: PsiBuilder): Boolean =
        parseEscaped(builder) || consume(builder, VomlTypes.NON_ESCAPE)

    private fun parseEscaped(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.ESCAPE) ||
            !(consume(builder, VomlTypes.ESCAPE) || consume(builder, VomlTypes.NON_ESCAPE))
        ) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.ESCAPED)
        return true
    }

    private fun parsePredefinedSymbol(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.PREDEFINED_SYMBOL)
        return true
    }

    private fun parseTypeHint(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VomlTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VomlTypes.TYPE_HINT)
        return true
    }

    private fun parsePaired(builder: PsiBuilder, inner: (PsiBuilder) -> Boolean): Boolean {
        return when (builder.tokenType) {
            VomlTypes.PARENTHESIS_L -> parseDelimited(builder, VomlTypes.PARENTHESIS_L, VomlTypes.PARENTHESIS_R, inner)
            VomlTypes.BRACKET_L -> parseDelimited(builder, VomlTypes.BRACKET_L, VomlTypes.BRACKET_R, inner)
            VomlTypes.BRACE_L -> parseDelimited(builder, VomlTypes.BRACE_L, VomlTypes.BRACE_R, inner)
            else -> false
        }
    }

    private fun parseDelimited(
        builder: PsiBuilder,
        open: IElementType,
        close: IElementType,
        inner: (PsiBuilder) -> Boolean,
    ): Boolean {
        if (!consume(builder, open)) {
            return false
        }
        inner(builder)
        return consume(builder, close)
    }

    private fun consumeAngleLPlus(builder: PsiBuilder): Boolean {
        if (!consume(builder, VomlTypes.ANGLE_L)) {
            return false
        }
        while (consume(builder, VomlTypes.ANGLE_L)) {
        }
        return true
    }

    private fun consume(builder: PsiBuilder, token: IElementType): Boolean {
        if (builder.tokenType != token) {
            return false
        }
        builder.advanceLexer()
        return true
    }
}

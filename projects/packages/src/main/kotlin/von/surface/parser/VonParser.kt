package von.surface.parser

import von.surface.psi.VonTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType

class VonParser : PsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()
        if (!parseTable(builder)) {
            while (!builder.eof()) {
                if (!parseExpression(builder)) {
                    builder.error("Expected expression")
                    builder.advanceLexer()
                }
            }
        }
        while (!builder.eof()) {
            builder.advanceLexer()
        }
        rootMarker.done(root)
        return builder.treeBuilt
    }

    private fun parseExpression(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        val parsed = parseScope(builder) ||
            consume(builder, VonTypes.BACK_TOP) ||
            parseIncludeStatement(builder) ||
            parseInheritStatement(builder) ||
            parseExportStatement(builder) ||
            parseInsertPair(builder) ||
            parseInsertItem(builder) ||
            parseAnnotation(builder) ||
            parseTable(builder) ||
            consume(builder, VonTypes.SEMICOLON)
        if (!parsed) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.EXPRESSION)
        return true
    }

    private fun parseScope(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parsePaired(builder) { parseScopeInner(it) }) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.SCOPE)
        return true
    }

    private fun parseScopeInner(builder: PsiBuilder): Boolean {
        val hasPrefix = consume(builder, VonTypes.ACCENT) ||
            consume(builder, VonTypes.ANGLE_R) ||
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
        while (consume(builder, VonTypes.DOT)) {
            if (!parseScopeKey(builder)) {
                return false
            }
        }
        return true
    }

    private fun parseScopeKey(builder: PsiBuilder): Boolean =
        parseStringInline(builder) ||
            parseScopeSymbol(builder) ||
            consume(builder, VonTypes.INTEGER)

    private fun parseScopeSymbol(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.SCOPE_SYMBOL)
        return true
    }

    private fun parseIncludeStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.INCLUDE)) {
            marker.drop()
            return false
        }
        parseStringPrefix(builder)
        if (!parseStringInline(builder)) {
            marker.error("Expected string")
            return false
        }
        if (consume(builder, VonTypes.AS)) {
            if (!parseKeySymbol(builder)) {
                marker.error("Expected symbol after as")
            }
        } else if (!parsePaired(builder) { parseIncludeInner(it) }) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.INCLUDE_STATEMENT)
        return true
    }

    private fun parseIncludeInner(builder: PsiBuilder): Boolean {
        if (!parseIncludeItem(builder)) {
            return true
        }
        while (true) {
            if (consume(builder, VonTypes.COMMA)) {
                if (!parseIncludeItem(builder)) {
                    break
                }
                continue
            }
            break
        }
        consume(builder, VonTypes.COMMA)
        return true
    }

    private fun parseIncludeItem(builder: PsiBuilder): Boolean {
        if (builder.tokenType != VonTypes.SYMBOL) {
            return false
        }
        val marker = builder.mark()
        parseKeySymbol(builder)
        if (consume(builder, VonTypes.AS)) {
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
        if (!consume(builder, VonTypes.INHERIT)) {
            marker.drop()
            return false
        }
        if (!parsePredefinedSymbol(builder)) {
            parseStringPrefix(builder)
            if (!parseStringInline(builder)) {
                marker.error("Expected symbol or string")
            }
        }
        marker.done(VonTypes.INHERIT_STATEMENT)
        return true
    }

    private fun parseExportStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.EXPORT)) {
            marker.drop()
            return false
        }
        parseStringPrefix(builder)
        if (!parseStringInline(builder)) {
            marker.error("Expected string")
        }
        marker.done(VonTypes.EXPORT_STATEMENT)
        return true
    }

    private fun parseInsertPair(builder: PsiBuilder): Boolean {
        if (builder.tokenType != VonTypes.DOT) {
            return false
        }
        val marker = builder.mark()
        if (!parseInsertDot(builder) || !parsePair(builder)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.INSERT_PAIR)
        return true
    }

    private fun parseInsertItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parseInsertStar(builder) || !parseValue(builder)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.INSERT_ITEM)
        return true
    }

    private fun parseInsertDot(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.DOT)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.INSERT_DOT)
        return true
    }

    private fun parseInsertStar(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.STAR)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.INSERT_STAR)
        return true
    }

    private fun parseAnnotation(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parseAnnotationMark(builder) || !parsePaired(builder) { parseAnnoInner(it) }) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.ANNOTATION)
        return true
    }

    private fun parseAnnotationMark(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.AT) || !consume(builder, VonTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.ANNOTATION_MARK)
        return true
    }

    private fun parseAnnoInner(builder: PsiBuilder): Boolean {
        if (!parseAnnoItem(builder)) {
            return true
        }
        while (consume(builder, VonTypes.COMMA) && parseAnnoItem(builder)) {
        }
        consume(builder, VonTypes.COMMA)
        return true
    }

    private fun parseAnnoItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (parseKeySymbol(builder) && consume(builder, VonTypes.EQ) && parseAnnoValue(builder)) {
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
        if (!parseDelimited(builder, VonTypes.BRACE_L, VonTypes.BRACE_R, ::parseTableInner)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.TABLE)
        return true
    }

    private fun parseTableInner(builder: PsiBuilder): Boolean {
        if (!parseTableItem(builder)) {
            return true
        }
        while (true) {
            if (consume(builder, VonTypes.COMMA)) {
                if (!parseTableItem(builder)) {
                    break
                }
                continue
            }
            break
        }
        consume(builder, VonTypes.COMMA)
        return true
    }

    private fun parseTableItem(builder: PsiBuilder): Boolean =
        parsePair(builder) || parseValue(builder)

    private fun parsePair(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parseSymbolPath(builder) || !parseEq(builder)) {
            marker.drop()
            return false
        }
        // Incomplete `key:` / `key=` is still a pair so IDE completion can target the value site.
        if (!parseValue(builder)) {
            builder.error("Expected value")
        }
        marker.done(VonTypes.PAIR)
        return true
    }

    private fun parseSymbolPath(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parseKey(builder)) {
            marker.drop()
            return false
        }
        while (consume(builder, VonTypes.DOT)) {
            if (!parseKey(builder)) {
                marker.error("Expected key after dot")
                break
            }
        }
        marker.done(VonTypes.SYMBOL_PATH)
        return true
    }

    private fun parseKey(builder: PsiBuilder): Boolean =
        parseStringInline(builder) ||
            parseKeySymbol(builder) ||
            consume(builder, VonTypes.INTEGER)

    private fun parseKeySymbol(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.KEY_SYMBOL)
        return true
    }

    private fun parseEq(builder: PsiBuilder): Boolean =
        consume(builder, VonTypes.EQ) || consume(builder, VonTypes.COLON)

    private fun parseArray(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!parseDelimited(builder, VonTypes.BRACKET_L, VonTypes.BRACKET_R, ::parseArrayInner)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.TABLE)
        return true
    }

    private fun parseArrayInner(builder: PsiBuilder): Boolean {
        if (!parseValue(builder)) {
            return true
        }
        while (true) {
            if (consume(builder, VonTypes.COMMA)) {
                if (!parseValue(builder)) {
                    break
                }
                continue
            }
            break
        }
        consume(builder, VonTypes.COMMA)
        return true
    }

    private fun parseValue(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        val parsed = consume(builder, VonTypes.NULL) ||
            consume(builder, VonTypes.BOOLEAN) ||
            parseNum(builder) ||
            parseRef(builder) ||
            parseStr(builder) ||
            parseArray(builder) ||
            parseTable(builder) ||
            parseAnnotation(builder)
        if (!parsed) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.VALUE)
        return true
    }

    private fun parseNum(builder: PsiBuilder): Boolean {
        consume(builder, VonTypes.SIGN)
        val parsed = consume(builder, VonTypes.INTEGER) ||
            consume(builder, VonTypes.DECIMAL) ||
            consume(builder, VonTypes.DECIMAL_BAD) ||
            consume(builder, VonTypes.BYTE)
        if (parsed) {
            parseNumberSuffix(builder)
        }
        return parsed
    }

    private fun parseNumberSuffix(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.NUMBER_SUFFIX)
        return true
    }

    private fun parseRef(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.CITE) || !parseSymbolPath(builder)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.REF)
        return true
    }

    private fun parseStr(builder: PsiBuilder): Boolean {
        parseStringPrefix(builder)
        return parseStringInline(builder) || parseStringMulti(builder)
    }

    private fun parseStringPrefix(builder: PsiBuilder): Boolean {
        if (builder.tokenType != VonTypes.SYMBOL) {
            return false
        }
        val next = builder.lookAhead(1)
        if (next != VonTypes.STRING && next != VonTypes.QUOTATION) {
            return false
        }
        val marker = builder.mark()
        if (!consume(builder, VonTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.STRING_PREFIX)
        return true
    }

    private fun parseStringInline(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.STRING)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.STRING_INLINE)
        return true
    }

    private fun parseStringMulti(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.QUOTATION)) {
            marker.drop()
            return false
        }
        while (parseChar(builder)) {
        }
        if (!consume(builder, VonTypes.QUOTATION)) {
            marker.error("Expected closing quote")
        }
        marker.done(VonTypes.STRING_MULTI)
        return true
    }

    private fun parseChar(builder: PsiBuilder): Boolean =
        parseEscaped(builder) || consume(builder, VonTypes.NON_ESCAPE)

    private fun parseEscaped(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.ESCAPE) ||
            !(consume(builder, VonTypes.ESCAPE) || consume(builder, VonTypes.NON_ESCAPE))
        ) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.ESCAPED)
        return true
    }

    private fun parsePredefinedSymbol(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (!consume(builder, VonTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.PREDEFINED_SYMBOL)
        return true
    }

    private fun parseTypeHint(builder: PsiBuilder): Boolean {
        if (builder.tokenType != VonTypes.SYMBOL || builder.lookAhead(1) != VonTypes.BRACE_L) {
            return false
        }
        val marker = builder.mark()
        if (!consume(builder, VonTypes.SYMBOL)) {
            marker.drop()
            return false
        }
        marker.done(VonTypes.TYPE_HINT)
        return true
    }

    private fun parsePaired(builder: PsiBuilder, inner: (PsiBuilder) -> Boolean): Boolean {
        return when (builder.tokenType) {
            VonTypes.PARENTHESIS_L -> parseDelimited(builder, VonTypes.PARENTHESIS_L, VonTypes.PARENTHESIS_R, inner)
            VonTypes.BRACKET_L -> parseDelimited(builder, VonTypes.BRACKET_L, VonTypes.BRACKET_R, inner)
            VonTypes.BRACE_L -> parseDelimited(builder, VonTypes.BRACE_L, VonTypes.BRACE_R, inner)
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
        if (!consume(builder, VonTypes.ANGLE_L)) {
            return false
        }
        while (consume(builder, VonTypes.ANGLE_L)) {
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

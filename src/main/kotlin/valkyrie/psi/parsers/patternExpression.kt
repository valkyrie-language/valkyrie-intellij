package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes


fun parsePattern(valkyrieParser: ValkyrieParser, builder: PsiBuilder, allowBare: Boolean): Boolean {
    return when {
        parseTuplePattern(valkyrieParser, builder) -> true
        parseTablePattern(valkyrieParser, builder) -> true
        parseObjectPattern(valkyrieParser, builder) -> true
        allowBare && parseBarePattern(valkyrieParser, builder) -> true
        else -> false
    }
}

fun parseBarePattern(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    valkyrieParser.parseModifierList(builder)
    if (!valkyrieParser.parseIdentifier(builder)) {
        marker.rollbackTo()
        return false
    }
    marker.done(ValkyrieElementTypes.BARE_PATTERN)
    return true
}

// [T; N] - removed duplicate, keeping the Boolean version below
// [a, b, c]
// [a: b, b: c]
fun parseTablePattern(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.BRACKET_L) return false
    val marker = builder.mark()

    builder.advanceLexer() // consume '['

    // Parse pattern list
    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BRACKET_R) {
        // Handle rest pattern ..rest
        if (builder.tokenType == ValkyrieTokenTypes.DOT_DOT) {
            builder.advanceLexer() // consume '..'
            if (!valkyrieParser.parseIdentifier(builder)) {
                marker.error("Expected identifier after '..'")
                return false
            }
        } else if (!parsePattern(valkyrieParser, builder, true)) {
            if (!valkyrieParser.parseIdentifier(builder)) {
                marker.error("Expected pattern or identifier")
                return false
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
            builder.advanceLexer()
        } else if (builder.tokenType != ValkyrieTokenTypes.BRACKET_R) {
            marker.error("Expected ',' or ']'")
            return false
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.BRACKET_R) {
        builder.advanceLexer() // consume ']'
    } else {
        marker.error("Expected ']'")
        return false
    }

    marker.done(ValkyrieElementTypes.TABLE_PATTERN)
    return true
}

fun parseTuplePattern(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_L) return false
    val marker = builder.mark()

    builder.advanceLexer() // consume '('

    // Parse pattern list
    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_R) {
        if (!parsePattern(valkyrieParser, builder, true)) {
            if (!valkyrieParser.parseIdentifier(builder)) {
                marker.error("Expected pattern or identifier")
                return false
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
            builder.advanceLexer()
        } else if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_R) {
            marker.error("Expected ',' or ')'")
            return false
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
        builder.advanceLexer() // consume ')'
    } else {
        marker.error("Expected ')'")
        return false
    }

    marker.done(ValkyrieElementTypes.TUPLE_PATTERN)
    return true
}

fun parseObjectPattern(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) return false
    val marker = builder.mark()

    builder.advanceLexer() // consume '{'

    // Parse pattern fields
    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
        // Handle rest pattern ..rest or ..
        if (builder.tokenType == ValkyrieTokenTypes.DOT_DOT) {
            builder.advanceLexer() // consume '..'
            // Optional identifier after ..
            valkyrieParser.parseIdentifier(builder)
        } else {
            // Parse field pattern: identifier or identifier: pattern
            if (!valkyrieParser.parseIdentifier(builder)) {
                marker.error("Expected field name")
                return false
            }

            // Optional type annotation or pattern
            if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                builder.advanceLexer() // consume ':'
                if (!parsePattern(valkyrieParser, builder, true)) {
                    if (!valkyrieParser.parseIdentifier(builder)) {
                        marker.error("Expected pattern after ':'")
                        return false
                    }
                }
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
            builder.advanceLexer()
        } else if (builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
            marker.error("Expected ',' or '}'")
            return false
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
        builder.advanceLexer() // consume '}'
    } else {
        marker.error("Expected '}'")
        return false
    }

    marker.done(ValkyrieElementTypes.OBJECT_PATTERN)
    return true
}

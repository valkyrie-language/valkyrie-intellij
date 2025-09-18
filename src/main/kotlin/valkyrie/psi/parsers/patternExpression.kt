package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder

fun parsePattern(valkyrieParser: ValkyrieParser, builder: PsiBuilder, allowBare: Boolean): Boolean {
    return when {
        parseTuplePattern(valkyrieParser, builder) -> true
//        parseTablePattern(valkyrieParser, builder) -> true
//        parseObjectPattern(valkyrieParser, builder) -> true
        allowBare && parseBarePattern(valkyrieParser, builder) -> true
        else -> false
    }
}

fun parseBarePattern(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    parser.parseModifierList(builder)
    if (!parseIdentifier(builder)) {
        marker.rollbackTo()
        return false
    }
    marker.done(ValkyrieTypes.BARE_PATTERN)
    return true
}

// [T; N] - removed duplicate, keeping the Boolean version below
// [a, b, c]
// [a: b, b: c]
fun parseTablePattern(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTypes.BRACKET_L) return false
    val marker = builder.mark()

    builder.advanceLexer() // consume '['

    // Parse pattern list
    while (!builder.eof() && builder.tokenType != ValkyrieTypes.BRACKET_R) {
        // Handle rest pattern ..rest
        if (builder.tokenType == ValkyrieTypes.DOT_DOT) {
            builder.advanceLexer() // consume '..'
            if (!parseIdentifier(builder)) {
                marker.error("Expected identifier after '..'")
                return false
            }
        } else if (!parsePattern(valkyrieParser, builder, true)) {
            if (!parseIdentifier(builder)) {
                marker.error("Expected pattern or identifier")
                return false
            }
        }

        if (builder.tokenType == ValkyrieTypes.COMMA) {
            builder.advanceLexer()
        } else if (builder.tokenType != ValkyrieTypes.BRACKET_R) {
            marker.error("Expected ',' or ']'")
            return false
        }
    }

    if (builder.tokenType == ValkyrieTypes.BRACKET_R) {
        builder.advanceLexer() // consume ']'
    } else {
        marker.error("Expected ']'")
        return false
    }

    marker.done(ValkyrieTypes.TABLE_PATTERN)
    return true
}

fun parseTuplePattern(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTypes.PARENTHESIS_L) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer() // consume '('
    // Parse pattern list
    while (!builder.eof() && builder.tokenType != ValkyrieTypes.PARENTHESIS_R) {
        if (!parsePattern(parser, builder, true)) {
            if (!parseIdentifier(builder)) {
                marker.error("Expected pattern or identifier")
                return false
            }
        }

        if (builder.tokenType == ValkyrieTypes.COMMA) {
            builder.advanceLexer()
        } else if (builder.tokenType != ValkyrieTypes.PARENTHESIS_R) {
            marker.error("Expected ',' or ')'")
            return false
        }
    }

    if (builder.tokenType == ValkyrieTypes.PARENTHESIS_R) {
        builder.advanceLexer() // consume ')'
    } else {
        marker.error("Expected ')'")
        return false
    }

    marker.done(ValkyrieTypes.TUPLE_PATTERN)
    return true
}

fun parseObjectPattern(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTypes.BRACE_L) return false
    val marker = builder.mark()

    builder.advanceLexer() // consume '{'

    // Parse pattern fields
    while (!builder.eof() && builder.tokenType != ValkyrieTypes.BRACE_R) {
        // Handle rest pattern ..rest or ..
        if (builder.tokenType == ValkyrieTypes.DOT_DOT) {
            builder.advanceLexer() // consume '..'
            // Optional identifier after ..
            parseIdentifier(builder)
        } else {
            // Parse field pattern: identifier or identifier: pattern
            if (!parseIdentifier(builder)) {
                marker.error("Expected field name")
                return false
            }

            // Optional type annotation or pattern
            if (builder.tokenType == ValkyrieTypes.COLON) {
                builder.advanceLexer() // consume ':'
                if (!parsePattern(valkyrieParser, builder, true)) {
                    if (!parseIdentifier(builder)) {
                        marker.error("Expected pattern after ':'")
                        return false
                    }
                }
            }
        }

        if (builder.tokenType == ValkyrieTypes.COMMA) {
            builder.advanceLexer()
        } else if (builder.tokenType != ValkyrieTypes.BRACE_R) {
            marker.error("Expected ',' or '}'")
            return false
        }
    }

    if (builder.tokenType == ValkyrieTypes.BRACE_R) {
        builder.advanceLexer() // consume '}'
    } else {
        marker.error("Expected '}'")
        return false
    }

    marker.done(ValkyrieTypes.OBJECT_PATTERN)
    return true
}

package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieTokenTypes


fun parseGenericParameterList(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
        builder.advanceLexer()
    }
    // <T, U,>
    if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
        builder.advanceLexer() // consume '<'
        if (parseGenericParameterItem(valkyrieParser, builder)) {
            while (builder.tokenType != ValkyrieTokenTypes.ANGLE_R) {
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (parseGenericParameterItem(valkyrieParser, builder)) {

                } else {
                    marker.error("Expected parameter name")
                    return false
                }
            }
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
            }
        }
        if (builder.tokenType == ValkyrieTokenTypes.ANGLE_R) {
            builder.advanceLexer() // consume '>'
        } else {
            marker.error("Expected '>' to close generic parameter list")
            return false
        }
    }
    // ⟨T, U, ⟩
    else if (builder.tokenType == ValkyrieTokenTypes.GENERIC_L) {
        builder.advanceLexer() // consume '⟨'
        if (parseGenericParameterItem(valkyrieParser, builder)) {
            while (builder.tokenType != ValkyrieTokenTypes.ANGLE_R) {
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (parseGenericParameterItem(valkyrieParser, builder)) {
                    continue
                } else {
                    marker.error("Expected parameter name")
                    return false
                }
            }
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
            }
        }
        if (builder.tokenType == ValkyrieTokenTypes.GENERIC_R) {
            builder.advanceLexer() // consume '>'
        } else {
            marker.error("Expected '>' to close generic parameter list")
            return false
        }
    }
    marker.done(ValkyrieElementTypes.GENERIC_PARAMETER_LIST)
    return true
}

fun parseGenericParameterItem(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()

    // Parse annotations and modifiers
    valkyrieParser.parseAnnotations(builder, withModifiers = true)

    // Parse identifier
    if (!valkyrieParser.parseIdentifier(builder)) {
        marker.error("Expected parameter name")
        return false
    }

    // Parse optional type constraint
    valkyrieParser.parseTypeHint(builder)

    // Parse optional default type
    valkyrieParser.parseDefaultType(builder)

    marker.done(ValkyrieElementTypes.GENERIC_PARAMETER)
    return true
}

// term level 支持两种泛型语法 ⟨T⟩ 和 ::<T>
// type level 额外支持一种 <T>
fun parseGenericArgumentList(valkyrieParser: ValkyrieParser, builder: PsiBuilder, typeLevel: Boolean): Boolean {
    val marker = builder.mark()
    // term level must have double colon
    var unicodeMode = false;
    if (builder.tokenType == ValkyrieTokenTypes.GENERIC_L) {
        builder.advanceLexer()
        unicodeMode = true;
    }
    // A<T>
    else if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
        if (!typeLevel) {
            marker.rollbackTo();
            return false
        }
        builder.advanceLexer()
        unicodeMode = false
    }
    // A::< >
    else if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
        // ::< >
        if (builder.lookAhead(1) == ValkyrieTokenTypes.ANGLE_L) {
            builder.advanceLexer()
            builder.advanceLexer()
            unicodeMode = false;
        }
        // invalid
        else {
            if (!typeLevel) {
                marker.rollbackTo();
                return false
            }
        }
    }

    // argument (, + argument)*
    if (parseGenericArgumentItem(valkyrieParser, builder)) {
        // (, + argument)*
        while (builder.tokenType != ValkyrieTokenTypes.ANGLE_R) {
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // consume ','
            } else {
                break
            }
            if (parseGenericArgumentItem(valkyrieParser, builder)) {
                continue
            }
            // unknown
            else {
                marker.error("Expected argument item")
                return false
            }
        }
        // skip option comma
        if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
            builder.advanceLexer()
        }
    }
    // consume '>'
    if (unicodeMode && builder.tokenType == ValkyrieTokenTypes.GENERIC_R) {
        builder.advanceLexer()
        return true
    }
    // consume '>'
    else if (!unicodeMode && builder.tokenType == ValkyrieTokenTypes.ANGLE_R) {
        builder.advanceLexer()
        return true
    }
    // unknown node
    else {
        marker.error("Expected '>' to close generic argument list")
        return false
    }
}

fun parseGenericArgumentItem(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    // Parse type expression as generic argument
    if (parseTypeExpression(valkyrieParser, builder, true)) {
        marker.done(ValkyrieElementTypes.EXPRESSION)
        return true
    } else {
        marker.drop()
        return false
    }
}

// inline 表示允许 { } 表达式
fun parseTypeExpression(valkyrieParser: ValkyrieParser, builder: PsiBuilder, inline: Boolean): Boolean {
    return parseTypeExpressionWithPrecedence(valkyrieParser, builder, 0, inline)
}

fun parseTypeExpressionWithPrecedence(valkyrieParser: ValkyrieParser, builder: PsiBuilder, minPrecedence: Int, inline: Boolean): Boolean {
    TODO()
}

fun parsePrimaryType(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    return valkyrieParser.parseIdentifier(builder)
}

val typePrefixPrecedences = mapOf(
    ValkyrieTokenTypes.PLUS to 5, // +T
    ValkyrieTokenTypes.MINUS to 5, // -T
)
val typeInfixPrecedences = mapOf(
    ValkyrieTokenTypes.PIPE to 1, // T | U
    ValkyrieTokenTypes.AMPERSAND to 2, // T & U
    ValkyrieTokenTypes.PLUS to 3, // T + U
    ValkyrieTokenTypes.MINUS to 3, // T - U
    ValkyrieTokenTypes.ARROW to 4, // T -> U
)

val typePostfixPrecedences = mapOf(
    ValkyrieTokenTypes.WOW to 6,  // T!
    ValkyrieTokenTypes.WHAT to 6, // T?
    ValkyrieTokenTypes.ANGLE_L to 7, // parseGenericArgumentList  A<T>
    ValkyrieTokenTypes.DOUBLE_COLON to 7, // parseGenericArgumentList  A::<T>
)

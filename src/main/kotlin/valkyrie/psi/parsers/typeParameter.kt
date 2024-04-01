import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.parsers.ValkyrieParser

fun ValkyrieParser.parseGenericParameterList(builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
        builder.advanceLexer()
    }
    // <T, U,>
    if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
        builder.advanceLexer() // consume '<'
        if (parseGenericParameterItem(builder)) {
            while (builder.tokenType != ValkyrieTokenTypes.ANGLE_R) {
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (parseGenericParameterItem(builder)) {

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
        if (parseGenericParameterItem(builder)) {
            while (builder.tokenType != ValkyrieTokenTypes.ANGLE_R) {
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (parseGenericParameterItem(builder)) {
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

fun ValkyrieParser.parseGenericParameterItem(builder: PsiBuilder): Boolean {
    val marker = builder.mark()

    // Parse annotations and modifiers
    parseAnnotations(builder, withModifiers = true)

    // Parse identifier
    if (!parseIdentifier(builder)) {
        marker.error("Expected parameter name")
        return false
    }

    // Parse optional type constraint
    parseTypeHint(builder)

    // Parse optional default type
    parseDefaultType(builder)

    marker.done(ValkyrieElementTypes.GENERIC_PARAMETER)
    return true
}

// term level 支持两种泛型语法 ⟨T⟩ 和 ::<T>
// type level 额外支持一种 <T>
fun ValkyrieParser.parseGenericArgumentList(builder: PsiBuilder, typeLevel: Boolean): Boolean {
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
    if (parseGenericArgumentItem(builder)) {
        // (, + argument)*
        while (builder.tokenType != ValkyrieTokenTypes.ANGLE_R) {
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // consume ','
            } else {
                break
            }
            if (parseGenericArgumentItem(builder)) {
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


private fun ValkyrieParser.parseGenericArgumentItem(builder: PsiBuilder): Boolean {
    val marker = builder.mark()

    // Parse type expression as generic argument
    if (parseTypeExpression(builder, true)) {
        marker.done(ValkyrieElementTypes.EXPRESSION)
        return true
    } else {
        marker.drop()
        return false
    }
}
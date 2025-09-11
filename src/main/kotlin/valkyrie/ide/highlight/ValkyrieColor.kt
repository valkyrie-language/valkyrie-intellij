package valkyrie.ide.highlight

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.OptionsBundle
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.util.NlsContexts.AttributeDescriptor
import valkyrie.language.ValkyrieBundle
import java.util.function.Supplier
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default

enum class ValkyrieColor(humanName: Supplier<@AttributeDescriptor String>, default: TextAttributesKey? = null) {
    // 特殊关键词
    KEYWORD(OptionsBundle.messagePointer("options.language.defaults.keyword"), Default.KEYWORD),

    // 字面量
    NULL(ValkyrieBundle.messagePointer("color.token.null"), Default.KEYWORD),
    BOOLEAN(ValkyrieBundle.messagePointer("color.token.boolean"), Default.KEYWORD),
    NUMBER(ValkyrieBundle.messagePointer("color.token.number"), Default.NUMBER),
    STRING(ValkyrieBundle.messagePointer("color.token.string"), Default.STRING),
    TEXT(ValkyrieBundle.messagePointer("color.token.text"), STRING.textAttributesKey),
    STRING_ESCAPED(ValkyrieBundle.messagePointer("color.token.text"), Default.VALID_STRING_ESCAPE),
    STRING_BAD(ValkyrieBundle.messagePointer("color.token.text"), Default.INVALID_STRING_ESCAPE),

    // 标识符
    IDENTIFIER(OptionsBundle.messagePointer("options.language.defaults.identifier"), Default.IDENTIFIER),
    SYM_CLASS(ValkyrieBundle.messagePointer("color.token.type.class"), Default.CLASS_NAME),
    SYM_TRAIT(ValkyrieBundle.messagePointer("color.token.type.trait"), Default.INTERFACE_NAME),
    SYM_TYPE(ValkyrieBundle.messagePointer("color.token.symbol.type"), Default.CLASS_NAME),


    SYM_FIELD(ValkyrieBundle.messagePointer("color.token.symbol.field"), Default.INSTANCE_FIELD),
    SYMBOL_LOCAL(ValkyrieBundle.messagePointer("color.token.symbol.local"), Default.LOCAL_VARIABLE),
    SYM_UNION(ValkyrieBundle.messagePointer("color.token.type.union"), Default.CLASS_REFERENCE),
    SYM_VARIANT(ValkyrieBundle.messagePointer("color.token.symbol.variant"), Default.STATIC_FIELD),

    //    SYM_ATTRIBUTE(WitBundle.messagePointer("color.token.symbol.attribute"), Default.STATIC_METHOD),
//    SYM_VARIABLE(WitBundle.messagePointer("color.token.symbol.variable"), Default.REASSIGNED_PARAMETER),
    SYMBOL_FUNCTION(ValkyrieBundle.messagePointer("color.token.symbol.function"), Default.STATIC_METHOD),
    SYMBOL_METHOD(ValkyrieBundle.messagePointer("color.token.symbol.function"), Default.INSTANCE_METHOD),
    SYMBOL_METHOD_MUT(ValkyrieBundle.messagePointer("color.token.symbol.function"), Default.INSTANCE_METHOD),

    SYMBOL_GENERIC(ValkyrieBundle.messagePointer("color.token.symbol.generic"), Default.PREDEFINED_SYMBOL),
    SYM_BUILTIN(ValkyrieBundle.messagePointer("color.token.symbol.builtin"), Default.PREDEFINED_SYMBOL),

    // 标点符号
    PARENTHESES(OptionsBundle.messagePointer("options.language.defaults.parentheses"), Default.PARENTHESES),
    BRACKETS(OptionsBundle.messagePointer("options.language.defaults.brackets"), Default.BRACKETS),
    BRACES(OptionsBundle.messagePointer("options.language.defaults.braces"), Default.BRACES),
    DOT(OptionsBundle.messagePointer("options.language.defaults.dot"), Default.DOT),
    COMMA(OptionsBundle.messagePointer("options.language.defaults.comma"), Default.COMMA),
    OPERATION(ValkyrieBundle.messagePointer("color.token.set"), Default.OPERATION_SIGN),
    SEMICOLON(OptionsBundle.messagePointer("options.language.defaults.semicolon"), Default.SEMICOLON),

    // 注释
    LINE_COMMENT(OptionsBundle.messagePointer("options.language.defaults.line.comment"), Default.LINE_COMMENT),
    BLOCK_COMMENT(OptionsBundle.messagePointer("options.language.defaults.block.comment"), Default.BLOCK_COMMENT),
    DOC_COMMENT(OptionsBundle.messagePointer("options.language.defaults.doc.markup"), Default.DOC_COMMENT),

    // 错误
    BAD_CHARACTER(
        OptionsBundle.messagePointer("options.java.attribute.descriptor.bad.character"),
        HighlighterColors.BAD_CHARACTER
    ),

    // 废弃
    EXTENSION(OptionsBundle.messagePointer("options.language.defaults.metadata"), Default.METADATA),
    ;

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("valkyrie.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}

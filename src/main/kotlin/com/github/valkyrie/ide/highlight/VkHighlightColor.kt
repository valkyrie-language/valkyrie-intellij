package com.github.valkyrie.ide.highlight

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.OptionsBundle
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.util.NlsContexts.AttributeDescriptor
import java.util.function.Supplier
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default
import com.github.valkyrie.ValkyrieBundle;

enum class VkHighlightColor(humanName: Supplier<@AttributeDescriptor String>, default: TextAttributesKey? = null) {
    // 特殊关键词
    KEYWORD(OptionsBundle.messagePointer("options.language.defaults.keyword"), Default.KEYWORD),
    IDIOM_SYMBOL(ValkyrieBundle.messagePointer("color.token.symbol.idiom"), Default.METADATA),
    IDIOM_MARK(ValkyrieBundle.messagePointer("color.token.idiom_mark"), IDIOM_SYMBOL.textAttributesKey),
    PROP_MARK(ValkyrieBundle.messagePointer("color.token.properties_mark"), KEYWORD.textAttributesKey),

    // 字面量
    NULL(ValkyrieBundle.messagePointer("color.token.null"), Default.KEYWORD),
    BOOLEAN(ValkyrieBundle.messagePointer("color.token.boolean"), Default.KEYWORD),
    DECIMAL(ValkyrieBundle.messagePointer("color.token.decimal"), Default.NUMBER),
    INTEGER(ValkyrieBundle.messagePointer("color.token.integer"), Default.NUMBER),
    STRING(ValkyrieBundle.messagePointer("color.token.string"), Default.STRING),
    TEXT(ValkyrieBundle.messagePointer("color.token.text"), STRING.textAttributesKey),
    STRING_ESCAPED(ValkyrieBundle.messagePointer("color.token.text"), Default.VALID_STRING_ESCAPE),
    STRING_BAD(ValkyrieBundle.messagePointer("color.token.text"), Default.INVALID_STRING_ESCAPE),
    // 标识符
    IDENTIFIER(OptionsBundle.messagePointer("options.language.defaults.identifier"), Default.IDENTIFIER),
    SYM_MESSAGE(ValkyrieBundle.messagePointer("color.token.symbol.message"), Default.STATIC_FIELD),
    SYM_TERM(ValkyrieBundle.messagePointer("color.token.symbol.term"), Default.CONSTANT),
    SYM_ATTRIBUTE(ValkyrieBundle.messagePointer("color.token.symbol.attribute"), Default.STATIC_METHOD),
    SYM_VARIABLE(ValkyrieBundle.messagePointer("color.token.symbol.variable"), Default.REASSIGNED_PARAMETER),
    SYM_FUNCTION(ValkyrieBundle.messagePointer("color.token.symbol.function"), Default.PREDEFINED_SYMBOL),
    SYM_CLASS(ValkyrieBundle.messagePointer("color.token.symbol.class"), Default.CLASS_NAME),
    SYM_TRAIT(ValkyrieBundle.messagePointer("color.token.symbol.trait"), Default.INTERFACE_NAME),
    //
    TYPE_HINT(ValkyrieBundle.messagePointer("color.token.symbol.type"), Default.CLASS_NAME),

    // 标点符号
    PARENTHESES(OptionsBundle.messagePointer("options.language.defaults.parentheses"), Default.PARENTHESES),
    BRACKETS(OptionsBundle.messagePointer("options.language.defaults.brackets"), Default.BRACKETS),
    BRACES(OptionsBundle.messagePointer("options.language.defaults.braces"), Default.BRACES),
    DOT(OptionsBundle.messagePointer("options.language.defaults.dot"), Default.DOT),
    STAR(ValkyrieBundle.messagePointer("color.token.default"), Default.KEYWORD),
    COMMA(OptionsBundle.messagePointer("options.language.defaults.comma"), Default.COMMA),
    SET(ValkyrieBundle.messagePointer("color.token.set"), Default.OPERATION_SIGN),
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

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("voml.lang.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}

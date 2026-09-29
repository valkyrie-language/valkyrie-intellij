package valkyrie.ide.highlight

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.XmlHighlighterColors
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
    SYM_UNION(ValkyrieBundle.messagePointer("color.token.type.union"), Default.CLASS_REFERENCE),
    SYM_VARIANT(ValkyrieBundle.messagePointer("color.token.type.variant"), Default.STATIC_FIELD),
    NEURAL_DECLARATION(ValkyrieBundle.messagePointer("color.token.type.neural"), Default.CLASS_NAME),
    WIDGET_DECLARATION(ValkyrieBundle.messagePointer("color.token.type.widget"), Default.CLASS_NAME),
    SINGLETON_DECLARATION(ValkyrieBundle.messagePointer("color.token.type.singleton"), Default.CLASS_NAME),
    TRAIT_DECLARATION(ValkyrieBundle.messagePointer("color.token.type.trait"), Default.CLASS_NAME),
    UNION_DECLARATION(ValkyrieBundle.messagePointer("color.token.type.union"), Default.CLASS_NAME),
    VARIANT_DECLARATION(ValkyrieBundle.messagePointer("color.token.type.variant"), Default.CLASS_NAME),
    FIELD_DECLARATION(ValkyrieBundle.messagePointer("color.token.type.field"), Default.INSTANCE_FIELD),
    DOMAIN_DECLARATION(ValkyrieBundle.messagePointer("color.token.type.domain"), Default.CLASS_NAME),
    MODIFIER_NODE(ValkyrieBundle.messagePointer("color.token.modifier"), Default.KEYWORD),

    SYM_FIELD(ValkyrieBundle.messagePointer("color.token.symbol.field"), Default.INSTANCE_FIELD),
    SYM_FIELD_SUPER(ValkyrieBundle.messagePointer("color.token.symbol.field.super"), Default.PREDEFINED_SYMBOL),
    SYM_LOCAL(ValkyrieBundle.messagePointer("color.token.symbol.local"), Default.LOCAL_VARIABLE),
    SYM_LOCAL_MUT(ValkyrieBundle.messagePointer("color.token.symbol.local"), Default.REASSIGNED_LOCAL_VARIABLE),
    SYM_ARG(ValkyrieBundle.messagePointer("color.token.symbol.builtin"), Default.PARAMETER),
    SYM_ARG_MUT(ValkyrieBundle.messagePointer("color.token.symbol.builtin"), Default.PARAMETER),
    SYM_SELF(ValkyrieBundle.messagePointer("color.token.symbol.builtin"), Default.KEYWORD),
    SYM_SELF_MUT(ValkyrieBundle.messagePointer("color.token.symbol.builtin"), Default.KEYWORD),

    SYM_MICRO(ValkyrieBundle.messagePointer("color.token.symbol.micro"), Default.FUNCTION_DECLARATION),
    SYM_MEZZO(ValkyrieBundle.messagePointer("color.token.symbol.mezzo"), Default.CLASS_NAME),
    SYM_MACRO(ValkyrieBundle.messagePointer("color.token.symbol.macro"), Default.KEYWORD),

    SYM_ATTRIBUTE(ValkyrieBundle.messagePointer("color.token.symbol.attribute"), Default.STATIC_METHOD),
//    SYM_VARIABLE(ValkyrieBundle.messagePointer("color.token.symbol.variable"), Default.REASSIGNED_PARAMETER),

    SYM_FUNCTION_SELF(ValkyrieBundle.messagePointer("color.token.symbol.function"), Default.INSTANCE_METHOD),
    SYM_METHOD_MUT(ValkyrieBundle.messagePointer("color.token.symbol.function"), Default.INSTANCE_METHOD),

    SYM_GENERIC(ValkyrieBundle.messagePointer("color.token.type.generic"), Default.METADATA),
    SYM_DOMAIN(ValkyrieBundle.messagePointer("color.token.symbol.modifier"), Default.METADATA),
    SYM_MODIFIER(ValkyrieBundle.messagePointer("color.token.symbol.domain"), Default.KEYWORD),


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
    
    // 元编程语法
    COMPILE_TIME_BLOCK(ValkyrieBundle.messagePointer("color.token.compile.time.block"), Default.METADATA),
    TEMPLATE_BLOCK(ValkyrieBundle.messagePointer("color.token.template.block"), Default.TEMPLATE_LANGUAGE_COLOR),
    XML_TAG_NAME(ValkyrieBundle.messagePointer("color.token.template.block"), XmlHighlighterColors.HTML_TAG_NAME),
    XML_ATTRIBUTE_NAME(ValkyrieBundle.messagePointer("color.token.template.block"), XmlHighlighterColors.HTML_ATTRIBUTE_NAME),
    ;

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("valkyrie.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}

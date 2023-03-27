package valkyrie.ide.highlight

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.OptionsBundle
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.util.NlsContexts.AttributeDescriptor
import valkyrie.language.ValkyrieBundle
import java.util.function.Supplier
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default


enum class HighlightColor(humanName: Supplier<@AttributeDescriptor String>, default: TextAttributesKey? = null) {
    // 特殊关键词
    KEYWORD(OptionsBundle.messagePointer("options.language.defaults.keyword"), Default.KEYWORD),
    MODIFIER(ValkyrieBundle.messagePointer("valkyrie.highlight.modifier"), Default.KEYWORD),

    // 字面量
    NULL(ValkyrieBundle.messagePointer("color.token.null"), Default.KEYWORD),
    BOOLEAN(ValkyrieBundle.messagePointer("color.token.boolean"), Default.KEYWORD),
    BYTE(ValkyrieBundle.messagePointer("color.token.byte"), Default.NUMBER),
    INTEGER(ValkyrieBundle.messagePointer("color.token.integer"), Default.NUMBER),
    DECIMAL(ValkyrieBundle.messagePointer("color.token.decimal"), Default.NUMBER),
    STRING(ValkyrieBundle.messagePointer("color.token.string"), Default.STRING),
    TEXT(ValkyrieBundle.messagePointer("color.token.text"), STRING.textAttributesKey),
    STRING_ESCAPED(ValkyrieBundle.messagePointer("color.token.text"), Default.VALID_STRING_ESCAPE),
    STRING_BAD(ValkyrieBundle.messagePointer("color.token.text"), Default.INVALID_STRING_ESCAPE),

    // 标识符
    IDENTIFIER(OptionsBundle.messagePointer("options.language.defaults.identifier"), Default.IDENTIFIER),
    SYM_TYPE(ValkyrieBundle.messagePointer("color.token.symbol.trait"), Default.CLASS_REFERENCE),
    RULE_CLASS(ValkyrieBundle.messagePointer("color.token.symbol.class"), Default.CLASS_NAME),
    RULE_UNION(ValkyrieBundle.messagePointer("color.token.symbol.variant"), Default.INTERFACE_NAME),
    SYM_MACRO(ValkyrieBundle.messagePointer("color.token.symbol.macro"), Default.METADATA),
    SYM_LANGUAGE(ValkyrieBundle.messagePointer("color.token.symbol.macro"), Default.METADATA),
    SYM_LOCAL(ValkyrieBundle.messagePointer("color.token.symbol.local"), Default.LOCAL_VARIABLE),
    SYM_LOCAL_MUT(ValkyrieBundle.messagePointer("color.token.symbol.local.mutable"), Default.REASSIGNED_LOCAL_VARIABLE),
    SYM_GLOBAL(ValkyrieBundle.messagePointer("color.token.symbol.global"), Default.GLOBAL_VARIABLE),
    SYM_GLOBAL_MUT(ValkyrieBundle.messagePointer("color.token.symbol.global.mut"), Default.GLOBAL_VARIABLE),
    TAG_NODE(ValkyrieBundle.messagePointer("color.token.symbol.parameter"), Default.PARAMETER),
    TAG_BRANCH(ValkyrieBundle.messagePointer("color.token.symbol.parameter"), Default.PARAMETER),
    SYM_FIELD(ValkyrieBundle.messagePointer("color.token.symbol.field"), Default.INSTANCE_FIELD),
    SYM_CONSTANT(ValkyrieBundle.messagePointer("color.token.symbol.constant"), Default.CONSTANT),
    SYM_BUILTIN(ValkyrieBundle.messagePointer("color.token.symbol.built.in"), Default.CONSTANT),
    SYM_FUNCTION(ValkyrieBundle.messagePointer("color.token.symbol.function.self"), Default.INSTANCE_METHOD),
    SYM_ARGUMENT(ValkyrieBundle.messagePointer("color.token.symbol.type"), Default.PARAMETER),

    // 标点符号
    ASSIGN(ValkyrieBundle.messagePointer("color.token.set"), Default.OPERATION_SIGN),
    OPERATION(OptionsBundle.messagePointer("options.language.defaults.operation"), Default.OPERATION_SIGN),
    OP_NUMBER(ValkyrieBundle.messagePointer("color.token.number.suffix"), Default.METADATA),
    OP_STRING(ValkyrieBundle.messagePointer("color.token.string.prefix"), Default.KEYWORD),
    COMMENT_LINE(OptionsBundle.messagePointer("options.language.defaults.line.comment"), Default.LINE_COMMENT),
    COMMENT_BLOCK(OptionsBundle.messagePointer("options.language.defaults.block.comment"), Default.BLOCK_COMMENT),
    ;

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("voml.lang.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}

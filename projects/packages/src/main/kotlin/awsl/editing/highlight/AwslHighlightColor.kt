package awsl.editing.highlight

import awsl.surface.file.AwslBundle.messagePointer
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.XmlHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.util.NlsContexts
import java.util.function.Supplier
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default

enum class AwslHighlightColor(humanName: Supplier<@NlsContexts.AttributeDescriptor String>, default: TextAttributesKey? = null) {
    KEYWORD(messagePointer("color.defaults.keyword"), Default.KEYWORD),
    METADATA(messagePointer("color.token.symbol.idiom"), Default.METADATA),
    KEYWORD_TAG(messagePointer("color.token.idiom_mark"), KEYWORD.textAttributesKey),

    NULL(messagePointer("color.token.null"), Default.KEYWORD),
    BOOLEAN(messagePointer("color.token.boolean"), Default.KEYWORD),
    DECIMAL(messagePointer("color.token.decimal"), Default.NUMBER),
    INTEGER(messagePointer("color.token.integer"), Default.NUMBER),
    STRING(messagePointer("color.token.string"), Default.STRING),
    URL(messagePointer("color.token.url"), STRING.textAttributesKey),
    TYPE_HINT(messagePointer("color.token.symbol.type"), Default.CLASS_NAME),
    NUM_HINT(messagePointer("color.token.symbol.type"), Default.PREDEFINED_SYMBOL),

    IDENTIFIER(messagePointer("color.defaults.identifier"), Default.IDENTIFIER),
    SYM_ANNO(messagePointer("color.token.symbol.annotation"), Default.STATIC_METHOD),
    SYM_PROP(messagePointer("color.token.symbol.property"), Default.STATIC_FIELD),
    SYM_SCHEMA(messagePointer("color.token.symbol.schema"), Default.PREDEFINED_SYMBOL),

    HTML_BEGIN(messagePointer("color.token.template.begin"), XmlHighlighterColors.HTML_TAG),
    HTML_END(messagePointer("color.token.template.end"), XmlHighlighterColors.HTML_TAG),
    HTML_TAG(messagePointer("color.token.template.name"), Default.CLASS_NAME),
    HTML_TEXT(messagePointer("color.token.template.text"), XmlHighlighterColors.XML_TAG_DATA),
    HTML_ESCAPE(messagePointer("color.token.template.escape"), XmlHighlighterColors.HTML_ENTITY_REFERENCE),

    PARENTHESES(messagePointer("color.defaults.parentheses"), Default.PARENTHESES),
    BRACKETS(messagePointer("color.defaults.brackets"), Default.BRACKETS),
    BRACES(messagePointer("color.defaults.braces"), Default.BRACES),
    DOT(messagePointer("color.defaults.dot"), Default.DOT),
    COMMA(messagePointer("color.defaults.comma"), Default.COMMA),
    SET(messagePointer("color.token.set"), Default.OPERATION_SIGN),
    SEMICOLON(messagePointer("color.defaults.semicolon"), Default.SEMICOLON),

    LINE_COMMENT(messagePointer("color.defaults.line.comment"), Default.LINE_COMMENT),
    BLOCK_COMMENT(messagePointer("color.defaults.block.comment"), Default.BLOCK_COMMENT),
    DOC_COMMENT(messagePointer("color.defaults.doc.markup"), Default.DOC_COMMENT),

    BAD_CHARACTER(messagePointer("color.defaults.bad.character"), HighlighterColors.BAD_CHARACTER),

    EXTENSION(messagePointer("color.defaults.metadata"), Default.METADATA),
    ;

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("awsl.lang.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}

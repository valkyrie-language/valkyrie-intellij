package valkyrie.highlighting

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import valkyrie.language.ValkyrieIcons
import javax.swing.Icon

/**
 * Valkyrie 颜色设置页面
 */
class ValkyrieColorSettingsPage : ColorSettingsPage {
    
    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Keyword", ValkyrieSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("String", ValkyrieSyntaxHighlighter.STRING),
            AttributesDescriptor("Number", ValkyrieSyntaxHighlighter.NUMBER),
            AttributesDescriptor("Comment", ValkyrieSyntaxHighlighter.COMMENT),
            AttributesDescriptor("Identifier", ValkyrieSyntaxHighlighter.IDENTIFIER),
            AttributesDescriptor("Operator", ValkyrieSyntaxHighlighter.OPERATOR),
            AttributesDescriptor("Parentheses", ValkyrieSyntaxHighlighter.PARENTHESES),
            AttributesDescriptor("Braces", ValkyrieSyntaxHighlighter.BRACES),
            AttributesDescriptor("Brackets", ValkyrieSyntaxHighlighter.BRACKETS),
            AttributesDescriptor("Semicolon", ValkyrieSyntaxHighlighter.SEMICOLON),
            AttributesDescriptor("Comma", ValkyrieSyntaxHighlighter.COMMA),
            AttributesDescriptor("Dot", ValkyrieSyntaxHighlighter.DOT),
            // 语义高亮
            AttributesDescriptor("Class Name", ValkyrieAnnotator.CLASS_NAME),
            AttributesDescriptor("Trait Name", ValkyrieAnnotator.TRAIT_NAME),
            AttributesDescriptor("Union Name", ValkyrieAnnotator.UNION_NAME),
            AttributesDescriptor("Variant Name", ValkyrieAnnotator.VARIANT_NAME),
            AttributesDescriptor("Modifier", ValkyrieAnnotator.MODIFIER),
            AttributesDescriptor("Field Name", ValkyrieAnnotator.FIELD_NAME),
            AttributesDescriptor("Method Name", ValkyrieAnnotator.METHOD_NAME),
            AttributesDescriptor("Static Method Name", ValkyrieAnnotator.STATIC_METHOD_NAME),
            AttributesDescriptor("Domain Name", ValkyrieAnnotator.DOMAIN_NAME)
        )
        
        private val DEMO_TEXT = """
            // Valkyrie 语言示例
            let x = 42;
            let name = "Valkyrie";
            let result = x + 10;
            
            if (x > 0) {
                let y = x * 2;
                return y;
            } else {
                return 0;
            }
            
            function fibonacci(n) {
                if (n <= 1) {
                    return n;
                }
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        """.trimIndent()
    }
    
    override fun getIcon(): Icon = ValkyrieIcons.FILE
    
    override fun getHighlighter(): SyntaxHighlighter = ValkyrieSyntaxHighlighter()
    
    override fun getDemoText(): String = DEMO_TEXT
    
    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null
    
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS
    
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
    
    override fun getDisplayName(): String = "Valkyrie"
}
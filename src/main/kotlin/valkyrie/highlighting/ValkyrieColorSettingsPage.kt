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
            // 词法级别高亮
            AttributesDescriptor("Keyword", ValkyrieSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("String", ValkyrieSyntaxHighlighter.STRING),
            AttributesDescriptor("Number", ValkyrieSyntaxHighlighter.NUMBER),
            AttributesDescriptor("Comment", ValkyrieSyntaxHighlighter.COMMENT),
            AttributesDescriptor("Identifier", ValkyrieSyntaxHighlighter.IDENTIFIER),
            AttributesDescriptor("Operator", ValkyrieSyntaxHighlighter.OPERATOR),
            AttributesDescriptor("Metadata", ValkyrieSyntaxHighlighter.METADATA),
            AttributesDescriptor("Parentheses", ValkyrieSyntaxHighlighter.PARENTHESES),
            AttributesDescriptor("Braces", ValkyrieSyntaxHighlighter.BRACES),
            AttributesDescriptor("Brackets", ValkyrieSyntaxHighlighter.BRACKETS),
            AttributesDescriptor("Semicolon", ValkyrieSyntaxHighlighter.SEMICOLON),
            AttributesDescriptor("Comma", ValkyrieSyntaxHighlighter.COMMA),
            AttributesDescriptor("Dot", ValkyrieSyntaxHighlighter.DOT),
            AttributesDescriptor("Bad Character", ValkyrieSyntaxHighlighter.BAD_CHARACTER),
            
            // 语义级别高亮
            AttributesDescriptor("Class Name", ValkyrieSemanticHighlighter.CLASS_NAME),
            AttributesDescriptor("Trait Name", ValkyrieSemanticHighlighter.TRAIT_NAME),
            AttributesDescriptor("Union Name", ValkyrieSemanticHighlighter.UNION_NAME),
            AttributesDescriptor("Variant Name", ValkyrieSemanticHighlighter.VARIANT_NAME),
            AttributesDescriptor("Field Name", ValkyrieSemanticHighlighter.FIELD_NAME),
            AttributesDescriptor("Method Name", ValkyrieSemanticHighlighter.METHOD_NAME),
            AttributesDescriptor("Static Method", ValkyrieSemanticHighlighter.STATIC_METHOD),
            AttributesDescriptor("Instance Method", ValkyrieSemanticHighlighter.INSTANCE_METHOD),
            AttributesDescriptor("Domain Name", ValkyrieSemanticHighlighter.DOMAIN_NAME),
            AttributesDescriptor("Modifier", ValkyrieSemanticHighlighter.MODIFIER),
            
            // 特殊染色
            AttributesDescriptor("Dead Code", ValkyrieAnnotator.DEAD_CODE),
            AttributesDescriptor("Unused Symbol", ValkyrieAnnotator.UNUSED_SYMBOL)
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
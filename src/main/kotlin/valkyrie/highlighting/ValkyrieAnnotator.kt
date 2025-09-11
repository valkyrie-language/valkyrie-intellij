package valkyrie.highlighting

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.nodes.*
import valkyrie.psi.ValkyrieElementNode

/**
 * Valkyrie 语义注解器，用于提供语义级别的语法高亮
 */
class ValkyrieAnnotator : Annotator {
    
    companion object {
        // 定义语义高亮颜色
        val CLASS_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_CLASS_NAME",
            DefaultLanguageHighlighterColors.CLASS_NAME
        )
        
        val TRAIT_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_TRAIT_NAME",
            DefaultLanguageHighlighterColors.INTERFACE_NAME
        )
        
        val UNION_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_UNION_NAME",
            DefaultLanguageHighlighterColors.CLASS_NAME
        )
        
        val VARIANT_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_VARIANT_NAME",
            DefaultLanguageHighlighterColors.STATIC_FIELD
        )
        
        val FIELD_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_FIELD_NAME",
            DefaultLanguageHighlighterColors.INSTANCE_FIELD
        )
        
        val METHOD_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_METHOD_NAME",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
        )
        
        val STATIC_METHOD_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_STATIC_METHOD_NAME",
            DefaultLanguageHighlighterColors.STATIC_METHOD
        )
        
        val DOMAIN_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_DOMAIN_NAME",
            DefaultLanguageHighlighterColors.METADATA
        )
        
        val MODIFIER = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_MODIFIER",
            DefaultLanguageHighlighterColors.KEYWORD
        )
    }
    
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            // Class 声明中的类名
             is ValkyrieClassStatementNode -> {
                 val nameElement = element.children.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                 nameElement?.let {
                     holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                         .range(it.textRange)
                         .textAttributes(CLASS_NAME)
                         .create()
                 }
             }
            
            // Union 声明中的联合类型名
             is ValkyrieUnionDeclaration -> {
                 val nameElement = element.children.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                 nameElement?.let {
                     holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                         .range(it.textRange)
                         .textAttributes(UNION_NAME)
                         .create()
                 }
             }
            
            // Trait 声明中的特征名和 Modifier 高亮
             is ValkyrieElementNode -> {
                 when (element.node.elementType.toString()) {
                     "TRAIT_STATEMENT" -> {
                         val nameElement = element.children.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                         nameElement?.let {
                             holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                                 .range(it.textRange)
                                 .textAttributes(TRAIT_NAME)
                                 .create()
                         }
                     }
                     "MODIFIER" -> {
                         holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                             .range(element.textRange)
                             .textAttributes(MODIFIER)
                             .create()
                     }
                 }
             }
            
            // Variant 声明中的变体名
             is ValkyrieVariantDeclaration -> {
                 val nameElement = element.children.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                 nameElement?.let {
                     holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                         .range(it.textRange)
                         .textAttributes(VARIANT_NAME)
                         .create()
                 }
             }
            
            // Field 声明中的字段名
            is ValkyrieFieldDeclaration -> {
                val identifierPattern = element.children.find { it is ValkyrieIdentifierPatternNode } as? ValkyrieIdentifierPatternNode
                val nameElement = identifierPattern?.children?.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                nameElement?.let {
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(it.textRange)
                        .textAttributes(FIELD_NAME)
                        .create()
                }
            }
            
            // Method 声明中的方法名
            is ValkyrieMethodDeclaration -> {
                val identifierPattern = element.children.find { it is ValkyrieIdentifierPatternNode } as? ValkyrieIdentifierPatternNode
                val nameElement = identifierPattern?.children?.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                nameElement?.let {
                    // 基础方法名高亮，静态方法检测由 ValkyrieHighlightVisitor 处理
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(it.textRange)
                        .textAttributes(METHOD_NAME)
                        .create()
                }
            }
            
            // Domain 声明中的域名
            is ValkyrieDomainDeclaration -> {
                val identifierPattern = element.children.find { it is ValkyrieIdentifierPatternNode } as? ValkyrieIdentifierPatternNode
                val nameElement = identifierPattern?.children?.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                nameElement?.let {
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(it.textRange)
                        .textAttributes(DOMAIN_NAME)
                        .create()
                }
            }

        }
    }
}
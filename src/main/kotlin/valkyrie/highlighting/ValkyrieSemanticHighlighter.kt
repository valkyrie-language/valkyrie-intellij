package valkyrie.highlighting

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.nodes.*
import valkyrie.psi.ValkyrieElementNode

/**
 * Valkyrie 语义高亮访问器
 * 负责常规的语义高亮，如类名、特征名、方法名、域名、修饰符等
 */
class ValkyrieSemanticHighlighter : HighlightVisitor {
    
    companion object {
        // 语义高亮颜色定义
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
        
        val STATIC_METHOD = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_STATIC_METHOD",
            DefaultLanguageHighlighterColors.STATIC_METHOD
        )
        
        val INSTANCE_METHOD = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_INSTANCE_METHOD",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
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
    
    private var myHolder: HighlightInfoHolder? = null
    
    override fun suitableForFile(file: PsiFile): Boolean {
        return file.language.id == "valkyrie"
    }
    
    override fun visit(element: PsiElement) {
        when (element) {
            // Class 声明中的类名
            is ValkyrieClassDeclaration -> {
                val nameElement = element.children.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                nameElement?.let {
                    addHighlight(it, CLASS_NAME)
                }
            }
            
            // Union 声明中的联合类型名
            is ValkyrieUnionDeclaration -> {
                val nameElement = element.children.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                nameElement?.let {
                    addHighlight(it, UNION_NAME)
                }
            }
            
            // Trait 声明中的特征名和 Modifier 高亮
            is ValkyrieElementNode -> {
                when (element.node.elementType.toString()) {
                    "TRAIT_STATEMENT" -> {
                        val nameElement = element.children.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                        nameElement?.let {
                            addHighlight(it, TRAIT_NAME)
                        }
                    }
                    "MODIFIER" -> {
                        addHighlight(element, MODIFIER)
                    }
                }
            }
            
            // Variant 声明中的变体名
            is ValkyrieVariantDeclaration -> {
                val nameElement = element.children.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                nameElement?.let {
                    addHighlight(it, VARIANT_NAME)
                }
            }
            
            // Field 声明中的字段名
            is ValkyrieFieldDeclaration -> {
                val identifierPattern = element.children.find { it is ValkyrieIdentifierPatternNode } as? ValkyrieIdentifierPatternNode
                val nameElement = identifierPattern?.children?.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                nameElement?.let {
                    addHighlight(it, FIELD_NAME)
                }
            }
            
            // Method 声明中的方法名
            is ValkyrieMethodDeclaration -> {
                highlightMethod(element)
            }
            
            // Domain 声明中的域名
            is ValkyrieDomainDeclaration -> {
                val identifierPattern = element.children.find { it is ValkyrieIdentifierPatternNode } as? ValkyrieIdentifierPatternNode
                val nameElement = identifierPattern?.children?.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
                nameElement?.let {
                    addHighlight(it, DOMAIN_NAME)
                }
            }
        }
    }
    
    private fun highlightMethod(method: ValkyrieMethodDeclaration) {
        val identifierPattern = method.children.find { it is ValkyrieIdentifierPatternNode } as? ValkyrieIdentifierPatternNode
        val nameElement = identifierPattern?.children?.find { it.node.elementType == ValkyrieTokenTypes.IDENTIFIER }
        nameElement?.let {
            // 检查方法是否有 self 参数来判断是否为静态方法
            val isStaticMethod = !hasSelParameter(method)
            val attributesKey = if (isStaticMethod) STATIC_METHOD else INSTANCE_METHOD
            addHighlight(it, attributesKey)
        }
    }
    
    private fun addHighlight(element: PsiElement, attributesKey: TextAttributesKey) {
        val info = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
            .range(element)
            .textAttributes(attributesKey)
            .create()
            
        myHolder?.add(info)
    }
    
    private fun hasSelParameter(method: ValkyrieMethodDeclaration): Boolean {
        // 查找参数列表
        val parameterList = method.children.find { child ->
            child.children.any { it.text == "self" }
        }
        return parameterList != null
    }
    
    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable
    ): Boolean {
        myHolder = holder
        try {
            action.run()
        } finally {
            myHolder = null
        }
        return true
    }
    
    override fun clone(): HighlightVisitor {
        return ValkyrieSemanticHighlighter()
    }
}
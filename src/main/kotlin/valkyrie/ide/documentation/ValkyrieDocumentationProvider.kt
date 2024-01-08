package valkyrie.ide.documentation

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.*
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Valkyrie 文档提供者
 * 用于在IDE中显示文档注释
 */
class ValkyrieDocumentationProvider : AbstractDocumentationProvider() {
    
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        if (element == null) return null
        
        // 查找关联的doc comment
        val docComment = findDocComment(element)
        if (docComment != null) {
            return buildDocumentation(element, docComment)
        }
        
        return null
    }
    
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        if (element == null) return null
        
        return when (element) {
            is ValkyrieClassDeclaration -> "class ${element.name}"
            is ValkyrieUnionDeclaration -> "union ${element.name}"
            is ValkyrieTraitDeclaration -> "trait ${element.name}"
            is ValkyrieMethodDeclaration -> "method ${element.name}"
            is ValkyrieFieldDeclaration -> "field ${element.name}"
            else -> null
        }
    }
    
    /**
     * 查找元素关联的doc comment
     */
    private fun findDocComment(element: PsiElement): ValkyrieDocCommentNode? {
        // 向前查找doc comment
        var prev = PsiTreeUtil.getPrevSiblingOfType(element, PsiElement::class.java)
        
        while (prev != null) {
            when {
                prev is ValkyrieDocCommentNode -> return prev
                prev.node.elementType == ValkyrieTokenTypes.WHITESPACE ||
                prev.node.elementType == ValkyrieTokenTypes.NEWLINE -> {
                    prev = PsiTreeUtil.getPrevSiblingOfType(prev, PsiElement::class.java)
                }
                else -> break
            }
        }
        
        return null
    }
    
    /**
     * 构建文档内容
     */
    private fun buildDocumentation(element: PsiElement, docComment: ValkyrieDocCommentNode): String {
        val signature = getElementSignature(element)
        val documentation = docComment.renderToHtml()
        
        return buildString {
            append("<div class='definition'>")
            append("<pre>$signature</pre>")
            append("</div>")
            
            if (documentation.isNotEmpty()) {
                append("<div class='content'>")
                append(documentation)
                append("</div>")
            }
        }
    }
    
    /**
     * 获取元素签名
     */
    private fun getElementSignature(element: PsiElement): String {
        return when (element) {
            is ValkyrieClassDeclaration -> {
                val modifiers = getModifiersText(element)
                "$modifiers class ${element.name}"
            }
            is ValkyrieUnionDeclaration -> {
                "union ${element.name}"
            }
            is ValkyrieTraitDeclaration -> {
                "trait ${element.name}"
            }
            is ValkyrieMethodDeclaration -> {
                val modifiers = getModifiersText(element)
                val params = getParametersText(element)
                "$modifiers method ${element.name}($params)"
            }
            is ValkyrieFieldDeclaration -> {
                val modifiers = getModifiersText(element)
                val type = getTypeText(element)
                "$modifiers field ${element.name}: $type"
            }
            else -> element.text ?: ""
        }
    }
    
    private fun getModifiersText(element: PsiElement): String {
        return when (element) {
            is ValkyrieClassDeclaration -> element.getModifierNodes().mapNotNull { it.getModifierName() }.joinToString(" ")
            is ValkyrieMethodDeclaration -> element.getModifierNodes().mapNotNull { it.getModifierName() }.joinToString(" ")
            is ValkyrieFieldDeclaration -> element.getModifierNodes().mapNotNull { it.getModifierName() }.joinToString(" ")
            else -> ""
        }
    }
    
    private fun getParametersText(method: ValkyrieMethodDeclaration): String {
        val paramList = method.getParameterList()
        return paramList?.text ?: ""
    }
    
    private fun getTypeText(field: ValkyrieFieldDeclaration): String {
        val typeRef = field.getTypeReference()
        return typeRef?.text ?: "unknown"
    }
}
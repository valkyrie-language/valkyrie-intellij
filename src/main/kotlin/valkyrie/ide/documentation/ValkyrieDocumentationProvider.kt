package valkyrie.ide.documentation

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.*
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Valkyrie 文档提供者
 * 使用IntelliJ内置文档功能，移除自定义HTML渲染
 */
class ValkyrieDocumentationProvider : AbstractDocumentationProvider() {
    
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        if (element == null) return null
        
        // 查找关联的doc comment
        val docComment = findDocComment(element)
        if (docComment != null) {
            // 使用内置功能：直接返回纯文本内容，让IntelliJ处理格式化
            return docComment.getMergedDocComment()
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
    

}
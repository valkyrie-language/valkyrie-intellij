package valkyrie.ide.documentation

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.*
import valkyrie.psi.ValkyrieTokenTypes
import javax.swing.Icon

/**
 * Valkyrie 文档提供者
 * 支持左侧小图标切换渲染和文本模式
 */
class ValkyrieDocumentationProvider : AbstractDocumentationProvider() {
    
    companion object {
        private val RENDER_ICON: Icon = IconLoader.getIcon("/icons/showCacheable.svg", ValkyrieDocumentationProvider::class.java)
        private val TEXT_ICON: Icon = IconLoader.getIcon("/icons/untyped.svg", ValkyrieDocumentationProvider::class.java)
    }
    
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        if (element == null) return null
        
        // 查找关联的doc comment
        val docComment = findDocComment(element)
        if (docComment != null) {
            val content = docComment.getMergedDocComment()
            return when (DocumentRenderModeManager.getCurrentMode()) {
                DocumentRenderMode.RENDERED -> formatAsRendered(content, element)
                DocumentRenderMode.TEXT -> formatAsText(content)
            }
        }
        
        return null
    }
    
    /**
     * 格式化为渲染模式
     */
    private fun formatAsRendered(content: String, element: PsiElement): String {
        val elementInfo = getElementInfo(element)
        
        return buildString {
            append(DocumentationMarkup.DEFINITION_START)
            append(elementInfo)
            append(DocumentationMarkup.DEFINITION_END)
            append(DocumentationMarkup.CONTENT_START)
            append(renderMarkdown(content))
            append(DocumentationMarkup.CONTENT_END)
        }
    }
    
    /**
     * 格式化为文本模式
     */
    private fun formatAsText(content: String): String {
        return buildString {
            append(DocumentationMarkup.CONTENT_START)
            append("<pre>")
            append(content.replace("<", "&lt;").replace(">", "&gt;"))
            append("</pre>")
            append(DocumentationMarkup.CONTENT_END)
        }
    }
    
    /**
     * 获取元素信息
     */
    private fun getElementInfo(element: PsiElement): String {
        return when (element) {
            is ValkyrieClassDeclaration -> "class ${element.getName()}"
            is ValkyrieUnionDeclaration -> "union ${element.getName()}"
            is ValkyrieTraitDeclaration -> "trait ${element.getName()}"
            is ValkyrieMethodDeclaration -> "method ${element.getName()}"
            is ValkyrieFieldDeclaration -> "field ${element.getName()}"
            else -> element.toString()
        }
    }
    
    /**
     * 简单的Markdown渲染
     */
    private fun renderMarkdown(content: String): String {
        return content
            .replace(Regex("\\*\\*(.*?)\\*\\*"), "<b>$1</b>")  // **bold**
            .replace(Regex("\\*(.*?)\\*"), "<i>$1</i>")        // *italic*
            .replace(Regex("`(.*?)`"), "<code>$1</code>")      // `code`
            .replace("\n", "<br>")
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
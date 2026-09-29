package awsl.editing.structure

import awsl.surface.psi.*
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import org.apache.commons.lang.StringEscapeUtils

class AwslFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : AwslRecursiveVisitor() {
    override fun visitHtmlText(node: awsl.surface.psi.nodes.AwslHtmlTextNode) {
        // 查找 HTML 开始标签和结束标签
        var htmlStartText: PsiElement? = null
        var htmlEnd: PsiElement? = null
        var child = node.firstChild
        
        while (child != null) {
            when (child.node.elementType) {
                AwslTypes.HTML_START_TEXT -> htmlStartText = child
                AwslTypes.HTML_END -> htmlEnd = child
            }
            child = child.nextSibling
        }
        
        if (htmlStartText != null && htmlEnd != null) {
            // 查找标签名
            var tag: PsiElement? = null
            var startChild = htmlStartText.firstChild
            while (startChild != null) {
                if (startChild.node.elementType == AwslTypes.HTML_TAG) {
                    tag = startChild
                    break
                }
                startChild = startChild.nextSibling
            }
            
            val start = tag?.textRange?.endOffset ?: htmlStartText.firstChild?.textRange?.endOffset ?: htmlStartText.textRange.endOffset
            val end = htmlEnd.firstChild?.textRange?.startOffset ?: htmlEnd.textRange.startOffset
            
            if (start < end) {
                descriptors += FoldingDescriptor(node.node, TextRange(start, end), null, "...")
            }
        }
        super.visitHtmlText(node)
    }

    override fun visitHtmlCode(node: awsl.surface.psi.nodes.AwslHtmlCodeNode) {
        // 查找 HTML 开始标签和结束标签
        var htmlStartCode: PsiElement? = null
        var htmlEnd: PsiElement? = null
        var child = node.firstChild
        
        while (child != null) {
            when (child.node.elementType) {
                AwslTypes.HTML_START_CODE -> htmlStartCode = child
                AwslTypes.HTML_END -> htmlEnd = child
            }
            child = child.nextSibling
        }
        
        if (htmlStartCode != null && htmlEnd != null) {
            // 查找标签名
            var tag: PsiElement? = null
            var startChild = htmlStartCode.firstChild
            while (startChild != null) {
                if (startChild.node.elementType == AwslTypes.HTML_TAG) {
                    tag = startChild
                    break
                }
                startChild = startChild.nextSibling
            }
            
            val start = tag?.textRange?.endOffset ?: htmlStartCode.firstChild?.textRange?.endOffset ?: htmlStartCode.textRange.endOffset
            val end = htmlEnd.firstChild?.textRange?.startOffset ?: htmlEnd.textRange.startOffset
            
            if (start < end) {
                descriptors += FoldingDescriptor(node.node, TextRange(start, end), null, "...")
            }
        }
        super.visitHtmlCode(node)
    }

    override fun visitHtmlSelfClose(node: awsl.surface.psi.nodes.AwslHtmlSelfCloseNode) {
        // 查找标签名
        var tag: PsiElement? = null
        var child = node.firstChild
        while (child != null) {
            if (child.node.elementType == AwslTypes.HTML_TAG) {
                tag = child
                break
            }
            child = child.nextSibling
        }
        
        val start = tag?.textRange?.endOffset ?: node.firstChild?.textRange?.endOffset ?: node.textRange.startOffset
        val end = node.lastChild?.textRange?.startOffset ?: node.textRange.endOffset
        
        if (start < end) {
            descriptors += FoldingDescriptor(node.node, TextRange(start, end))
        }
        super.visitHtmlSelfClose(node)
    }

    override fun visitHtmlEscape(node: awsl.surface.psi.nodes.AwslHtmlEscapeNode) {
        val char = StringEscapeUtils.unescapeHtml(node.text)
        fold(node, char, true)
        super.visitHtmlEscape(node)
    }

    override fun visitBraceBlock(node: awsl.surface.psi.nodes.AwslBraceBlockNode) {
        fold(node, "{...}")
    }

    private fun fold(element: PsiElement, text: String) {
        descriptors += FoldingDescriptor(element.node, element.textRange, null, text)
    }

    private fun fold(element: PsiElement, text: String, collapsed: Boolean) {
        descriptors += FoldingDescriptor(element.node, element.textRange, null, text, collapsed, setOf())
    }
}

package awsl.editing.format

import awsl.surface.psi.*
import com.intellij.formatting.Indent
import com.intellij.lang.ASTNode

object AwslIndentFormatter {
    fun getChildAttributes(node: ASTNode, newChildIndex: Int): Indent {
        return when (node.elementType) {
//            AwslTypes.HTML_STRING, AwslTypes.HTML_ESCAPE_TOKEN -> Indent.getNormalIndent()
            else -> Indent.getNoneIndent()
        }
    }

    fun computeIndent(node: ASTNode, child: ASTNode): Indent? {
        val isCornerChild = node.firstChildNode == child || node.lastChildNode == child
        if (isCornerChild) {
            return Indent.getNoneIndent()
        }
        return when (val e = node.psi) {
            is awsl.surface.psi.nodes.AwslHtmlTextNode -> {
                // 查找 HTML 开始标签和标签名
                var htmlStartText: com.intellij.psi.PsiElement? = null
                var childElement = e.firstChild
                while (childElement != null) {
                    if (childElement.node.elementType == AwslTypes.HTML_START_TEXT) {
                        htmlStartText = childElement
                        break
                    }
                    childElement = childElement.nextSibling
                }
                
                if (htmlStartText != null) {
                    // 查找标签名
                    var tag: com.intellij.psi.PsiElement? = null
                    var startChild = htmlStartText.firstChild
                    while (startChild != null) {
                        if (startChild.node.elementType == AwslTypes.HTML_TAG) {
                            tag = startChild
                            break
                        }
                        startChild = startChild.nextSibling
                    }
                    tag?.let { return indentByTagName(it.text) }
                }
                Indent.getNormalIndent()
            }
            is awsl.surface.psi.nodes.AwslHtmlStartTextNode -> Indent.getNormalIndent()
            is awsl.surface.psi.nodes.AwslHtmlCodeNode -> {
                // 查找 HTML 开始标签和标签名
                var htmlStartCode: com.intellij.psi.PsiElement? = null
                var childElement = e.firstChild
                while (childElement != null) {
                    if (childElement.node.elementType == AwslTypes.HTML_START_CODE) {
                        htmlStartCode = childElement
                        break
                    }
                    childElement = childElement.nextSibling
                }
                
                if (htmlStartCode != null) {
                    // 查找标签名
                    var tag: com.intellij.psi.PsiElement? = null
                    var startChild = htmlStartCode.firstChild
                    while (startChild != null) {
                        if (startChild.node.elementType == AwslTypes.HTML_TAG) {
                            tag = startChild
                            break
                        }
                        startChild = startChild.nextSibling
                    }
                    tag?.let { return indentByTagName(it.text) }
                }
                Indent.getNormalIndent()
            }
            is awsl.surface.psi.nodes.AwslHtmlStartCodeNode -> Indent.getNormalIndent()
            is awsl.surface.psi.nodes.AwslHtmlSelfCloseNode -> Indent.getNormalIndent()
            is awsl.surface.psi.nodes.AwslBraceBlockNode -> Indent.getNormalIndent()
            else -> Indent.getNoneIndent()
        }
    }

    private fun indentByTagName(tag: String) = when (tag) {
        "script" -> Indent.getNoneIndent()
        else -> Indent.getNormalIndent()
    }
}
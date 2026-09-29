package awsl.semantics.inspect

import awsl.surface.psi.AwslTypes
import awsl.surface.psi.nodes.AwslHtmlTextNode
import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost

class InjectorToAWS : MultiHostInjector {
    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        val textNode = context as? AwslHtmlTextNode ?: return
        val injection = findStyleInjection(textNode) ?: return
        val scss = Language.findLanguageByID("SCSS") ?: return
        registrar.startInjecting(scss)
        registrar.addPlace(null, null, injection.host, injection.range)
        registrar.doneInjecting()
    }

    override fun elementsToInjectIn(): MutableList<Class<out PsiElement>> =
        mutableListOf(AwslHtmlTextNode::class.java)

    private data class StyleInjection(val host: PsiLanguageInjectionHost, val range: TextRange)

    private fun findStyleInjection(textNode: AwslHtmlTextNode): StyleInjection? {
        var child = textNode.firstChild
        while (child != null) {
            if (child.node.elementType == AwslTypes.HTML_START_TEXT && hasStyleTag(child)) {
                val contentStart = findHtmlStartR(child)?.textRange?.endOffset ?: return null
                val contentEnd = findContentEnd(child) ?: return null
                if (contentStart >= contentEnd) return null
                val hostStart = textNode.textRange.startOffset
                return StyleInjection(
                    textNode,
                    TextRange(contentStart - hostStart, contentEnd - hostStart),
                )
            }
            child = child.nextSibling
        }
        return null
    }

    private fun hasStyleTag(startText: PsiElement): Boolean {
        var tagChild = startText.firstChild
        while (tagChild != null) {
            if (tagChild.node.elementType == AwslTypes.HTML_TAG) {
                var name = tagChild.firstChild
                while (name != null) {
                    if (name.node.elementType == AwslTypes.HTML_TAG_RAW && name.text == "style") return true
                    name = name.nextSibling
                }
            }
            tagChild = tagChild.nextSibling
        }
        return false
    }

    private fun findHtmlStartR(startText: PsiElement): PsiElement? {
        var node = startText.firstChild
        while (node != null) {
            if (node.node.elementType == AwslTypes.HTML_START_R) return node
            node = node.nextSibling
        }
        return null
    }

    private fun findContentEnd(startText: PsiElement): Int? {
        var sibling = startText.nextSibling
        while (sibling != null) {
            if (sibling.node.elementType == AwslTypes.HTML_STRING_TOKEN) {
                return sibling.textRange.endOffset
            }
            if (sibling.node.elementType == AwslTypes.HTML_END) {
                return sibling.textRange.startOffset
            }
            sibling = sibling.nextSibling
        }
        return null
    }
}

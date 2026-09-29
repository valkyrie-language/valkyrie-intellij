package awsl.semantics.inspect

import awsl.surface.psi.AwslTypes
import awsl.surface.psi.startOffset
import awsl.surface.psi.nodes.AwslHtmlTextNode
import com.intellij.json.JsonLanguage
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost

class InjectorToAWT : MultiHostInjector {
    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        val textNode = context as? AwslHtmlTextNode ?: return
        
        // 查找 HTML 开始标签
        var child = textNode.firstChild
        while (child != null) {
            if (child.node.elementType == AwslTypes.HTML_START_TEXT) {
                // 查找标签名
                var tagChild = child.firstChild
                while (tagChild != null) {
                    if (tagChild.node.elementType == AwslTypes.HTML_TAG) {
                        if (tagChild.text == "script") {
                            // 找到了 script 标签，注入 JSON
                            var contentChild = child.nextSibling
                            while (contentChild != null && contentChild.node.elementType != AwslTypes.HTML_END) {
                                if (contentChild.node.elementType == AwslTypes.HTML_STRING) {
                                    registrar.startInjecting(JsonLanguage.INSTANCE)
                                    val start = context.startOffset
                                    registrar.addPlace(
                                        null,
                                        null,
                                        context as PsiLanguageInjectionHost,
                                        TextRange(contentChild.textRange.startOffset - start, contentChild.textRange.endOffset - start)
                                    )
                                    registrar.doneInjecting()
                                }
                                contentChild = contentChild.nextSibling
                            }
                            return
                        }
                    }
                    tagChild = tagChild.nextSibling
                }
            }
            child = child.nextSibling
        }
    }

    override fun elementsToInjectIn(): MutableList<Class<out PsiElement>> {
        return mutableListOf(AwslHtmlTextNode::class.java)
    }
}
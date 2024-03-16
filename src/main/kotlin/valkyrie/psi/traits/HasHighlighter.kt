package valkyrie.psi.traits

import com.intellij.psi.PsiElement
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.ide.highlight.ValkyrieSemanticHighlighter

interface HasHighlighter {
    val highlightColor: ValkyrieColor
    val highlightElement: PsiElement?
    fun highlightRender(highlighter: ValkyrieSemanticHighlighter) {
        highlighter.highlight(highlightElement, highlightColor)
    }
}
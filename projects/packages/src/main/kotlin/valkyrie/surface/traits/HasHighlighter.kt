package valkyrie.surface.traits

import com.intellij.psi.PsiElement
import valkyrie.editing.highlight.ValkyrieColor
import valkyrie.editing.highlight.ValkyrieSemanticHighlighter

interface HasHighlighter {
    val highlightColor: ValkyrieColor
    val highlightElement: PsiElement?
    fun highlightRender(highlighter: ValkyrieSemanticHighlighter) {
        highlighter.highlight(highlightElement, highlightColor)
    }
}



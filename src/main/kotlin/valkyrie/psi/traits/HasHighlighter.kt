package valkyrie.psi.traits

import com.intellij.psi.PsiElement
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.ide.highlight.ValkyrieSemanticHighlighter

interface HasHighlighter {
    val highlightColor: ValkyrieColor
    val highlightElement: PsiElement?
    fun highlightRender(highlighter: ValkyrieSemanticHighlighter) {
        println("正在高亮 ${highlightElement}")
        highlighter.highlight(highlightElement, highlightColor)
    }
}



package valkyrie.language.ast.calls

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.elementType
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrLexer.BRACKET_L
import valkyrie.language.antlr.ValkyrieAntlrLexer.BRACKET_R
import valkyrie.language.antlr.childrenWithLeaves
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieAnnotation(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement {
    override fun on_highlight(e: NodeHighlighter) {
        val dye = ValkyrieLanguage.createTokenSet(BRACKET_L, BRACKET_R);
        for (child in this.childrenWithLeaves) {
            if (dye.contains(child.elementType)) {
                e.register_macro(child)
            }
        }
    }
}
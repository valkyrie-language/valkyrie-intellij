package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.psi.ValkyrieHighlightElement


class ValkyrieCallArgument(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement {
    fun getNameIdentifier(): ValkyrieIdentifierNode? {
        val a = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_identifier);
        return when {
            a != null -> {
                a as? ValkyrieIdentifierNode
            }

            else -> {
                val b = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_new_call_key);
                val c = ValkyrieParser.getChildOfType(b, ValkyrieAntlrParser.RULE_identifier);
                c as? ValkyrieIdentifierNode
            }
        }
    }

    override fun getName(): String {
        return getNameIdentifier()?.name ?: ""
    }


    override fun on_highlight(e: NodeHighlighter) {
        e.register(getNameIdentifier(), ValkyrieHighlightColor.SYM_ARG)
    }
}
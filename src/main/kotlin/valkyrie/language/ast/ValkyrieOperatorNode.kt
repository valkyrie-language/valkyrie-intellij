package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.formatter.ValkyrieRewriter
import valkyrie.language.antlr.childrenWithLeaves
import valkyrie.language.psi.ValkyrieRewritableElement


enum class ValkyrieOperatorKind {
    Prefix,
    Infix,
    Suffix,
}


class ValkyrieOperatorNode(node: CompositeElement, val kind: ValkyrieOperatorKind) : ASTWrapperPsiElement(node), ValkyrieRewritableElement {
    override fun on_rewrite(e: ValkyrieRewriter) {
        for (child in childrenWithLeaves) {
            when {
                child.text == "%" && kind == ValkyrieOperatorKind.Infix -> e.replace_infix(child, "⁒")
                child.text == "/%" -> e.replace_infix(child, "÷")
                child.text == "/@" -> e.replace_infix(child, "⇴")
                child.text == "@@" -> e.replace_infix(child, "⊕")
                child.text == "@@@" -> e.replace_infix(child, "⟴")
            }
        }
    }
}
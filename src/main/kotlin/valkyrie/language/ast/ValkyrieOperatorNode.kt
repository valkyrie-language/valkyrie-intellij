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


class ValkyrieOperatorNode(node: CompositeElement, kind: ValkyrieOperatorKind) : ASTWrapperPsiElement(node), ValkyrieRewritableElement {
    override fun on_rewrite(e: ValkyrieRewriter) {
        for (child in childrenWithLeaves) {
            when (child.text) {
                "/@" -> {
                    e.replaceNode(child, "⇴")
                }

                "@@" -> {
                    e.replaceNode(child, "⊕")
                }

                "@@@" -> {
                    e.replaceNode(child, "⟴")
                }
            }
        }
    }
}
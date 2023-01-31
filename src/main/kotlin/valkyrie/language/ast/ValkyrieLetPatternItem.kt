package valkyrie.language.ast

import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieLetPatternItem : ASTWrapperPsiElement, ValkyrieHighlightElement {


    constructor(node: CompositeElement) : super(node) {

    }

    override fun on_highlight(e: HighlightInfoHolder) {

    }
}


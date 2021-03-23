package com.github.valkyrie.ide.folding

import com.github.valkyrie.language.psi.*
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class ValkyrieFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : ValkyrieRecursiveVisitor() {
    override fun visitClassStatement(o: ValkyrieClassStatement) {
        val brace = o.classBrace;
        if (brace != null) {
            fold(brace.node, brace.firstChild.endOffset, brace.lastChild.startOffset)
            return
        }
        val tuple = o.classTuple;
        if (tuple != null) {
            fold(tuple.node, tuple.firstChild.endOffset, tuple.lastChild.startOffset)
            return
        }
    }

    override fun visitTaggedStatement(o: ValkyrieTaggedStatement) {
        val block = o.taggedBlock
        fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
        super.visitTaggedStatement(o)
    }

    override fun visitExtendsStatement(o: ValkyrieExtendsStatement) {
        val block = o.traitBlock
        fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
        // super.visitExtendsStatement(o)
    }

    override fun visitTraitStatement(o: ValkyrieTraitStatement) {
        val block = o.traitBlock
        fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
        super.visitTraitStatement(o)
    }

    override fun visitBitflagStatement(o: ValkyrieBitflagStatement) {
        val block = o.bitflagBlock
        fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
        super.visitBitflagStatement(o)
    }


    override fun visitMatchStatement(o: ValkyrieMatchStatement) {
        val block = o.matchBlock
        fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
        super.visitMatchStatement(o)
    }

    override fun visitDefStatement(o: ValkyrieDefStatement) {
        val block = o.defBlock
        if (block != null) {
            fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
        }
        super.visitDefStatement(o)
    }

    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }

    private fun fold(node: ASTNode, range: TextRange) {
        descriptors += FoldingDescriptor(node, range)
    }

    private fun fold(node: ASTNode, start: Int, end: Int) = when {
        end > start -> {
            descriptors += FoldingDescriptor(node, TextRange(start, end))
        }
        else -> {}
    }
}



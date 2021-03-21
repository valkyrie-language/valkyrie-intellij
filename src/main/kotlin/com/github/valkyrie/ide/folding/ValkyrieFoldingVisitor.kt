package com.github.valkyrie.ide.folding

import com.github.valkyrie.language.psi.*
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class ValkyrieFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : ValkyrieRecursiveVisitor() {
    override fun visitClassStatement(o: ValkyrieClassStatement) {
        when {
            o.classBrace != null -> {
                val block = o.classBrace!!
                fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
            }
            o.classTuple != null -> {
                val block = o.classTuple!!
                fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
            }
        }
        super.visitClassStatement(o)
    }

    override fun visitTaggedStatement(o: ValkyrieTaggedStatement) {
        val block = o.taggedBlock
        fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
        super.visitTaggedStatement(o)
    }

    override fun visitExtendsStatement(o: ValkyrieExtendsStatement) {
        val block = o.traitBlock
        fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
        super.visitExtendsStatement(o)
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

    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }
    private fun fold(node: ASTNode, range: TextRange) {
        descriptors += FoldingDescriptor(node, range)
    }
    private fun fold(node: ASTNode, start: Int, end: Int) {
        descriptors += FoldingDescriptor(node, TextRange(start, end))
    }
}



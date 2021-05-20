package com.github.valkyrie.ide.folding

import com.github.valkyrie.language.psi.*
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class ValkyrieFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : ValkyrieRecursiveVisitor() {
    /**
     * For class, trait, and extends
     */
    override fun visitClassBlock(o: ValkyrieClassBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }
    override fun visitTaggedStatement(o: ValkyrieTaggedStatement) {
        val block = o.taggedBlock
        fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
        super.visitTaggedStatement(o)
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
    override fun visitDefineBlock(o: ValkyrieDefineBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
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



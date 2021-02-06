package com.github.valkyrie.language.ast

import com.github.valkyrie.ide.formatter.ValkyrieFormatSpace
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.language.psi.ValkyrieModifiers

import com.intellij.formatting.Block
import com.intellij.formatting.Spacing
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType


fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun Block.computeSpacing(child1: Block?, child2: Block, ctx: ValkyrieFormatSpace): Spacing? {
    return ctx.spacingBuilder.getSpacing(this, child1, child2)
}


fun ValkyrieModifiers?.hasModifier(modifier: String): Boolean {
    if (this == null) return false
    this.symbolList.forEach {
        if (it.text == modifier) {
            return true
        }
    }
    return false
}

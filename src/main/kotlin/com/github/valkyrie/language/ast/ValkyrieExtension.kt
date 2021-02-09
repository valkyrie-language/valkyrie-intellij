package com.github.valkyrie.language.ast

import com.github.valkyrie.ide.formatter.ValkyrieFormatSpace
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.language.psi.ValkyrieModifiers
import com.github.valkyrie.language.psi.ValkyrieNormalPattern
import com.github.valkyrie.language.psi.ValkyriePatternItem
import com.github.valkyrie.language.psi.ValkyrieSymbol

import com.intellij.formatting.Block
import com.intellij.formatting.Spacing
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType


fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun Block.computeSpacing(child1: Block?, child2: Block, ctx: ValkyrieFormatSpace): Spacing? {
    return ctx.spacingBuilder.getSpacing(this, child1, child2)
}

private fun getModifier(node: PsiElement, modifier: String, skip_last: Boolean = true): Boolean {
    var cur = node.lastChild;
    if (skip_last) {
        cur = cur.prevSibling;
    }
    while (cur != null) {
        if (cur.text == modifier) return true;
        cur = cur.prevSibling;
    }
    return false
}
fun ValkyrieNormalPattern.isMutable(): Boolean {
    return getModifier(this.symbolList as PsiElement, "mutable", false)
}

//fun ValkyriePatternRest?.hasModifier(modifier: String, skip_last: Boolean = true): Boolean {
//    return getModifier(this as PsiElement, modifier, skip_last)
//}
//
//
//fun ValkyriePatternItem.isMutable(force_mut: Boolean, skip_last: Boolean = true): Boolean {
//    this.modifiers?.let {
//        return it.isMutable(force_mut, skip_last)
//    }
//    this.patternRest?.let {
//        return it.isMutable(force_mut, skip_last)
//    }
//    return false
//}
//
//fun ValkyrieModifiers?.isMutable(force_mut: Boolean, skip_last: Boolean = true): Boolean = when (force_mut) {
//    true -> true
//    false -> this?.hasModifier("mut", skip_last) ?: false
//}
//
//fun ValkyriePatternRest?.isMutable(force_mut: Boolean, skip_last: Boolean = true): Boolean = when (force_mut) {
//    true -> true
//    false -> this?.hasModifier("mut", skip_last) ?: false
//}
//

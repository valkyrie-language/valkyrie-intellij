package valkyrie.language.ast

import valkyrie.ide.formatter.FormatSpace
import valkyrie.language.psi.ValkyrieNormalPattern
import valkyrie.language.psi.ValkyrieIdentifier
import com.intellij.formatting.Block
import com.intellij.formatting.Spacing
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType


fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun Block.computeSpacing(child1: Block?, child2: Block, ctx: FormatSpace): Spacing? {
    return ctx.spacingBuilder.getSpacing(this, child1, child2)
}

fun hasModifier(node: List<ValkyrieIdentifier>, modifier: String, skip_last: Boolean = true): Boolean {
    val size = node.size - if (skip_last) {
        1
    } else {
        0
    }
    for (i in 0 until size) {
        if (node[i].text == modifier) {
            return true
        }
    }
    return false
}

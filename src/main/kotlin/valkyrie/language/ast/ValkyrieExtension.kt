package valkyrie.language.ast


import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import valkyrie.language.psi.ValkyrieIdentifier


fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
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

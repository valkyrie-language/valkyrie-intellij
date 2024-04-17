package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * 限定名实现
 */
class ValkyrieNamepathNode(node: ASTNode) : ValkyrieElementNode(node) {

    fun getIdentifiers(): List<PsiElement> {
        return findChildrenByType(ValkyrieTokenTypes.SYMBOL_XID)
    }

    fun getQualifier(): String? {
        val identifiers = getIdentifiers()
        return if (identifiers.size > 1) {
            identifiers.dropLast(1).joinToString(".") { it.text }
        } else null
    }

    fun getReferenceName(): String? {
        val identifiers = getIdentifiers()
        return identifiers.lastOrNull()?.text
    }
}
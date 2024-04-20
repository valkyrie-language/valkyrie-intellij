package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * 限定名实现
 */
class ValkyrieNamepathNode(node: ASTNode) : ValkyrieElementNode(node) {

    fun getIdentifiers(): List<PsiElement> {
        val xid = findChildrenByType<PsiElement>(ValkyrieTypes.SYMBOL_XID)
        val raw = findChildrenByType<PsiElement>(ValkyrieTypes.SYMBOL_RAW)
        return (xid + raw).sortedBy { it.textOffset }
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
package valkyrie.psi.nodes

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.ValkyrieIcons
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Let 语句实现
 */
class ValkyrieLetStatementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getIdentifier(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTypes.SYMBOL_XID) ?: findChildByType<PsiElement>(ValkyrieTypes.SYMBOL_RAW)
    }
    
    fun getExpression(): PsiElement? {
        // 找到 = 后面的表达式
        val assign = findChildByType<PsiElement>(ValkyrieTypes.ASSIGN)
        return assign?.let { assignElement ->
            PsiTreeUtil.getNextSiblingOfType(assignElement, ValkyrieElementNode::class.java)
        }
    }

    override fun getPresentation(): ItemPresentation {
        val identifier = getIdentifier()?.text ?: "<unnamed>"
        val expression = getExpression()?.text?.take(30) ?: "<no-value>"
        val locationText = if (expression.length > 30) "${expression}..." else expression
        
        return PresentationData(
            "let $identifier",
            locationText,
            ValkyrieIcons.VARIABLE,
            null
        )
    }
}


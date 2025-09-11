package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.util.IncorrectOperationException
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * 标识符表达式实现 - 支持引用解析
 */
class ValkyrieIdentifierExpressionNode(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {

    override fun getName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }

    override fun setName(name: String): PsiElement {
        throw IncorrectOperationException("Not implemented")
    }

    override fun getNameIdentifier(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)
    }

    // 引用解析由 ValkyrieReferenceContributor 统一管理
    // 移除直接返回 ValkyrieReference 避免与 ReferenceContributor 冲突
}
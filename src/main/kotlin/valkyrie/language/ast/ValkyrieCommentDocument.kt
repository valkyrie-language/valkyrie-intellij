package valkyrie.language.ast


import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.antlr.ValkyrieLexer


class ValkyrieCommentDocument(node: CompositeElement) : ASTWrapperPsiElement(node), PsiDocCommentBase {
    private val documentText: String = node.text;

    override fun getTokenType(): IElementType = ValkyrieLexer.CommentBlock
    override fun getOwner(): PsiElement? {
        return PsiTreeUtil.skipWhitespacesAndCommentsForward(this)
    }

    fun render(): String {
        return "<div>$documentText<div>"
    }
}


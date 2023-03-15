package valkyrie.language.ast


import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.antlr.ValkyrieLexer


class ValkyrieCommentDocument : ASTWrapperPsiElement, PsiDocCommentBase {
    constructor(node: CompositeElement) : super(node) {
        this.documentText = node.text
    }

    constructor(psi: PsiComment) : super(psi.node) {
        this.documentText = node.text
    }

    private val documentText: String

    override fun getTokenType(): IElementType = ValkyrieLexer.CommentBlock
    override fun getOwner(): PsiElement? {
        return PsiTreeUtil.skipWhitespacesAndCommentsForward(this)
    }


    fun render(): String {
        return "<div>$documentText<div>"
    }
}


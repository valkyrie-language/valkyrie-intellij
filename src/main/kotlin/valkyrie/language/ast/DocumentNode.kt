package valkyrie.language.ast


import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.lexer.ValkyrieProgramLexer


class DocumentNode(comment: PsiComment, rawText: String? = null) : ASTWrapperPsiElement(comment.node), PsiDocCommentBase {
    private val documentText: String

    init {
        this.documentText = rawText?.trimIndent() ?: "[PARSE_FAILED]: ${comment.text}"
    }

    override fun getTokenType(): IElementType = ValkyrieProgramLexer.CommentBlock
    override fun getOwner(): PsiElement? {
        return PsiTreeUtil.skipWhitespacesAndCommentsForward(this)
    }

    fun render(): String {
        return "<div>$documentText<div>"
    }
}
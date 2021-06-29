package valkyrie.ide.formatter

import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType
import valkyrie.language.psi.ValkyrieTypes

class Commenter : CodeDocumentationAwareCommenter {
    override fun getLineCommentPrefix() = "⍝"
    override fun getBlockCommentPrefix() = "(*"
    override fun getBlockCommentSuffix() = "*)"
    override fun getCommentedBlockCommentPrefix() = "*)(*"
    override fun getCommentedBlockCommentSuffix() = "*)(*"
    override fun getLineCommentPrefixes(): MutableList<String> {
        return super.getLineCommentPrefixes()
    }

    override fun blockCommentRequiresFullLineSelection(): Boolean {
        return false
    }

    override fun getLineCommentTokenType(): IElementType? = ValkyrieTypes.COMMENT

    override fun getBlockCommentTokenType(): IElementType? = ValkyrieTypes.COMMENT

    override fun getDocumentationCommentTokenType(): IElementType? = null

    override fun getDocumentationCommentPrefix() = "⍝:"

    override fun getDocumentationCommentLinePrefix() = "⍝:"

    override fun getDocumentationCommentSuffix() = null

    override fun isDocumentationComment(element: PsiComment?): Boolean {
        TODO("Not yet implemented")
    }
}

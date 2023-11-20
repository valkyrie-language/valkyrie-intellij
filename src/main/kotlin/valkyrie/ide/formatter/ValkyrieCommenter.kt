package valkyrie.ide.formatter

import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType
import valkyrie.cst.COMMENT_BLOCK
import valkyrie.cst.COMMENT_LINE


class ValkyrieCommenter : CodeDocumentationAwareCommenter {
    override fun getLineCommentPrefix() = "#"
    override fun getDocumentationCommentLinePrefix() = "#?"
    override fun getLineCommentPrefixes(): MutableList<String> {
        return mutableListOf("#", "⍝")
    }

    override fun getLineCommentTokenType(): IElementType {
        return COMMENT_LINE
    }

    override fun getLineCommentTokenTypes(): MutableList<IElementType> {
        return mutableListOf(COMMENT_LINE)
    }

    override fun getBlockCommentPrefix() = "<#"
    override fun getBlockCommentSuffix() = "#>"
    override fun getCommentedBlockCommentPrefix() = "<#"
    override fun getCommentedBlockCommentSuffix() = "#>"


    override fun blockCommentRequiresFullLineSelection(): Boolean {
        return false
    }


    override fun getBlockCommentTokenType(): IElementType {
        return COMMENT_BLOCK
    }

    override fun getDocumentationCommentTokenType(): IElementType? = null
    override fun getDocumentationCommentPrefix() = "<#?"
    override fun getDocumentationCommentSuffix() = "#>"

    override fun isDocumentationComment(element: PsiComment?): Boolean {
        if (element == null || element.elementType != COMMENT_BLOCK) {
            return false
        }
        return element.text.startsWith(documentationCommentLinePrefix)
    }


    fun extractDocumentText(element: PsiComment): String? {
        if (element.elementType == COMMENT_LINE && element.text.startsWith(documentationCommentLinePrefix)) {
            return element.text.substring(documentationCommentLinePrefix.length).trim()
        }
//        if (element.elementType == ValkyrieLexer.CommentBlock && element.text.startsWith(documentationCommentLinePrefix)) {
//            return element.text.substring(documentationCommentPrefix.length, element.text.length - documentationCommentSuffix.length).trim()
//        }
        return null
    }
}

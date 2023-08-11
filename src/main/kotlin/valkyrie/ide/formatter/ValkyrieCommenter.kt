package valkyrie.ide.formatter

import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType
import valkyrie.psi.ValkyrieTypes


class ValkyrieCommenter : CodeDocumentationAwareCommenter {
    override fun getLineCommentPrefix() = "#"
    override fun getDocumentationCommentLinePrefix() = "#?"
    override fun getLineCommentPrefixes(): MutableList<String> {
        return mutableListOf("#", "\\\\")
    }

    override fun getLineCommentTokenType(): IElementType {
        return ValkyrieTypes.COMMENT_LINE
    }

    override fun getLineCommentTokenTypes(): MutableList<IElementType> {
        return mutableListOf(ValkyrieTypes.COMMENT_LINE)
    }

    override fun getBlockCommentPrefix() = null
    override fun getBlockCommentSuffix() = null
    override fun getCommentedBlockCommentPrefix() = null
    override fun getCommentedBlockCommentSuffix() = null


    override fun blockCommentRequiresFullLineSelection(): Boolean {
        return false
    }


    override fun getBlockCommentTokenType(): IElementType {
        return ValkyrieTypes.COMMENT_BLOCK
    }

    override fun getDocumentationCommentTokenType(): IElementType? = null
    override fun getDocumentationCommentPrefix() = null
    override fun getDocumentationCommentSuffix() = null

    override fun isDocumentationComment(element: PsiComment?): Boolean {
        if (element == null || element.elementType != ValkyrieTypes.COMMENT_BLOCK) {
            return false
        }
        return element.text.startsWith(documentationCommentLinePrefix)
    }


    fun extractDocumentText(element: PsiComment): String? {
        if (element.elementType == ValkyrieTypes.COMMENT_LINE && element.text.startsWith(documentationCommentLinePrefix)) {
            return element.text.substring(documentationCommentLinePrefix.length).trim()
        }
//        if (element.elementType == ValkyrieLexer.CommentBlock && element.text.startsWith(documentationCommentLinePrefix)) {
//            return element.text.substring(documentationCommentPrefix.length, element.text.length - documentationCommentSuffix.length).trim()
//        }
        return null
    }
}

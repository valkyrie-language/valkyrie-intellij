package valkyrie.ide.formatter

import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType
import valkyrie.language.psi.ValkyrieTypes

object ValkyrieCommenter : CodeDocumentationAwareCommenter {
    override fun getLineCommentPrefix() = "//"
    override fun getBlockCommentPrefix() = "/*"
    override fun getBlockCommentSuffix() = "*/"
    override fun getCommentedBlockCommentPrefix() = "*//*"
    override fun getCommentedBlockCommentSuffix() = "*//*"
    override fun getLineCommentPrefixes(): MutableList<String> {
        return super.getLineCommentPrefixes()
    }

    override fun blockCommentRequiresFullLineSelection(): Boolean {
        return false
    }

    override fun getLineCommentTokenType(): IElementType? = ValkyrieTypes.COMMENT_LINE
    override fun getBlockCommentTokenType(): IElementType? = ValkyrieTypes.COMMENT_BLOCK
    override fun getDocumentationCommentTokenType(): IElementType? = null
    override fun getDocumentationCommentPrefix() = "/**"
    override fun getDocumentationCommentSuffix() = "*/"
    override fun getDocumentationCommentLinePrefix() = null
    override fun isDocumentationComment(element: PsiComment?): Boolean {
        if (element == null || element.elementType != ValkyrieTypes.COMMENT_BLOCK) {
            return false
        }
        return element.text.startsWith(documentationCommentPrefix)
    }

    fun extractDocumentText(element: PsiComment): String? {
//        if (element.elementType == ValkyrieTypes.COMMENT_LINE && element.text.startsWith(documentationCommentLinePrefix)) {
//            return element.text.substring(documentationCommentLinePrefix.length).trim()
//        }
        if (element.elementType == ValkyrieTypes.COMMENT_BLOCK && element.text.startsWith(documentationCommentPrefix)) {
            return element.text.substring(documentationCommentPrefix.length, element.text.length - documentationCommentSuffix.length).trim()
        }
        return null
    }
}

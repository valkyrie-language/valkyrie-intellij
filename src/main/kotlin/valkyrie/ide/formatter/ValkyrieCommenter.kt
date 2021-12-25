package valkyrie.ide.formatter

import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType
import valkyrie.language.lexer.ValkyrieProgramLexer

//import valkyrie.language.psi.ValkyrieTypes

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

    override fun getLineCommentTokenType(): IElementType {
        return ValkyrieProgramLexer.CommentLine
    }
    override fun getBlockCommentTokenType(): IElementType {
        return ValkyrieProgramLexer.CommentBlock
    }
    override fun getDocumentationCommentTokenType(): IElementType? = null
    override fun getDocumentationCommentPrefix() = "/**"
    override fun getDocumentationCommentSuffix() = "*/"
    override fun getDocumentationCommentLinePrefix() = "///"
    override fun isDocumentationComment(element: PsiComment?): Boolean {
        if (element == null || element.elementType != ValkyrieProgramLexer.CommentBlock) {
            return false
        }
        return element.text.startsWith(documentationCommentPrefix)
    }

    fun extractDocumentText(element: PsiComment): String? {
        if (element.elementType == ValkyrieProgramLexer.CommentLine && element.text.startsWith(documentationCommentLinePrefix)) {
            return element.text.substring(documentationCommentLinePrefix.length).trim()
        }
        if (element.elementType == ValkyrieProgramLexer.CommentBlock && element.text.startsWith(documentationCommentPrefix)) {
            return element.text.substring(documentationCommentPrefix.length, element.text.length - documentationCommentSuffix.length).trim()
        }
        return null
    }
}

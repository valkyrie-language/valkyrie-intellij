package valkyrie.ide.doc

import com.intellij.lang.documentation.DocumentationProvider
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import valkyrie.language.ast.DocumentNode
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.psi.ValkyrieTokenType
import valkyrie.language.psi.ValkyrieTypes
import java.net.ConnectException
import java.util.function.Consumer


class DocumentationProvider : DocumentationProvider {
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return try {
            element?.let { DocumentationRenderer(it, originalElement).onHover() }
        } catch (e: java.net.ConnectException) {
            null
        }
    }


    override fun findDocComment(file: PsiFile, range: TextRange): PsiDocCommentBase? {
        println("findDocComment $file $range")
        return super.findDocComment(file, range)
    }

    override fun collectDocComments(file: PsiFile, sink: Consumer<in PsiDocCommentBase>) {
        println("collectDocComments $file")
        if (file !is ValkyrieFileNode) return
        for (leaf in PsiTreeUtil.findChildrenOfType(file, PsiComment::class.java)) {
            DocumentNode.tryBuild(leaf).let {
                if (it != null) {
                    sink.accept(it)
                }
            }
        }
    }

    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        println("generateRenderedDoc $comment")
        return when (comment) {
            is DocumentNode -> comment.render()
            else -> super.generateRenderedDoc(comment)
        }
    }

    // 按住 Ctrl 后悬浮
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return originalElement?.let { this.generateHoverDoc(it, originalElement) }
    }

    // 悬浮
    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String? {
        try {
            return DocumentationRenderer(element, originalElement).onHover()
        } catch (_: ConnectException) {
            // skip
        }
        return null
    }

    override fun getCustomDocumentationElement(editor: Editor, file: PsiFile, contextElement: PsiElement?, targetOffset: Int): PsiElement? {
        return when {
            ValkyrieTokenType.isKeyword(contextElement) -> contextElement
            ValkyrieTokenType.isOperator(contextElement) -> contextElement
//            contextElement.elementType == ValkyrieTypes.OP_AT -> null
            contextElement.elementType == ValkyrieTypes.OP_AT -> null
            contextElement.elementType == ValkyrieTypes.OP_HASH -> null
            contextElement.elementType == TokenType.WHITE_SPACE -> null
            contextElement.elementType == ValkyrieTypes.COMMENT_LINE -> null
            contextElement.elementType == ValkyrieTypes.COMMENT_BLOCK -> null
            else -> null
        }
    }
}
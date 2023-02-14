package valkyrie.ide.formatter

import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.psi.util.nextLeaf
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.language.antlr.ValkyrieLexer
import valkyrie.language.antlr.childrenWithLeaves
import valkyrie.language.psi.ValkyrieFactory

@Suppress("FunctionName")
class ValkyrieRewriter {
    private var offsetDelta: Int = 0
    private val text: Document
    val settings: ValkyrieCodeStyleSettings

    constructor(text: Document, settings: ValkyrieCodeStyleSettings) : super() {
        this.text = text
        this.settings = settings
    }

//    override fun visitReturnType(o: ValkyrieReturnType) {
//        val delimiter = o.firstChild;
//        when (settings.return_type) {
//            ReturnType.Ignore -> return
//            ReturnType.Colon -> replaceNode(delimiter, ":")
//            ReturnType.Arrow -> replaceNode(delimiter, "->")
//            ReturnType.UnicodeArrow -> replaceNode(delimiter, "⟶")
//        }
//    }

    fun rewriteGeneric(o: PsiElement) {
        for (leaf in o.childrenWithLeaves) {
            when (leaf.text) {
                "<" -> unsafe_replace(leaf, "⟨")
                ">" -> unsafe_replace(leaf, "⟩")
                "::" -> delete_node(leaf)
            }
        }
    }

    fun deleteDelimiterAfter(node: PsiElement) {
        val both = TokenSet.orSet(ValkyrieLexer.Comma, ValkyrieLexer.Semicolon);
        var leaf = PsiTreeUtil.skipWhitespacesForward(node)
        while (true) {
            when {
                leaf == null -> break
                both.contains(leaf.elementType) -> {
                    delete_node(leaf)
                    leaf = PsiTreeUtil.skipWhitespacesForward(leaf)
                }

                else -> break
            }
        }
    }

    fun delete_node(node: PsiElement?) {
        node?.delete()
    }


    fun unsafe_replace(node: PsiElement?, replace: String) {
        if (node == null) return
        val delta = replace.length - node.textLength
        text.replaceString(node.startOffset + offsetDelta, node.endOffset + offsetDelta, replace)
        offsetDelta += delta
    }

    fun replace_infix(node: PsiElement, replace: String) {
        val o = ValkyrieFactory(node.project).create_infix(replace);
        o?.let { node.replace(it) }
    }

    fun insert_before(node: PsiElement, insert: String) {
        val delta = insert.length
        text.insertString(node.startOffset + offsetDelta, insert)
        offsetDelta += delta
    }

    fun insertAfter(node: PsiElement, insert: String) {
        val delta = insert.length
        text.insertString(node.endOffset + offsetDelta, insert)
        offsetDelta += delta
    }

    fun fixDelimiter(element: PsiElement, config: ValkyrieCodeStyleSettings.CommaOrSemicolon) {
        val delimiter = element.nextLeaf(true) ?: return;
        val both = TokenSet.orSet(ValkyrieLexer.Comma, ValkyrieLexer.Semicolon);

        when (config) {
            ValkyrieCodeStyleSettings.CommaOrSemicolon.Ignore -> return
            ValkyrieCodeStyleSettings.CommaOrSemicolon.Nothing -> {
                if (both.contains(delimiter.elementType)) {
                    delete_node(delimiter)
                }
            }

            ValkyrieCodeStyleSettings.CommaOrSemicolon.Comma -> when {
                ValkyrieLexer.Semicolon.contains(delimiter.elementType) -> unsafe_replace(delimiter, ",")
                !ValkyrieLexer.Comma.contains(delimiter.elementType) -> insertAfter(element, ",")
            }

            ValkyrieCodeStyleSettings.CommaOrSemicolon.Semicolon -> when {
                ValkyrieLexer.Comma.contains(delimiter.elementType) -> unsafe_replace(delimiter, ";")
                !ValkyrieLexer.Semicolon.contains(delimiter.elementType) -> insertAfter(element, ";")
            }
        }
        deleteDelimiterAfter(delimiter)
    }
}
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

    private fun delete_delimiter_after(node: PsiElement) {
        val both = TokenSet.orSet(ValkyrieLexer.Comma, ValkyrieLexer.Semicolon);
        var leaf = PsiTreeUtil.skipWhitespacesForward(node)
        while (true) {
            when {
                leaf == null -> break
                both.contains(leaf.elementType) -> {
                    leaf.delete()
                    leaf = PsiTreeUtil.skipWhitespacesForward(leaf)
                }

                else -> break
            }
        }
    }

    fun delete_node(node: PsiElement?) {
        node?.delete()
    }

    fun replace_dot(node: PsiElement?) {
        if (node == null) return
        ValkyrieFactory(node.project).replace_dot(node)
    }

    fun replace_comma(node: PsiElement?) {
        if (node == null) return
        ValkyrieFactory(node.project).replace_comma(node)
    }

    fun replace_colon(node: PsiElement?, semi: Boolean) {
        if (node == null) return
        if (semi) {
            ValkyrieFactory(node.project).replace_semicolon(node)
        } else {
            ValkyrieFactory(node.project).replace_colon(node)
        }

    }

    fun replace_proportion(node: PsiElement?, unicode: Boolean) {
        if (node == null) return
        ValkyrieFactory(node.project).replace_proportion(node, unicode)
    }

    fun replace_arrow(node: PsiElement?, unicode: Boolean) {
        if (node == null) return
        ValkyrieFactory(node.project).replace_arrow(node, unicode)
    }

    fun replace_infix(node: PsiElement, replace: String) {
        val o = ValkyrieFactory(node.project).create_infix(replace);
        o?.let { node.replace(it) }
    }

    fun replace_generic(root: PsiElement) {
        val o = ValkyrieFactory(root.project);
        var lhs: PsiElement? = null;
        var rhs: PsiElement? = null;

        for (leaf in root.childrenWithLeaves) {
            when (leaf.text) {
                "::" -> delete_node(leaf)
                "<" -> lhs = leaf;
                ">" -> {
                    rhs = leaf
                    break
                }
            }
        }
        if (lhs != null && rhs != null) {
            o.replace_generic(lhs, rhs)
        }
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
                ValkyrieLexer.Semicolon.contains(delimiter.elementType) -> replace_comma(delimiter)
                !ValkyrieLexer.Comma.contains(delimiter.elementType) -> insertAfter(element, ",")
            }

            ValkyrieCodeStyleSettings.CommaOrSemicolon.Semicolon -> when {
                ValkyrieLexer.Comma.contains(delimiter.elementType) -> replace_colon(delimiter, true)
                !ValkyrieLexer.Semicolon.contains(delimiter.elementType) -> insertAfter(element, ";")
            }
        }
        delete_delimiter_after(delimiter)
    }
}


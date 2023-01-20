package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyle
import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.psi.util.nextLeaf
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import com.intellij.util.DocumentUtil
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings.*
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieLexer
import valkyrie.language.antlr.childrenWithLeaves
import valkyrie.language.ast.ValkyrieClassStatement
import valkyrie.language.ast.ValkyrieNamespaceStatement
import valkyrie.language.ast.calls.ValkyrieCallGeneric
import valkyrie.language.psi.ValkyrieVisitor

//import valkyrie.language.psi_node.ValkyrieClassStatementNode


class ValkyrieBeforeFormat : PreFormatProcessor {
    override fun process(element: ASTNode, range: TextRange): TextRange {
        val psiRoot = element.psi
        if (psiRoot.language !is ValkyrieLanguage) {
            return range
        }
        val settings = CodeStyle.getCustomSettings(
            psiRoot.containingFile, ValkyrieCodeStyleSettings::class.java
        )
        val psiDocumentManager = PsiDocumentManager.getInstance(psiRoot.project)
        val document = psiDocumentManager.getDocument(psiRoot.containingFile) ?: return range
        DocumentUtil.executeInBulk(document) {
            psiDocumentManager.doPostponedOperationsAndUnblockDocument(document)
            psiRoot.accept(RewriteVisitor(document, settings))
            psiDocumentManager.commitDocument(document)
        }
        return range
    }
}

private class RewriteVisitor(private val text: Document, val settings: ValkyrieCodeStyleSettings) : ValkyrieVisitor() {
    var offsetDelta: Int = 0

    override fun visitNamespace(o: ValkyrieNamespaceStatement) {
        val split = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieAntlrParser.DOT, ValkyrieAntlrParser.OP_PROPORTION);
        for (leaf in o.namepath.childrenWithLeaves) {
            if (split.contains(leaf.elementType)) {
                when (settings.namespace_delimiter) {
                    NamespaceDelimiter.Ignore -> break
                    NamespaceDelimiter.Dot -> replaceNode(leaf, ".")
                    NamespaceDelimiter.Colon -> replaceNode(leaf, "::")
                    NamespaceDelimiter.UnicodeColon -> replaceNode(leaf, "∷")
                }
            }
        }

        val last = o.lastChild;
        when (settings.namespace_colon) {
            Triplet.Ignore -> {}
            Triplet.Always -> if (last !is ANTLRPsiNode) {
                insertAfter(o, ";")
            }

            Triplet.Nothing -> if (last is ANTLRPsiNode) {
                deleteNode(last)
            }
        }
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

    override fun visitClassDeclaration(o: ValkyrieClassStatement) {
        for (field in o.getFields()) {
            fixDelimiter(field, settings.class_field_trailing)
        }
    }

    override fun visitGenericCall(o: ValkyrieCallGeneric) {
        for (leaf in o.childrenWithLeaves) {
            when (leaf.node.text) {
                "<" -> {
                    replaceNode(leaf, "⟨")
                }

                ">" -> {
                    replaceNode(leaf, "⟩")
                }

                "::" -> {
                    deleteNode(leaf)
                }
            }
        }
    }

//    override fun visitUnionItem(o: ValkyrieUnionItem) {
//        o as ValkyrieUnionItemNode;
//        fixDelimiter(o, settings.union_trailing)
//        for (field in o.union_fields) {
//            fixDelimiter(field, settings.union_item_field_trailing)
//        }
//    }

    fun deleteDelimiterAfter(node: PsiElement) {
        val both = TokenSet.orSet(ValkyrieLexer.Comma, ValkyrieLexer.Semicolon);
        var leaf = PsiTreeUtil.skipWhitespacesForward(node)
        while (true) {
            when {
                leaf == null -> break
                both.contains(leaf.elementType) -> {
                    deleteNode(leaf)
                    leaf = PsiTreeUtil.skipWhitespacesForward(leaf)
                }

                else -> break
            }
        }
    }

    fun deleteNode(node: PsiElement?) {
        if (node == null) return
        val delta = node.textLength
        text.deleteString(node.startOffset + offsetDelta, node.endOffset + offsetDelta)
        offsetDelta -= delta
    }

    fun replaceNode(node: PsiElement?, replace: String) {
        if (node == null) return
        val delta = replace.length - node.textLength
        text.replaceString(node.startOffset + offsetDelta, node.endOffset + offsetDelta, replace)
        offsetDelta += delta
    }

    fun insertBefore(node: PsiElement, insert: String) {
        val delta = insert.length
        text.insertString(node.startOffset + offsetDelta, insert)
        offsetDelta += delta
    }

    fun insertAfter(node: PsiElement, insert: String) {
        val delta = insert.length
        text.insertString(node.endOffset + offsetDelta, insert)
        offsetDelta += delta
    }
}

private fun RewriteVisitor.fixDelimiter(element: PsiElement, config: CommaOrSemicolon) {
    val delimiter = element.nextLeaf(true) ?: return;
    val both = TokenSet.orSet(ValkyrieLexer.Comma, ValkyrieLexer.Semicolon);

    when (config) {
        CommaOrSemicolon.Ignore -> return
        CommaOrSemicolon.Nothing -> {
            if (both.contains(delimiter.elementType)) {
                deleteNode(delimiter)
            }
        }

        CommaOrSemicolon.Comma -> when {
            ValkyrieLexer.Semicolon.contains(delimiter.elementType) -> replaceNode(delimiter, ",")
            !ValkyrieLexer.Comma.contains(delimiter.elementType) -> insertAfter(element, ",")
        }

        CommaOrSemicolon.Semicolon -> when {
            ValkyrieLexer.Comma.contains(delimiter.elementType) -> replaceNode(delimiter, ";")
            !ValkyrieLexer.Semicolon.contains(delimiter.elementType) -> insertAfter(element, ";")
        }
    }
    deleteDelimiterAfter(delimiter)
}



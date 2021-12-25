package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyle
import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.nextLeaf
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import com.intellij.util.DocumentUtil
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings.CommaOrSemicolon
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.psi.ValkyrieRecursiveVisitor

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

private class RewriteVisitor(private val text: Document, val settings: ValkyrieCodeStyleSettings) : ValkyrieRecursiveVisitor() {
    var offsetDelta: Int = 0

//    override fun visitNamespaceStatement(o: ValkyrieNamespaceStatement) {
//        for (leaf in o.namepathFree.childrenWithLeaves) {
//            if (leaf.elementType == ValkyrieTypes.DOT || leaf.elementType == ValkyrieTypes.OP_PROPORTION) {
//                when (settings.namespace_delimiter) {
//                    NamespaceDelimiter.Ignore -> break
//                    NamespaceDelimiter.Dot -> replaceNode(leaf, ".")
//                    NamespaceDelimiter.Colon -> replaceNode(leaf, "::")
//                    NamespaceDelimiter.UnicodeColon -> replaceNode(leaf, "∷")
//                }
//            }
//        }
//        val next = PsiTreeUtil.skipWhitespacesForward(o);
//        when (settings.namespace_colon) {
//            Triplet.Ignore -> {}
//            Triplet.Always -> if (next.elementType != ValkyrieTypes.SEMICOLON) {
//                insertAfter(o, ";")
//            }
//
//            Triplet.Nothing -> if (next.elementType == ValkyrieTypes.SEMICOLON) {
//                deleteNode(next)
//            }
//        }
//    }

//    override fun visitReturnType(o: ValkyrieReturnType) {
//        val delimiter = o.firstChild;
//        when (settings.return_type) {
//            ReturnType.Ignore -> return
//            ReturnType.Colon -> replaceNode(delimiter, ":")
//            ReturnType.Arrow -> replaceNode(delimiter, "->")
//            ReturnType.UnicodeArrow -> replaceNode(delimiter, "⟶")
//        }
//    }

//    override fun visitClassStatement(o: ValkyrieClassStatement) {
//        o as ValkyrieClassDeclaration;
//        for (field in o.class_fields) {
//            fixDelimiter(field, settings.class_field_trailing)
//        }
//    }

//    override fun visitUnionItem(o: ValkyrieUnionItem) {
//        o as ValkyrieUnionItemNode;
//        fixDelimiter(o, settings.union_trailing)
//        for (field in o.union_fields) {
//            fixDelimiter(field, settings.union_item_field_trailing)
//        }
//    }

    fun deleteDelimiterAfter(node: PsiElement) {
        var leaf = PsiTreeUtil.skipWhitespacesForward(node)
        while (true) {
            when {
                leaf == null -> break
//                leaf.elementType == ValkyrieTypes.SEMICOLON || leaf.elementType == ValkyrieTypes.COMMA -> {
//                    deleteNode(leaf)
//                    leaf = PsiTreeUtil.skipWhitespacesForward(leaf)
//                }

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
    when (config) {
        CommaOrSemicolon.Ignore -> return
        CommaOrSemicolon.Nothing -> {
//            if (delimiter.elementType == ValkyrieTypes.SEMICOLON || delimiter.elementType == ValkyrieTypes.COMMA) {
//                deleteNode(delimiter)
//            }
        }

        CommaOrSemicolon.Comma -> when {
//            delimiter.elementType == ValkyrieTypes.SEMICOLON -> replaceNode(delimiter, ",")
//            delimiter.elementType != ValkyrieTypes.COMMA -> insertAfter(element, ",")
        }

        CommaOrSemicolon.Semicolon -> when {
//            delimiter.elementType == ValkyrieTypes.COMMA -> replaceNode(delimiter, ";")
//            delimiter.elementType != ValkyrieTypes.SEMICOLON -> insertAfter(element, ";")
        }
    }
    deleteDelimiterAfter(delimiter)
}



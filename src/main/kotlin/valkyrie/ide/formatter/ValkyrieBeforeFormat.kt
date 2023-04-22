package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyle
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.ide.folding.ValkyrieRecursiveVisitor
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.childrenWithLeaves
import valkyrie.psi.node.ValkyrieDeclareGeneric
import valkyrie.psi.node.ValkyrieGenericCall
import valkyrie.psi.node.ValkyrieGenericCallFree
import valkyrie.psi.node.ValkyrieNamepath
import valkyrie.psi.replaceLeaf


class ValkyrieBeforeFormat : PreFormatProcessor {
    override fun process(element: ASTNode, range: TextRange): TextRange {
        val root = element.psi as ValkyrieFileNode
        val settings = CodeStyle.getCustomSettings(
            root.containingFile, ValkyrieCodeStyleSettings::class.java
        )
        val visitor = BeforeFormatFixer(settings)
        PsiTreeUtil.processElements(root) { it.accept(visitor); true }

//        val psiDocumentManager = PsiDocumentManager.getInstance(psiRoot.project)
//        val document = psiDocumentManager.getDocument(psiRoot.containingFile) ?: return range
//        val writer = ValkyrieRewriter(document, settings);
//        psiRoot.traversal {
//            if (it is ValkyrieRewritableElement) {
//                it.on_rewrite(writer)
//            }
//            true
//        }

//        DocumentUtil.executeInBulk(document) {
//            psiDocumentManager.doPostponedOperationsAndUnblockDocument(document)
//            val writer = ValkyrieRewriter(document, settings);
//            psiRoot.traversal {
//                if (it is ValkyrieRewritableElement) {
//                    it.on_rewrite(writer)
//                }
//                true
//            }
//
//            psiDocumentManager.commitDocument(document)
//        }
        return range
    }

    override fun changesWhitespacesOnly(): Boolean {
        return super.changesWhitespacesOnly()
    }
}


private class BeforeFormatFixer(settings: ValkyrieCodeStyleSettings) : ValkyrieRecursiveVisitor() {
    override fun visitNamepath(o: ValkyrieNamepath) {
        for (child in o.childrenWithLeaves) {
            if (child.elementType == ValkyrieTypes.PROPORTION) {
                if (child.text == "::") {
                    child.replaceLeaf(ValkyrieTypes.PROPORTION, "∷")
                }
            }
        }
    }

    override fun visitDeclareGeneric(o: ValkyrieDeclareGeneric) {
        for (child in o.childrenWithLeaves) {
            when (child.elementType) {
                ValkyrieTypes.PROPORTION -> child.delete()
                ValkyrieTypes.ANGLE_L -> child.replaceLeaf(ValkyrieTypes.GENERIC_L, "⟨")
                ValkyrieTypes.ANGLE_R -> child.replaceLeaf(ValkyrieTypes.GENERIC_R, "⟩")
            }
        }
    }


    override fun visitGenericCallFree(o: ValkyrieGenericCallFree) {
        super.visitGenericCallFree(o)
    }

    override fun visitGenericCall(o: ValkyrieGenericCall) {
        super.visitGenericCall(o)
    }

}

private class ValkyrieRewriter {


//    override fun visitReturnType(o: ValkyrieReturnType) {
//        val delimiter = o.firstChild;
//        when (settings.return_type) {
//            ReturnType.Ignore -> return
//            ReturnType.Colon -> replaceNode(delimiter, ":")
//            ReturnType.Arrow -> replaceNode(delimiter, "->")
//            ReturnType.UnicodeArrow -> replaceNode(delimiter, "⟶")
//        }
//    }

//    private fun delete_delimiter_after(node: PsiElement) {
//        val both = TokenSet.orSet(ValkyrieLexer.Comma, ValkyrieLexer.Semicolon);
//        var leaf = PsiTreeUtil.skipWhitespacesForward(node)
//        while (true) {
//            when {
//                leaf == null -> break
//                both.contains(leaf.elementType) -> {
//                    leaf.delete()
//                    leaf = PsiTreeUtil.skipWhitespacesForward(leaf)
//                }
//
//                else -> break
//            }
//        }
//    }
//
//    fun delete_node(node: PsiElement?) {
//        node?.delete()
//    }
//
//    fun replace_dot(node: PsiElement?) {
//        if (node == null) return
//        ValkyrieFactory(node.project).replace_dot(node)
//    }
//
//    private fun replace_comma(node: PsiElement?) {
//        if (node == null) return
//        ValkyrieFactory(node.project).replace_comma(node)
//    }
//
//    private fun replace_colon(node: PsiElement?, semi: Boolean) {
//        if (node == null) return
//        if (semi) {
//            ValkyrieFactory(node.project).replace_semicolon(node)
//        } else {
//            ValkyrieFactory(node.project).replace_colon(node)
//        }
//
//    }
//
//    fun replace_proportion(node: PsiElement?, unicode: Boolean) {
//        if (node == null) return
//        ValkyrieFactory(node.project).replace_proportion(node, unicode)
//    }
//
//    fun replace_arrow(node: PsiElement?, unicode: Boolean) {
//        if (node == null) return
//        ValkyrieFactory(node.project).replace_arrow(node, unicode)
//    }
//
//    fun replace_infix(node: PsiElement, replace: String) {
//        val o = ValkyrieFactory(node.project).create_infix(replace);
//        o?.let { node.replace(it) }
//    }
//
//    fun replace_generic(root: PsiElement) {
//        val o = ValkyrieFactory(root.project);
//        var sep: PsiElement? = null;
//        var lhs: PsiElement? = null;
//        var rhs: PsiElement? = null;
//
//        for (leaf in root.childrenWithLeaves) {
//            when (leaf.text) {
//                "::" -> sep = leaf;
//                "<" -> lhs = leaf;
//                ">" -> {
//                    rhs = leaf
//                    break
//                }
//            }
//        }
//        if (lhs != null && rhs != null) {
//            sep?.delete()
//            o.replace_generic(lhs, rhs)
//        }
//    }

//    fun insert_before(node: PsiElement, insert: String) {
//        val delta = insert.length
//        text.insertString(node.startOffset + offsetDelta, insert)
//        offsetDelta += delta
//    }
//
//    fun insertAfter(node: PsiElement, insert: String) {
//        val delta = insert.length
//        text.insertString(node.endOffset + offsetDelta, insert)
//        offsetDelta += delta
//    }

//    fun fixDelimiter(element: PsiElement, config: ValkyrieCodeStyleSettings.CommaOrSemicolon) {
//        val delimiter = element.nextLeaf(true) ?: return;
//        val both = TokenSet.orSet(ValkyrieLexer.Comma, ValkyrieLexer.Semicolon);
//
//        when (config) {
//            ValkyrieCodeStyleSettings.CommaOrSemicolon.Ignore -> return
//            ValkyrieCodeStyleSettings.CommaOrSemicolon.Nothing -> {
//                if (both.contains(delimiter.elementType)) {
//                    delete_node(delimiter)
//                }
//            }
//
//            ValkyrieCodeStyleSettings.CommaOrSemicolon.Comma -> when {
//                ValkyrieLexer.Semicolon.contains(delimiter.elementType) -> replace_comma(delimiter)
//                !ValkyrieLexer.Comma.contains(delimiter.elementType) -> insertAfter(element, ",")
//            }
//
//            ValkyrieCodeStyleSettings.CommaOrSemicolon.Semicolon -> when {
//                ValkyrieLexer.Comma.contains(delimiter.elementType) -> replace_colon(delimiter, true)
//                !ValkyrieLexer.Semicolon.contains(delimiter.elementType) -> insertAfter(element, ";")
//            }
//        }
//        delete_delimiter_after(delimiter)
//    }
}


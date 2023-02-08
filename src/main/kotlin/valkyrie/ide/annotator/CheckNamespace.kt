package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.psi.util.parents
import valkyrie.ide.actions.ast_transform.CreateNamespace
import valkyrie.ide.actions.ast_transform.DeleteThis
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ast.ValkyrieNamespaceStatement
import valkyrie.language.file.ValkyrieFileNode

class CheckNamespace : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is ValkyrieFileNode -> annotateFile(element, holder)
            is ValkyrieNamespaceStatement -> annotateNamespace(element, holder)
        }
    }

    private fun annotateFile(element: ValkyrieFileNode, holder: AnnotationHolder) {
        val child = PsiTreeUtil.getChildrenOfTypeAsList(element, ValkyrieNamespaceStatement::class.java);
        if (child.isEmpty()) {
            val fixer = CreateNamespace(element)
            holder.newAnnotation(HighlightSeverity.WEAK_WARNING, fixer.getDescription())
                .range(TextRange.EMPTY_RANGE)
                .withFix(fixer)
                .create()
        }
        if (child.count() > 1) {
            for (item in child) {
                val fixer = DeleteThis(item, item.endSemicolon())
                holder.newAnnotation(HighlightSeverity.ERROR, ValkyrieBundle.message("annotator.namespace.duplicated"))
                    .range(item.textRange)
                    .withFix(fixer)
                    .create()
            }
        }
    }

    private fun annotateNamespace(element: ValkyrieNamespaceStatement, holder: AnnotationHolder) {
        for (parent in element.parents(false)) {
            if (parent is ValkyrieFileNode) {
                break;
            } else {
//                holder.newAnnotation(HighlightSeverity.ERROR, ValkyrieBundle.message("annotator.namespace.non-top"))
//                    .range(element.textRange)
//                .withFix(fixer)
//                    .create()
//                break;
            }
        }

        if (PsiTreeUtil.skipWhitespacesAndCommentsBackward(element) != null) {
            holder.newAnnotation(HighlightSeverity.WARNING, ValkyrieBundle.message("annotator.namespace.non-first"))
                .range(element.textRange)
                .create()
        }
    }
}

private fun PsiElement?.endSemicolon(): PsiElement? {
    val next = PsiTreeUtil.skipWhitespacesAndCommentsForward(this)
    return when (next.elementType) {
//        ValkyrieTypes.SEMICOLON -> next
        else -> null
    }
}

private fun PsiElement?.endComma(): PsiElement? {
    val next = PsiTreeUtil.skipWhitespacesAndCommentsForward(this)
    return when (next.elementType) {
//        ValkyrieTypes.COMMA -> next
        else -> null
    }
}
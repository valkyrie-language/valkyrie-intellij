package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.ide.line_marker.ValkyrieMarkColor
import valkyrie.language.ValkyrieBundle
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.childrenWithLeaves
import valkyrie.psi.node.*

/** Static, literal level lightweight analysis */
class AnnotateLiterals : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        element.accept(LintLiteral(holder))
    }
}

private class LintLiteral(holder: AnnotationHolder) : ValkyrieAnnotator(holder) {
    override fun visitTypeAlias(o: ValkyrieTypeAlias) {
        fixKeywordType(o.childrenWithLeaves)
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        fixKeywordFunction(o.childrenWithLeaves)
    }

    //        holder.newAnnotation(HighlightSeverity.INFORMATION, "Base 10 Integer")
//            .range(number.textRange)
//            .withFix(ConvertNumberBase(16))
//            .withFix(ConvertNumberBase(8))
//            .withFix(ConvertNumberBase(2))
//            .create()

    override fun visitNumberLiteral(o: ValkyrieNumberLiteral) {
        super.visitNumberLiteral(o)
    }

    override fun visitSpecial(o: ValkyrieSpecial) {
        val leaf = o.firstChild
        if (leaf.elementType == ValkyrieTypes.COLOR) {
            if (ValkyrieMarkColor().getColorFrom(leaf) == null) {
                val info = when {
                    leaf.text.startsWith('®') -> ValkyrieBundle.message("annotator.color.rgb")
                    leaf.text.startsWith('©') -> ValkyrieBundle.message("annotator.color.cmyk")
                    else -> ""
                }
                holder.newAnnotation(HighlightSeverity.ERROR, info)
                    .range(leaf.textRange)
                    .create()
            }
        }
    }

    override fun visitTypePattern(o: ValkyrieTypePattern) {
//        for (parent in o.parents(false)) {
//            when (parent) {
//                is ValkyrieIsStatement -> {
//                    return
//                }
//
//                is ValkyrieIsExpression -> {
//                    return
//                }
//            }
//        }
//        if (o.genericCallFree != null || o.namepath.identifierList.count() != 1) {
//            holder.newAnnotation(HighlightSeverity.ERROR, ValkyrieBundle.message("lint.invalid.invalid-type-pattern"))
//                .range(o.textRange)
//                .create()
//        }
    }


    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        super.visitDeclareClass(o)
    }

    // element.text can't start with lowercase
    private fun checkValidClassName(element: ValkyrieDeclareClassNode, holder: AnnotationHolder) {
//        val id = element.nameIdentifier ?: return;
//        checkNeedEscape(id, holder)
//        checkCamelCase(id, holder)
    }

    private fun checkValidUnionName(element: ValkyrieDeclareUnionNode, holder: AnnotationHolder) {
        checkNeedEscape(element.nameIdentifier, holder)
        checkCamelCase(element.nameIdentifier, holder)
    }

    private fun checkCamelCase(element: ValkyrieIdentifierNode?, holder: AnnotationHolder) {
        element ?: return
        val name = element.name;
//        val fixer = CamelCaseFixer();
//        if (name[0].isLowerCase()) {
//            holder.newAnnotation(HighlightSeverity.WEAK_WARNING, "Name must start with uppercase")
//                .range(element.textRange)
//                .create()
    }


    private fun annotateUnit(number: PsiElement, unit: String, holder: AnnotationHolder, range: TextRange) {
        holder.newAnnotation(HighlightSeverity.WARNING, "Out of range")
            .range(range)
            .create()
    }

    private fun validEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(TextRange.from(offset, length))
            .textAttributes(DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE)
            .create()
    }

    private fun uselessEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder.newSilentAnnotation(HighlightSeverity.WEAK_WARNING)
            .range(TextRange.from(offset, length))
            .textAttributes(DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE)
            .create()
    }

    private fun invalidEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder
            .newSilentAnnotation(HighlightSeverity.ERROR)
            .range(TextRange.from(offset, length))
            .textAttributes(DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE)
            .create()
    }


    private fun fixKeywordType(children: Sequence<PsiElement>) {
        for (kw in children) {
            if (kw.elementType == ValkyrieTypes.KW_TYPE) {
                if (kw.text == "type") {
                    kw.replace(ValkyrieTypes.KW_TYPE, "typus", "`${kw.text}` is deprecated, use `typus` instead").create()
                }
                break
            }
        }
    }

    private fun fixKeywordFunction(children: Sequence<PsiElement>) {
        for (kw in children) {
            if (kw.elementType == ValkyrieTypes.KW_TYPE) {
                if (kw.text == "function") {
                    kw.replace(ValkyrieTypes.KW_FUNCTION, "micro", "`${kw.text}` is deprecated, use `micro` instead").create()
                }
                break
            }
        }
    }
}

private fun checkNeedEscape(element: ValkyrieIdentifierNode?, holder: AnnotationHolder) {
    element ?: return
    val rawName = element.text;
    if (!rawName.startsWith('`')) return
//     if raw name contains non xid_continue, then need escape
//        if (rawName.substring(1, rawName.length - 1).any { !it.isJavaIdentifierPart() }) {
//            holder.newAnnotation(HighlightSeverity.INFORMATION, "Need escape")
//                .range(element.textRange)
//                .create()
//        }
}


package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.ide.actions.ast_transform.DeleteThis
import valkyrie.ide.actions.ast_transform.ReplaceGenericBrackets
import valkyrie.ide.actions.ast_transform.ReplaceLeafText
import valkyrie.ide.highlight.HighlightColor
import valkyrie.ide.line_marker.ValkyrieMarkColor
import valkyrie.language.ValkyrieBundle
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.node.*

class LiteralChecker : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element.elementType) {
            ValkyrieTypes.PROPORTION -> checkOperationNameJoin(element, holder)
            ValkyrieTypes.COLOR -> checkColor(element, holder)
            ValkyrieTypes.KW_TYPE -> checkKeywordType(element, holder)
            ValkyrieTypes.KW_FUNCTION -> checkKeywordMicro(element, holder)
            ValkyrieTypes.ANGLE_L -> checkOperationGenericL(element, holder)
            ValkyrieTypes.ANGLE_R -> checkOperationGenericR(element, holder)
        }
    }

    private fun checkColor(color: PsiElement, holder: AnnotationHolder) {
        if (ValkyrieMarkColor().getColorFrom(color) == null) {
            val info = when {
                color.text.startsWith('®') -> ValkyrieBundle.message("annotator.color.rgb")
                color.text.startsWith('©') -> ValkyrieBundle.message("annotator.color.cmyk")
                else -> ""
            }
            holder.newAnnotation(HighlightSeverity.ERROR, info)
                .range(color.textRange)
                .withFix(DeleteThis(color))
                .create()
        }
    }

    private fun checkKeywordType(kw: PsiElement, holder: AnnotationHolder) {
        if (kw.text == "type") {
            holder.newAnnotation(HighlightSeverity.WARNING, "`${kw.text}` is deprecated, use `typus` instead")
                .range(kw.textRange)
                .withFix(ReplaceLeafText(kw, ValkyrieTypes.KW_TYPE, "typus"))
                .create()
        }
    }

    private fun checkKeywordMicro(kw: PsiElement, holder: AnnotationHolder) {
        if (kw.text == "function") {
            holder.newAnnotation(HighlightSeverity.WARNING, "`${kw.text}` is deprecated, use `micro` instead")
                .range(kw.textRange)
                .withFix(ReplaceLeafText(kw, ValkyrieTypes.KW_FUNCTION, "micro"))
                .create()
        }
    }

    private fun checkOperationNameJoin(op: PsiElement, holder: AnnotationHolder) {
        when {
            op.parent is ValkyrieDeclareGenericNode -> {
                holder.newAnnotation(HighlightSeverity.WEAK_WARNING, "`${op.text}` in `declare generic` is useless")
                    .range(op.textRange)
                    .withFix(DeleteThis(op))
                    .textAttributes(HighlightColor.COMMENT_LINE.textAttributesKey)
                    .create()
            }

            op.parent is ValkyrieGenericCallFreeNode -> {
                holder.newAnnotation(HighlightSeverity.WEAK_WARNING, "`${op.text}` in `call generic` is useless")
                    .range(op.textRange)
                    .withFix(DeleteThis(op))
                    .textAttributes(HighlightColor.COMMENT_LINE.textAttributesKey)
                    .create()
            }

            op.parent is ValkyrieNamepathFreeNode || op.parent is ValkyrieUsingBlockNode -> {
                holder.newAnnotation(HighlightSeverity.WEAK_WARNING, "`${op.text}` is deprecated, use `.` instead")
                    .range(op.textRange)
                    .withFix(ReplaceLeafText(op, ValkyrieTypes.DOT, "."))
                    .create()
            }

            op.text == "::" -> {
                holder.newAnnotation(HighlightSeverity.INFORMATION, "`${op.text}` is deprecated, use `∷` instead")
                    .range(op.textRange)
                    .withFix(ReplaceLeafText(op, ValkyrieTypes.PROPORTION, "∷"))
                    .create()
            }
        }
    }

    private fun checkOperationGenericL(op: PsiElement, holder: AnnotationHolder) {
        if (op.parent is ValkyrieGenericCallAsciiBodyNode) {
            holder.newAnnotation(HighlightSeverity.INFORMATION, "`${op.text}` in `declare generic` is useless")
                .range(op.textRange)
                .withFix(ReplaceGenericBrackets(op, op.parent.lastChild))
                .create()
        }
    }

    private fun checkOperationGenericR(op: PsiElement, holder: AnnotationHolder) {
        if (op.parent is ValkyrieGenericCallAsciiBodyNode) {
            holder.newAnnotation(HighlightSeverity.INFORMATION, "`${op.text}` in `declare generic` is useless")
                .range(op.textRange)
                .withFix(ReplaceGenericBrackets(op.parent.firstChild, op))
                .create()
        }
    }

    private fun annotateSimple(number: PsiElement, holder: AnnotationHolder) {
//        holder.newAnnotation(HighlightSeverity.INFORMATION, "Base 10 Integer")
//            .range(number.textRange)
//            .withFix(ConvertNumberBase(16))
//            .withFix(ConvertNumberBase(8))
//            .withFix(ConvertNumberBase(2))
//            .create()
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
}


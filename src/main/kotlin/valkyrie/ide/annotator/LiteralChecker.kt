package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement


//import valkyrie.language.psi.ValkyrieTypes
//import valkyrie.language.psi_node.ValkyrieNumberNode

class LiteralChecker : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
//        if (element.elementType == ValkyrieTypes.COLOUR) {
//            annotateLiteralColor(element, holder)
//            return
//        }
//        if (element !is ValkyrieNumberNode) return
        val unit = ""
        annotateSimple(element.firstChild, holder)
    }

    private fun annotateLiteralColor(color: PsiElement, holder: AnnotationHolder) {
//        if (ValkyrieColorParser().getColorFrom(color) == null) {
//            val info = when {
//                color.text.startsWith('®') -> ValkyrieBundle.message("annotator.color.rgb")
//                color.text.startsWith('©') -> ValkyrieBundle.message("annotator.color.cmyk")
//                else -> ""
//            }
//            holder.newAnnotation(HighlightSeverity.ERROR, info)
//                .range(color.textRange)
//                .withFix(DeleteThis(color))
//                .create()
//        }
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


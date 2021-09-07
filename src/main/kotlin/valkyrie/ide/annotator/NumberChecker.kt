// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.ide.actions.ConvertNumberBase
import valkyrie.language.psi_node.ValkyrieNumberNode

class NumberChecker : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is ValkyrieNumberNode) return
        val unit = when (val id = element.identifier) {
            null -> ""
            else -> id.text
        }
        if (unit.isEmpty()) {
            annotateSimple(element.firstChild, holder)
        } else {
            annotateUnit(element.firstChild, unit, holder, element.textRange)
        }
    }

    private fun annotateSimple(number: PsiElement, holder: AnnotationHolder) {
        holder.newAnnotation(HighlightSeverity.INFORMATION, "Simple number")
            .range(number.textRange)
            .withFix(ConvertNumberBase("Convert to Hex (Base16)", 16))
            .withFix(ConvertNumberBase("Convert to Dec (Base10)", 10))
            .withFix(ConvertNumberBase("Convert to Oct (Base8)", 8))
            .withFix(ConvertNumberBase("Convert to Bin (Base2)", 2))
            .create()
    }

    private fun annotateUnit(number: PsiElement, unit: String, holder: AnnotationHolder, range: TextRange) {
        holder.newAnnotation(HighlightSeverity.WARNING, "Out of range")
            .range(range)
            .create()
    }
}


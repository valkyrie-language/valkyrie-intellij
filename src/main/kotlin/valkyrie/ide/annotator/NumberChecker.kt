// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import valkyrie.language.psi_node.ValkyrieNumberNode

class NumberChecker : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is ValkyrieNumberNode) {
            holder.newSilentAnnotation(HighlightSeverity.WARNING)
                .range(element.textRange)
//                .textAttributes(VALID_STRING_ESCAPE)
                .withFix(ConvertNumber())
                .create()
        }
    }
}


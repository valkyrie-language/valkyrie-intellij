// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.valkyrie.ide.reference

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import org.intellij.sdk.language.SimpleAnnotator.SIMPLE_PREFIX_STR
import org.intellij.sdk.language.SimpleAnnotator.SIMPLE_SEPARATOR_STR

class ValkyrieReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(org.jetbrains.kotlin.com.intellij.psi.PsiLiteralExpression::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext,
                ): Array<PsiReference> {
                    val literalExpression: org.jetbrains.kotlin.com.intellij.psi.PsiLiteralExpression =
                        element as org.jetbrains.kotlin.com.intellij.psi.PsiLiteralExpression
                    val value = if (literalExpression.getValue() is String) literalExpression.getValue() else null
                    if (value != null && value.startsWith(SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR)) {
                        val property = TextRange(
                            SIMPLE_PREFIX_STR.length() + SIMPLE_SEPARATOR_STR.length() + 1,
                            value.length + 1
                        )
                        return arrayOf(ValkyrieReference(element, property))
                    }
                    return PsiReference.EMPTY_ARRAY
                }
            })
    }
}
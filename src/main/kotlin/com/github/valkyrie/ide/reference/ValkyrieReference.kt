// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.valkyrie.ide.reference

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

class ValkyrieReference(element: PsiElement, textRange: TextRange) :
    PsiReferenceBase<PsiElement?>(element, textRange), PsiPolyVariantReference {
    private val key: String

    init {
        key = element.text.substring(textRange.startOffset, textRange.endOffset)
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = myElement!!.project
        val properties: List<SimpleProperty> = SimpleUtil.findProperties(project, key)
        val results: MutableList<ResolveResult> = ArrayList()
        for (property in properties) {
            results.add(PsiElementResolveResult(property))
        }
        return results.toTypedArray()
    }

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return if (resolveResults.size == 1) resolveResults[0].element else null
    }

    override fun getVariants(): Array<Any> {
        val project = myElement!!.project
        val properties: List<SimpleProperty> = SimpleUtil.findProperties(project)
        val variants: MutableList<LookupElement> = ArrayList()
        for (property in properties) {
            if (property.getKey() != null && property.getKey().length() > 0) {
                variants.add(
                    LookupElementBuilder
                        .create(property).withIcon(SimpleIcons.FILE)
                        .withTypeText(property.getContainingFile().getName())
                )
            }
        }
        return variants.toTypedArray()
    }
}
package com.github.valkyrie.ide.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PlainTextTokenTypes
import com.intellij.util.ProcessingContext

class ValkyrieCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(PlainTextTokenTypes.PLAIN_TEXT),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet,
                ) {
                    result.addElement(LookupElementBuilder.create("Hello World"))
                }
            })
    }
}
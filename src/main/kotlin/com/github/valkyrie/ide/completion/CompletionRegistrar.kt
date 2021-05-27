package com.github.valkyrie.ide.completion

import com.github.valkyrie.language.psi.ValkyrieTypes
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.codeInsight.completion.*
import com.intellij.openapi.progress.ProgressManager
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext

class CompletionRegistrar : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, Identifier, CompleteSymbol())
        extend(CompletionType.BASIC, Escaping, CompleteOperator())
    }

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        ProgressManager.checkCanceled()
        val context = ProcessingContext()
        when (parameters.originalPosition) {
            is ValkyrieIdentifierNode -> {
                CompleteSymbol().addCompletionVariants(parameters, context, result)
            }
        }
    }

    override fun beforeCompletion(context: CompletionInitializationContext) {
        super.beforeCompletion(context)
    }

    override fun duringCompletion(context: CompletionInitializationContext) {
        super.duringCompletion(context)
    }



    companion object {
        val Escaping = PlatformPatterns.psiElement(ValkyrieTypes.KW_ESCAPING)!!

        // PlatformPatterns.psiElement(ValkyrieIdentifierNode::class.java)
        val Identifier = PlatformPatterns.psiElement(ValkyrieTypes.SYMBOL_XID)!!
//            .andOr(PlatformPatterns.psiElement(ValkyrieTypes.SYMBOL_XID))
//            .andOr(PlatformPatterns.psiElement(ValkyrieTypes.SYMBOL_RAW))
    }
}


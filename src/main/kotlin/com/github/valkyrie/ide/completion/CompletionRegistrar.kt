package com.github.valkyrie.ide.completion

import com.github.valkyrie.ide.file.ValkyrieFileNode
import com.github.valkyrie.language.psi.ValkyrieClassTuple
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.github.valkyrie.language.psi_node.ValkyrieClassBlockNode
import com.github.valkyrie.language.psi_node.ValkyrieClassTupleNode
import com.github.valkyrie.language.psi_node.ValkyrieDefineBlockNode
import com.github.valkyrie.language.psi_node.ValkyrieMacroBlockNode
import com.github.valkyrie.language.psi_node.ValkyrieTopBlockNode
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.util.elementType
import com.intellij.psi.util.parents
import com.intellij.util.ProcessingContext


class CompletionRegistrar : CompletionContributor() {
    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        ProgressManager.checkCanceled()
        val context = ProcessingContext()
        val element = parameters.originalPosition ?: return
        when (element.elementType) {
            ValkyrieTypes.SYMBOL_XID, ValkyrieTypes.SYMBOL_RAW,
            ValkyrieTypes.KW_DEF, ValkyrieTypes.KW_LET,
            ValkyrieTypes.OP_IN -> {
                for (node in element.parents(false)) {
                    when (node) {
                        is ValkyrieFileNode, is ValkyrieTopBlockNode -> {
                            CompleteSymbol(node).inTopStatement(parameters, context, result)
                            return
                        }
                        is ValkyrieClassBlockNode -> {
                            CompleteSymbol(node).inClassBlock(parameters, context, result)
                            return
                        }
                        is ValkyrieClassTupleNode -> {
                            CompleteSymbol(node).inClassTuple(parameters, context, result)
                            return
                        }
                        is ValkyrieMacroBlockNode -> {
                            CompleteSymbol(node).inMacroBlock(parameters, context, result)
                            return
                        }
                        is ValkyrieDefineBlockNode -> {
                            return
                        }
                    }
                }
            }
            ValkyrieTypes.KW_ESCAPING, ValkyrieTypes.KW_MACRO -> {
                CompleteOperator(element).addCompletionVariants(parameters, context, result)
            }
        }

    }

//    override fun beforeCompletion(context: CompletionInitializationContext) {
//        ActionManager.getInstance().getAction(IdeActions.ACTION_CODE_COMPLETION).actionPerformed()
//        when (context.file.findElementAt(context.startOffset)) {
//            ValkyrieTypes.KW_ESCAPING -> {
//                context.dummyIdentifier = "\\"
//                context.replacementOffset = context.startOffset
//            }
//
//            ValkyrieTypes.AT -> {
//                context.dummyIdentifier = "@"
//                context.replacementOffset = context.startOffset
//            }
//        }
//    }

}


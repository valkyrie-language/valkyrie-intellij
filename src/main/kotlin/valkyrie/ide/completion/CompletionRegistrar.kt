package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.util.parents
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.*


class CompletionRegistrar : CompletionContributor() {
    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        ProgressManager.checkCanceled()

        val element = parameters.originalPosition ?: return
        for (node in element.parents(false)) {
            if (result.isStopped) {
                return
            }
            when (node) {
                is ValkyrieFileNode -> {
                    CompletionInFile(node, parameters, result).complete()
                    return
                }

                is ValkyrieClassBody -> {
                    when (val ctx = ValkyrieDeclaration.getCaretDeclaration(node)) {
                        is ValkyrieDeclareClassNode -> {
                            CompletionInClass(ctx, parameters, result).complete(node)
                        }

                        is ValkyrieDeclareTraitNode -> {
                            CompletionInTrait(ctx, parameters, result).complete(node)
                        }
                    }
                    return
                }
                is ValkyrieMatchBody -> {
                    // type, case, when, else
                    return
                }

                is ValkyrieArgumentBody -> {
                    return
                }
                is ValkyrieBlockBody -> {
                    return
                }
            }
        }
    }
}

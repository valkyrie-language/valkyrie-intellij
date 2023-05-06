package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.util.parents
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.ValkyrieDeclareElement
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
                    node.accept(CompletionVisitor(parameters, result, null))
                    return
                }

                is ValkyrieClassBody -> {
                    when (val ctx = ValkyrieDeclareElement.getCaretDeclaration(node)) {
                        is ValkyrieDeclareClassNode -> {
                            CompletionInClass(ctx, parameters, result).complete(node)
                        }

                        is ValkyrieDeclareTraitNode -> {
                            CompletionInTrait(ctx, parameters, result)
                        }
                    }
                    return
                }

                is ValkyrieBlockBody -> {
                    val ctx = ValkyrieDeclareElement.getCaretDeclaration(node)
                    node.accept(CompletionVisitor(parameters, result, ctx))
                    return
                }
            }
        }
    }
}

class CompletionVisitor : ValkyrieVisitor {
    private val parameters: CompletionParameters
    val context: ValkyrieDeclareElement?
    val result: CompletionResultSet

    constructor(parameters: CompletionParameters, result: CompletionResultSet, context: ValkyrieDeclareElement?) : super() {
        this.parameters = parameters
        this.context = context
        this.result = result
    }

    override fun visitClassBody(o: ValkyrieClassBody) {
        println("CompletionVisitor.visitClassBody")

        result.addElement(LookupElementBuilder.create("visitClassBody"))
    }


    override fun visitBlockBody(o: ValkyrieBlockBody) {
        println("CompletionVisitor.visitBlockBody")
        result.addElement(LookupElementBuilder.create("visitBlockBody"))
    }
}

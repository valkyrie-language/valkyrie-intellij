package com.github.valkyrie.ide.completion

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext

class CompleteSymbol(val element: PsiElement) : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.addDeclarationStatement()

        result.addLinkedTraitMethod("constructor", "Constructor")
        result.addLinkedTraitMethod("from", "From[T]")
    }

    companion object {
        fun classDeclare(show: String, text: String? = null, lookup: Set<String> = setOf()): LookupElementBuilder {
            val replace = when (text) {
                null -> "$show  {}"
                else -> "$text  {}"
            }
            return LookupElementBuilder.create(show).bold()
                .withLookupStrings(lookup)
                .withIcon(ValkyrieIconProvider.KEYWORDS)
                .withInsertHandler { context, _ ->
                    val document = context.document
                    document.replaceString(context.startOffset, context.tailOffset, replace)
                    context.editor.caretModel.moveToOffset(context.tailOffset - 3)
                }
        }

        fun letDeclare(show: String, replace: String, offset: Int, lookup: Set<String> = setOf()): LookupElementBuilder {
            return LookupElementBuilder.create(show).bold()
                .withLookupStrings(lookup)
                .withIcon(ValkyrieIconProvider.KEYWORDS)
                .withInsertHandler { context, _ ->
                    val document = context.document
                    document.replaceString(context.startOffset, context.tailOffset, replace)
                    context.editor.caretModel.moveToOffset(context.tailOffset - offset)
                }
        }
    }
}

private fun CompletionResultSet.addLinkedTraitMethod(kind: String, trait: String) {
    val element = LookupElementBuilder.create(kind)
        .withIcon(ValkyrieIconProvider.FUNCTION)
        .withTypeText(trait, ValkyrieIconProvider.TRAIT, false)
    this.addElement(element)
}

private fun CompletionResultSet.addDeclarationStatement() {
    addElement(CompleteSymbol.letDeclare("val", null))
    addElement(CompleteSymbol.classDeclare("var", null))
    addElement(CompleteSymbol.classDeclare("class", null))
    addElement(CompleteSymbol.classDeclare("native class", "@native class", lookup = setOf("valueclass")))
    addElement(CompleteSymbol.classDeclare("trait", null, lookup = setOf("abstractclass")))
    addElement(CompleteSymbol.classDeclare("interface", null))
    addElement(CompleteSymbol.classDeclare("protocol", null))
}
package com.github.valkyrie.ide.completion

import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.classDeclare
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.defDeclare
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.infixDeclare
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.letDeclare
import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.language.psi_node.ValkyrieClassBlockNode
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext

class CompleteSymbol(val element: PsiElement) : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {}
    fun inTopStatement(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.addDeclarationStatement()
    }

    fun inClassDeclare(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.addOperationDeclare()
        result.addLinkedTraitMethod("constructor", "Constructor")
        result.addLinkedTraitMethod("hash", "Hash")
        result.addLinkedTraitMethod("from", "From[T]", "value: T")
        result.addLinkedTraitMethod("apply", "Caller")
        result.addLinkedTraitMethod("unapply", "Extractor")
    }

    fun inNormalTest(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.addOperationDeclare()
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

        fun defDeclare(show: String, replace: String, offset: Int, lookup: Set<String> = setOf()): LookupElementBuilder {
            return LookupElementBuilder.create(show).bold()
                .withLookupStrings(lookup)
                .withIcon(ValkyrieIconProvider.KEYWORDS)
                .withInsertHandler { context, _ ->
                    val document = context.document
                    document.replaceString(context.startOffset, context.tailOffset, replace)
                    context.editor.caretModel.moveToOffset(context.tailOffset - offset)
                }
        }

        fun infixDeclare(show: String, lookup: Set<String> = setOf()): LookupElementBuilder {
            return LookupElementBuilder.create("infix $show")
                .withLookupStrings(lookup)
                .withIcon(ValkyrieIconProvider.OPERATOR)
                .withInsertHandler { context, _ ->
                    val document = context.document
                    document.replaceString(context.startOffset, context.tailOffset, "infix `$show`(rhs: Self) {}")
                    context.editor.caretModel.moveToOffset(context.tailOffset - 1)
                }
        }
    }
}

private fun CompletionResultSet.addLinkedTraitMethod(kind: String, trait: String, args: String = "") {
    val element = LookupElementBuilder.create(kind)
        .withIcon(ValkyrieIconProvider.FUNCTION)
        .withTypeText(trait, ValkyrieIconProvider.TRAIT, false)
        .withInsertHandler { context, _ ->
            val document = context.document
            document.replaceString(context.startOffset, context.tailOffset, "$kind($args) {}")
            context.editor.caretModel.moveToOffset(context.tailOffset - 1)
        }
    this.addElement(element)
}

private fun CompletionResultSet.addOperationDeclare() {
    addElement(infixDeclare("+", setOf("infixadd", "infixplus")))
    addElement(infixDeclare("+=", setOf("infixaddassign", "infixplusassign")))
    addElement(infixDeclare("-", setOf("infixsub", "infixminus")))
    addElement(infixDeclare("-=", setOf("infixsubassign", "infixminusassign")))
    addElement(infixDeclare("*", setOf("infixmul", "infixtimes")))
    addElement(infixDeclare("*=", setOf("infixmulassign", "infixmulassign")))
}

private fun CompletionResultSet.addDeclarationStatement() {
    addElement(letDeclare("let", "let  =", 2, setOf("val")))
    addElement(letDeclare("let mut", "let mut  =", 2, setOf("mut", "var")))
    addElement(defDeclare("def", "def  () {}", 6, setOf("fn", "fun", "function")))
    addElement(letDeclare("type", "type  =", 2))
    addElement(classDeclare("class", null, setOf("cass", "struct")))
    addElement(classDeclare("native class", "@native class", setOf("valueclass")))
    addElement(classDeclare("trait", null, setOf("abstractclass")))
    addElement(classDeclare("interface", null))
    addElement(classDeclare("protocol", null))
    addElement(classDeclare("tagged", null, setOf("enum")))
    addElement(classDeclare("bitset", null, setOf("bitflag")))
}
package com.github.valkyrie.ide.completion

import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.annotationCall
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.infixDeclare
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.macroCall
import com.github.valkyrie.ide.completion.TemplateReplaceElement.Companion.snippetFromPath
import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext
import javax.swing.Icon

class CompleteSymbol(val element: PsiElement) : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {}
    fun inTopStatement(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.addTopMacros()
        result.addDeclarationStatement(parameters.position)
        result.addControlFlow(parameters.position)
    }

    fun inClassBlock(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.addTopMacros()
        result.addOperationDeclare()
        result.addLinkedTraitMethod("constructor", "Constructor")
        result.addLinkedTraitMethod("hash", "Hash")
        result.addLinkedTraitMethod("from", "From[T]", "value: T")
        result.addLinkedTraitMethod("apply", "Caller")
        result.addLinkedTraitMethod("unapply", "Extractor")
    }

    fun inClassTuple(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.addTopMacros()
    }

    fun inMacroBlock(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {

    }

    fun inDefineBlock(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.addControlFlow(parameters.position)
    }

    companion object {
        private fun buildWithReplace(show: String, replace: String, offset: Int, lookup: Set<String>, icon: Icon): LookupElementBuilder {
            return LookupElementBuilder.create(show).bold()
                .withLookupStrings(lookup)
                .withIcon(icon)
                .withInsertHandler { context, _ ->
                    val document = context.document
                    document.replaceString(context.startOffset, context.tailOffset, replace)
                    context.editor.caretModel.moveToOffset(context.tailOffset - offset)
                }
        }

        fun infixDeclare(show: String, lookup: Set<String> = setOf()): LookupElementBuilder {
            return buildWithReplace("infix $show", "infix `$show`(rhs: Self) {}", 1, lookup, ValkyrieIconProvider.OPERATOR)
        }

        fun macroCall(show: String, replace: String, offset: Int, lookup: Set<String> = setOf()): LookupElementBuilder {
            return buildWithReplace(show, replace, offset, lookup, ValkyrieIconProvider.MACRO)
        }

        fun annotationCall(show: String, replace: String, offset: Int, lookup: Set<String> = setOf()): LookupElementBuilder {
            return buildWithReplace(show, replace, offset, lookup, ValkyrieIconProvider.ANNOTATION)
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

private fun CompletionResultSet.addTopMacros() {
    addElement(annotationCall("@derive", "@derive()", 1))
    addElement(macroCall("@type_of", "@type_of[]", 1))
    addElement(macroCall("@name_of", "@name_of[]", 1))
    addElement(macroCall("@name_path_of", "@name_path_of[]", 1))
}

private fun CompletionResultSet.addOperationDeclare() {
    addElement(infixDeclare("+", setOf("infixadd", "infixplus")))
    addElement(infixDeclare("+=", setOf("infixaddassign", "infixplusassign")))
    addElement(infixDeclare("-", setOf("infixsub", "infixminus")))
    addElement(infixDeclare("-=", setOf("infixsubassign", "infixminusassign")))
    addElement(infixDeclare("*", setOf("infixmul", "infixtimes")))
    addElement(infixDeclare("*=", setOf("infixmulassign", "infixmulassign")))
}

private fun CompletionResultSet.addDeclarationStatement(element: PsiElement) {
    addElement(snippetFromPath(element, "let", "let.ft", setOf("val")))
    addElement(snippetFromPath(element, "let mut", "let_mut.ft", setOf("var", "mut")))

    addElement(snippetFromPath(element, "def", "def.ft", setOf("fn", "fun", "function")))

    addElement(snippetFromPath(element, "type", "type.ft"))
    addElement(snippetFromPath(element, "association type", "type_association.ft"))
    addElement(snippetFromPath(element, "result type", "type_result.ft"))

    addElement(snippetFromPath(element, "class", "class.ft", setOf("cass", "struct")))
    addElement(snippetFromPath(element, "tuple class", "class_tuple.ft"))
    addElement(snippetFromPath(element, "generic class", "class_generic.ft"))

    addElement(snippetFromPath(element, "trait", "trait.ft"))
    addElement(snippetFromPath(element, "interface", "interface.ft"))
    addElement(snippetFromPath(element, "protocol", "protocol.ft"))
    addElement(snippetFromPath(element, "tagged", "tagged.ft"))
    addElement(snippetFromPath(element, "bitset", "bitset.ft"))
}


private fun CompletionResultSet.addControlFlow(element: PsiElement) {
    addElement(snippetFromPath(element, "if", "if.ft"))
    addElement(snippetFromPath(element, "else if", "else_if.ft", setOf("ef")))
    addElement(snippetFromPath(element, "else", "else.ft"))
    addElement(snippetFromPath(element, "for", "for_in.ft", setOf("forin")))
    addElement(snippetFromPath(element, "for range", "for_range.ft"))
    addElement(snippetFromPath(element, "for kv", "for_kv.ft"))
}

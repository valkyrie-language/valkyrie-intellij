package com.github.valkyrie.ide.completion

import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.annotationCall
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.classComplex
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.classSimple
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.defDeclare
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.infixDeclare
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.letDeclare
import com.github.valkyrie.ide.completion.CompleteSymbol.Companion.macroCall
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
        result.addDeclarationStatement()
        result.addControlFlow()
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
        result.addControlFlow()
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

        fun classSimple(show: String, lookup: Set<String> = setOf()): LookupElementBuilder {
            return buildWithReplace(show, "$show  {}", 3, lookup, ValkyrieIconProvider.SNIPPET)
        }

        fun classComplex(show: String, replace: String, offset: Int, lookup: Set<String> = setOf()): LookupElementBuilder {
            return buildWithReplace(show, replace, offset, lookup, ValkyrieIconProvider.SNIPPET)
        }

        fun letDeclare(show: String, replace: String, offset: Int, lookup: Set<String> = setOf()): LookupElementBuilder {
            return buildWithReplace(show, replace, offset, lookup, ValkyrieIconProvider.SNIPPET)
        }

        fun defDeclare(show: String, replace: String, offset: Int, lookup: Set<String> = setOf()): LookupElementBuilder {
            return buildWithReplace(show, replace, offset, lookup, ValkyrieIconProvider.SNIPPET)
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


        fun ifStatement(show: String, replace: String, offset: Int, lookup: Set<String> = setOf()): LookupElementBuilder {
            return LookupElementBuilder.create(show).bold()
                .withLookupStrings(lookup)
                .withIcon(ValkyrieIconProvider.SNIPPET)
                .withInsertHandler { context, item ->
                    val element = item.psiElement ?: return@withInsertHandler
                    TemplateBuilder(element, context.editor).runTemplate(show, "aa")
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

private fun CompletionResultSet.addDeclarationStatement() {
    addElement(letDeclare("let", "let  =", 2, setOf("val")))
    addElement(letDeclare("let mut", "let mut  =", 2, setOf("mut", "var")))
    addElement(letDeclare("type", "type  =", 2))
    addElement(defDeclare("def", "def  () {}", 6, setOf("fn", "fun", "function")))

    addElement(classComplex("class", "class  {}", 3, setOf("cass", "struct")))
    addElement(classComplex("class simple", "class ()", 2, setOf("tupleclass")))
    addElement(classComplex("class native", "class native  {}", 3, setOf("valueclass")))

    addElement(classSimple("trait", setOf("abstractclass")))
    addElement(classSimple("interface"))
    addElement(classSimple("protocol"))
    addElement(classSimple("tagged", setOf("enum")))
    addElement(classSimple("bitset", setOf("bitflag")))
}


private fun CompletionResultSet.addControlFlow() {
    addElement(letDeclare("if", "if cond {}", 3))
    addElement(letDeclare("else if", "else if  {}", 3, setOf("ef", "elseif")))
    addElement(letDeclare("else", "else {}", 2, setOf("es")))
    addElement(letDeclare("for in", "for i in  {}", 3, setOf("for i in {}")))
    addElement(letDeclare("for range", "for i in range  {}", 3, setOf("infixtimes")))
    addElement(letDeclare("for kv", "for key, value in  {}", 3, setOf("fordict")))
}

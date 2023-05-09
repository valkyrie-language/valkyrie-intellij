package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.icons.ExpUiIcons
import valkyrie.ide.live_template.ValkyrieLiveTemplate
import valkyrie.language.ValkyrieBundle

open class ValkyrieCompletionProvider(val parameters: CompletionParameters, val result: CompletionResultSet) {
    protected fun addFunctions() {
        for (arguments in 0..3) {
            result.addElement(
                LookupElementBuilder.create("function$arguments")
                    .withIcon(AllIcons.Nodes.Method)
                    .withBaseLookupString("function$arguments")
                    .withLookupStrings(mutableSetOf("function$arguments", "fn$arguments"))
                    .withCaseSensitivity(false)
                    .withInsertHandler(getTemplate("function$arguments"))
            )
            result.addElement(
                LookupElementBuilder.create("function$arguments?")
                    .withIcon(AllIcons.Nodes.Method)
                    .withBaseLookupString("function$arguments?")
                    .withLookupStrings(mutableSetOf("function$arguments$arguments", "ff$arguments"))
                    .withCaseSensitivity(false)
                    .withInsertHandler(getTemplate("function$arguments?"))
            )
        }
    }

    protected fun addMethods() {
        for (arguments in 0..3) {
            result.addElement(
                LookupElementBuilder.create("method$arguments")
                    .withIcon(AllIcons.Nodes.Method)
                    .withBaseLookupString("method$arguments")
                    .withLookupStrings(mutableSetOf("fn$arguments"))
                    .withCaseSensitivity(false)
                    .withTypeText(ValkyrieBundle.message("completion.method.unit", arguments), true)
                    .withInsertHandler(getTemplate("method$arguments"))
            )
            result.addElement(
                LookupElementBuilder.create("method$arguments?")
                    .withIcon(AllIcons.Nodes.Method)
                    .withBaseLookupString("method$arguments?")
                    .withLookupStrings(
                        mutableSetOf(
                            "ff$arguments",
                        )
                    )
                    .withCaseSensitivity(false)
                    .withTypeText(ValkyrieBundle.message("completion.method.result", arguments), true)
                    .withInsertHandler(getTemplate("method$arguments?"))
            )
        }
    }

    protected fun addGetSet() {
        result.addElement(
            LookupElementBuilder.create("getter")
                .withIcon(AllIcons.Nodes.Property)
                .withBaseLookupString("getter")
                .withLookupStrings(mutableSetOf("getter", "gg"))
                .withCaseSensitivity(false)
                .withTypeText(ValkyrieBundle.message("completion.getter"), true)
                .withInsertHandler(getTemplate("getter"))
        )
        result.addElement(
            LookupElementBuilder.create("setter")
                .withIcon(AllIcons.Nodes.Property)
                .withBaseLookupString("setter")
                .withLookupStrings(mutableSetOf("setter", "ss"))
                .withCaseSensitivity(false)
                .withTypeText(ValkyrieBundle.message("completion.setter"), true)
                .withInsertHandler(getTemplate("setter"))
        )
        result.addElement(
            LookupElementBuilder.create("get-set")
                .withIcon(AllIcons.Nodes.Property)
                .withBaseLookupString("get-set")
                .withLookupStrings(mutableSetOf("get-set", "getset", "gs"))
                .withCaseSensitivity(false)
                .withTypeText(ValkyrieBundle.message("completion.get-set"), true)
                .withInsertHandler(getTemplate("get-set"))
        )
    }

    protected fun addConstructor() {
        createKeywordMethod("constructor", mutableSetOf("ctor"), ValkyrieBundle.message("completion.constructor"))
        createKeywordMethod("constructor?", mutableSetOf("ctrr"), ValkyrieBundle.message("completion.constructor.result"))
        createKeywordMethod("destructor", mutableSetOf("dtor"), ValkyrieBundle.message("completion.constructor"))
        createKeywordMethod("invoker", mutableSetOf("apply"), ValkyrieBundle.message("completion.constructor"))
        createKeywordMethod("extractor", mutableSetOf("unapply"), ValkyrieBundle.message("completion.constructor"))


        createOperatorMethod("plus", mutableSetOf("add", "+"), ValkyrieBundle.message("completion.constructor"))
        createOperatorMethod("plus-assign", mutableSetOf("add=", "+="), ValkyrieBundle.message("completion.constructor"))
        createOperatorMethod("offset-index", mutableSetOf("off"), ValkyrieBundle.message("completion.constructor"))
        createOperatorMethod("ordinal-index", mutableSetOf("ord"), ValkyrieBundle.message("completion.constructor"))
        createOperatorMethod("minus", mutableSetOf("sub"), ValkyrieBundle.message("completion.constructor"))

    }

    private fun createKeywordMethod(id: String, word: MutableSet<String>, help: String) {
        val lookup = LookupElementBuilder.create(id)
            .withIcon(ExpUiIcons.Nodes.MethodReference)
            .withCaseSensitivity(true)
            .withBaseLookupString(id)
            .withLookupStrings(word)
            .withTypeText(help, true)
            .withInsertHandler(getTemplate(id))
        result.addElement(lookup)
    }

    private fun createOperatorMethod(id: String, word: MutableSet<String>, help: String) {
        val lookup = LookupElementBuilder.create(id)
            .withIcon(ExpUiIcons.Inline.Regex)
            .withCaseSensitivity(true)
            .withBaseLookupString(id)
            .withLookupStrings(word)
            .withTypeText(help, true)
            .withInsertHandler(getTemplate(id))
        result.addElement(lookup)
    }

    private fun getTemplate(template: String): ValkyrieCompletionTemplate? {
        return ValkyrieLiveTemplate.getTemplate(template)?.let { ValkyrieCompletionTemplate(it) }
    }
}
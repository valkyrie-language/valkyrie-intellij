package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.template.impl.TemplateSettings
import com.intellij.icons.AllIcons
import valkyrie.language.ValkyrieBundle

open class ValkyrieCompletionProvider(val parameters: CompletionParameters, val result: CompletionResultSet) {
    protected fun addMethods() {
        for (arguments in 0..9) {
            val t1 = TemplateSettings.getInstance().getTemplate("method$arguments", "Valkyrie");
            result.addElement(
                LookupElementBuilder.create("method$arguments")
                    .withIcon(AllIcons.Nodes.Method)
                    .withBaseLookupString("method$arguments")
                    .withLookupStrings(mutableSetOf("fn$arguments"))
                    .withCaseSensitivity(false)
                    .withTypeText(ValkyrieBundle.message("completion.method.unit", arguments), true)
                    .withInsertHandler(t1?.let { ValkyrieLiveTemplate(it) })
            )
            val t2 = TemplateSettings.getInstance().getTemplate("method$arguments?", "Valkyrie");
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
                    .withInsertHandler(t2?.let { ValkyrieLiveTemplate(it) })
            )
        }
    }

    protected fun addFunctions() {
        for (arguments in 0..9) {
            val t1 = TemplateSettings.getInstance().getTemplate("function$arguments", "Valkyrie");
            result.addElement(
                LookupElementBuilder.create("function$arguments")
                    .withIcon(AllIcons.Nodes.Method)
                    .withBaseLookupString("function$arguments")
                    .withLookupStrings(mutableSetOf("function$arguments", "fn$arguments"))
                    .withCaseSensitivity(false)
                    .withInsertHandler(t1?.let { ValkyrieLiveTemplate(it) })
            )
            val t2 = TemplateSettings.getInstance().getTemplate("function$arguments?", "Valkyrie");
            result.addElement(
                LookupElementBuilder.create("function$arguments?")
                    .withIcon(AllIcons.Nodes.Method)
                    .withBaseLookupString("function$arguments?")
                    .withLookupStrings(mutableSetOf("function$arguments$arguments", "ff$arguments"))
                    .withCaseSensitivity(false)
                    .withInsertHandler(t2?.let { ValkyrieLiveTemplate(it) })
            )
        }
    }
}
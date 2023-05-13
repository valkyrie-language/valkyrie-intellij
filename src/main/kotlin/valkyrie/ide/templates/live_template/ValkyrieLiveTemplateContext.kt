@file:Suppress("DEPRECATION")

package valkyrie.ide.live_template

import com.intellij.codeInsight.template.*
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage

class ValkyrieLiveTemplateContext : LiveTemplateContextProvider {
    override fun createContexts(): MutableCollection<LiveTemplateContext> {
        return mutableListOf(
            SnippetContextAll(),
            SnippetContextConditional("top") {
                it.file.language is ValkyrieLanguage
            },
            SnippetContextConditional("class") {
                it.file.language is ValkyrieLanguage
            },
            SnippetContextConditional("match") {
                it.file.language is ValkyrieLanguage
            },
            SnippetContextConditional("micro") {
                it.file.language is ValkyrieLanguage
            }
        )
    }
}

private class SnippetContextAll : TemplateContextType, LiveTemplateContext {

    constructor() : super("valkyrie", ValkyrieBundle.message("live-template.scope.all"), EverywhereContextType::class.java);

    override fun getBaseContextId(): String? {
        return null
    }

    override fun getTemplateContextType(): TemplateContextType {
        return this
    }

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.language is ValkyrieLanguage
    }
}

private class SnippetContextConditional : TemplateContextType, LiveTemplateContext {

    val condition: (TemplateActionContext) -> Boolean

    constructor(id: String, condition: (TemplateActionContext) -> Boolean) : super(
        "valkyrie-${id}",
        ValkyrieBundle.message("live-template.scope.${id}"),
        SnippetContextAll::class.java
    ) {
        this.condition = condition
    }

    override fun getBaseContextId(): String {
        return "valkyrie"
    }

    override fun getTemplateContextType(): TemplateContextType {
        return this
    }

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return condition(templateActionContext)
    }
}

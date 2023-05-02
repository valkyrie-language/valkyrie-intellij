@file:Suppress("DEPRECATION")

package valkyrie.ide.live_template

import com.intellij.codeInsight.template.*
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage

class ValkyrieLiveTemplateContext : LiveTemplateContextProvider {
    override fun createContexts(): MutableCollection<LiveTemplateContext> {
        return mutableListOf(
            SnippetContextAll(), SnippetOnTop(), SnippetContextInClass(), SnippetInMatch(), SnippetInFunction()
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

private class SnippetOnTop : TemplateContextType, LiveTemplateContext {
    constructor() : super("valkyrie-top", ValkyrieBundle.message("live-template.scope.top"), SnippetContextAll::class.java)


    override fun getBaseContextId(): String {
        return "valkyrie"
    }

    override fun getTemplateContextType(): TemplateContextType {
        return this
    }

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.language is ValkyrieLanguage
    }
}


private class SnippetInMatch : TemplateContextType, LiveTemplateContext {
    constructor() : super("valkyrie-match", ValkyrieBundle.message("live-template.scope.match"), SnippetContextAll::class.java)


    override fun getBaseContextId(): String {
        return "valkyrie"
    }

    override fun getTemplateContextType(): TemplateContextType {
        return this
    }

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.language is ValkyrieLanguage
    }
}


private class SnippetInFunction : TemplateContextType, LiveTemplateContext {
    constructor() : super("valkyrie-micro", ValkyrieBundle.message("live-template.scope.micro"), SnippetContextAll::class.java)


    override fun getBaseContextId(): String {
        return "valkyrie"
    }

    override fun getTemplateContextType(): TemplateContextType {
        return this
    }

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.language is ValkyrieLanguage
    }
}

private class SnippetContextInClass : TemplateContextType, LiveTemplateContext {
    constructor() : super("valkyrie-class", ValkyrieBundle.message("live-template.scope.class"), SnippetContextAll::class.java)


    override fun getBaseContextId(): String {
        return "valkyrie"
    }

    override fun getTemplateContextType(): TemplateContextType {
        return this
    }

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.language is ValkyrieLanguage
    }
}

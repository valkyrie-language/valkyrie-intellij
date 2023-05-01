package valkyrie.ide.live_template

import com.intellij.codeInsight.template.LiveTemplateContext
import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage


class ValkyrieLiveTemplateContextTop : TemplateContextType, LiveTemplateContext {
    constructor() : super("valkyrie-top", ValkyrieBundle.message("live-template.scope.top"), ValkyrieLiveTemplateContextAll::class.java)


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
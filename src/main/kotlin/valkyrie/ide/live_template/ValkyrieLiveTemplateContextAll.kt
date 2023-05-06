package valkyrie.ide.live_template

import com.intellij.codeInsight.template.EverywhereContextType
import com.intellij.codeInsight.template.LiveTemplateContext
import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage

@Suppress("DEPRECATION")
class ValkyrieLiveTemplateContextAll : TemplateContextType, LiveTemplateContext {

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

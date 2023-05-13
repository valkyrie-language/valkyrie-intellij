package valkyrie.ide.live_template

import com.intellij.codeInsight.template.CustomLiveTemplate
import com.intellij.codeInsight.template.CustomTemplateCallback
import com.intellij.codeInsight.template.impl.TemplateImpl
import com.intellij.codeInsight.template.impl.TemplateSettings

class ValkyrieLiveTemplate : CustomLiveTemplate {
    override fun computeTemplateKey(callback: CustomTemplateCallback): String? {
        return "computeTemplateKey"
    }

    override fun isApplicable(callback: CustomTemplateCallback, offset: Int, wrapping: Boolean): Boolean {
        return true
    }

    override fun supportsWrapping(): Boolean {
        return true
    }

    override fun expand(key: String, callback: CustomTemplateCallback) {

    }

    override fun wrap(selection: String, callback: CustomTemplateCallback) {

    }

    override fun getTitle(): String {
        return "GetTitle"
    }

    override fun getShortcut(): Char {
        return 'L'
    }

    companion object {
        fun getTemplate(key: String): TemplateImpl? {
            return TemplateSettings.getInstance().getTemplate(key, "Valkyrie Trigger")
        }
    }
}
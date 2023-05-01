@file:Suppress("DEPRECATION")

package valkyrie.ide.live_template

import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider

class ValkyrieLiveTemplateDefault : DefaultLiveTemplatesProvider {
    override fun getDefaultLiveTemplateFiles(): Array<String> {
        return arrayOf(
            "templates/liveTemplate.xml",
            "templates/liveTemplate/for-kv.xml",
        )
    }

    override fun getHiddenLiveTemplateFiles(): Array<String> {
        return arrayOf()
    }
}

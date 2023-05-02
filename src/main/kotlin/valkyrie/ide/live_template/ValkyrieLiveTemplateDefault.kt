package valkyrie.ide.completion

import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider

class ValkyrieLiveTemplateDefault : DefaultLiveTemplatesProvider {
    override fun getDefaultLiveTemplateFiles(): Array<String> {
        return arrayOf("templates/liveTemplate/bitset.ft", "templates/liveTemplate/class.ft")
    }

    override fun getHiddenLiveTemplateFiles(): Array<String>? {
        return arrayOf("templates/liveTemplate/class_tuple.ft")
    }

}
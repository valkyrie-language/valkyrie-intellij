package valkyrie.ide.completion

import com.intellij.codeInsight.template.LiveTemplateContext
import com.intellij.codeInsight.template.LiveTemplateContextProvider

class ValkyrieLiveTemplateContextProvider : LiveTemplateContextProvider {
    override fun createContexts(): MutableCollection<LiveTemplateContext> {
        return mutableListOf(ValkyrieLiveTemplateContextAll())
    }

}
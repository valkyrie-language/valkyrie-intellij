package valkyrie.ide.completion

import com.intellij.application.options.CodeCompletionOptionsCustomSection
import valkyrie.language.ValkyrieBundle
import javax.swing.JComponent

private val TITLE = ValkyrieBundle.message("settings.completion.title")

class CompletionConfig : CodeCompletionOptionsCustomSection {
    init {
//        checkBox(
//            ValkyrieBundle.message("settings.completion.suggest_out_of_scope_items"),
//            CodeInsightSettings.getInstance()::suggestOutOfScopeItems
//        )
    }

    override fun createComponent(): JComponent? {
        return null;
    }

    override fun isModified(): Boolean {
        return false;
    }

    override fun apply() {

    }
}
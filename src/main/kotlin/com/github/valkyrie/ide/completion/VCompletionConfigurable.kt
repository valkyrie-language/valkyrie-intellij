package com.github.valkyrie.ide.completion

import com.github.valkyrie.ValkyrieBundle
import com.github.valkyrie.settings.VCodeInsightSettings
import com.intellij.application.options.CodeCompletionOptionsCustomSection
import com.intellij.openapi.options.ConfigurableBuilder

class VCompletionConfigurable : ConfigurableBuilder(ValkyrieBundle.message("settings.rust.completion.title")),
    CodeCompletionOptionsCustomSection {
    init {
        checkBox(
            ValkyrieBundle.message("settings.rust.completion.suggest.out.of.scope.items"),
            VCodeInsightSettings.getInstance()::suggestOutOfScopeItems
        )
    }
}
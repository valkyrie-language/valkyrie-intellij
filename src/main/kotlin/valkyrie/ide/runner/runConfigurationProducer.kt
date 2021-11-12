package valkyrie.ide.runner

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.RunConfigurationProducer
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement

class runConfigurationProducer : RunConfigurationProducer<ValkyrieRunConfiguration>(false) {
    override fun setupConfigurationFromContext(
        configuration: ValkyrieRunConfiguration,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement>,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun isConfigurationFromContext(configuration: ValkyrieRunConfiguration, context: ConfigurationContext): Boolean {
        TODO("Not yet implemented")
    }
}



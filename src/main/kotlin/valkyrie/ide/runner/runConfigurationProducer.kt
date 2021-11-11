package valkyrie.ide.runner

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.RunConfigurationProducer
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement

class runConfigurationProducer : RunConfigurationProducer<ValkyrieRunningConfig>(false) {
    override fun setupConfigurationFromContext(
        configuration: ValkyrieRunningConfig,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement>,
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun isConfigurationFromContext(configuration: ValkyrieRunningConfig, context: ConfigurationContext): Boolean {
        TODO("Not yet implemented")
    }


}



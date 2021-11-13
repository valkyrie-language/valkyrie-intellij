package valkyrie.ide.runner

import com.intellij.execution.RunManager
import com.intellij.execution.RunnerAndConfigurationSettings
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement

class ValkyrieRunConfigurationProducer : LazyRunConfigurationProducer<ValkyrieRunLocal>() {
    override fun getConfigurationFactory(): ValkyrieConfigurationFactory {
        return ValkyrieConfigurationFactory(ValkyrieConfigurationType())
    }

    /**
     * @return 点击运行按钮之后的效果
     */
    override fun setupConfigurationFromContext(
        configuration: ValkyrieRunLocal,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement>,
    ): Boolean {
        return true;

    }


    override fun isConfigurationFromContext(configuration: ValkyrieRunLocal, context: ConfigurationContext): Boolean {
        TODO("Not yet implemented")
    }

}



package valkyrie.ide.code_vision

import com.intellij.codeInsight.codeVision.CodeVisionProvider
import com.intellij.codeInsight.codeVision.CodeVisionProviderFactory
import com.intellij.openapi.project.Project

class ValkyrieCodeVisionProviderFactory : CodeVisionProviderFactory {
    override fun createProviders(project: Project): Sequence<CodeVisionProvider<*>> {
        // DaemonBoundCodeVisionProvider 不通过工厂注册，而是通过扩展点直接注册
        // 返回空序列，实际的 DaemonBoundCodeVisionProvider 通过 plugin.xml 注册
        return emptySequence()
    }
}

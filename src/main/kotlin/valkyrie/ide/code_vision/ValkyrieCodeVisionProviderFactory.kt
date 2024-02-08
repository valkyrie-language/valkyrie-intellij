package valkyrie.ide.code_vision

import com.intellij.codeInsight.codeVision.CodeVisionProvider
import com.intellij.codeInsight.codeVision.CodeVisionProviderFactory
import com.intellij.openapi.project.Project

class ValkyrieCodeVisionProviderFactory : CodeVisionProviderFactory {
    override fun createProviders(project: Project): Sequence<CodeVisionProvider<*>> {
        // 暂时返回空的 Provider 列表，后续可在此处注册实际的 Code Vision Provider 实现
        return emptySequence()
    }
}

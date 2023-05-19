package valkyrie.ide.hint

import com.intellij.codeInsight.hints.declarative.InlayHintsProviderFactory
import com.intellij.codeInsight.hints.declarative.InlayProviderInfo
import com.intellij.lang.Language

/** use LambdaHintProvider instead */
class ValkyrieInlayProviderFactory : InlayHintsProviderFactory {
    override fun getProviderInfo(language: Language, providerId: String): InlayProviderInfo? {
        return null
    }

    override fun getProvidersForLanguage(language: Language): List<InlayProviderInfo> {
        return listOf()
    }

    override fun getSupportedLanguages(): Set<Language> {
        return setOf()
    }
}

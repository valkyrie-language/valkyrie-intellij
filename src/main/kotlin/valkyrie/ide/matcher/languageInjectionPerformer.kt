package valkyrie.ide.matcher

import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionPerformer
import com.intellij.psi.PsiElement

class languageInjectionPerformer : LanguageInjectionPerformer {
    override fun isPrimary(): Boolean {
        return true
    }

    override fun performInjection(registrar: MultiHostRegistrar, injection: Injection, context: PsiElement): Boolean {
        return true
    }
}

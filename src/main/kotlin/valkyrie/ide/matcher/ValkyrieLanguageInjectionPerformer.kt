package valkyrie.ide.matcher

import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionPerformer
import com.intellij.psi.PsiElement

class ValkyrieLanguageInjectionPerformer : LanguageInjectionPerformer {
    override fun isPrimary(): Boolean {
        return false
    }

    override fun performInjection(registrar: MultiHostRegistrar, injection: Injection, context: PsiElement): Boolean {
        return false
    }
}


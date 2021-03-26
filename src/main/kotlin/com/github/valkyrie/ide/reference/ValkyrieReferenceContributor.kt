package com.github.valkyrie.ide.reference

import com.github.valkyrie.language.psi.ValkyrieSymbol
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar

class ValkyrieReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyrieSymbol::class.java),
            ClassReferenceProvider()
        )
    }
}


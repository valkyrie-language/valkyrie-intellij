package com.github.valkyrie.ide.reference

import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.github.valkyrie.language.psi.ValkyrieTaggedStatement
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar

class ValkyrieReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyrieClassStatement::class.java),
            StructReferenceProvider()
        )
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyrieTaggedStatement::class.java),
            EnumReferenceProvider()
        )
    }
}


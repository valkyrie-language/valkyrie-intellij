package com.github.valkyrie.ide.matcher

import com.github.valkyrie.language.mixin.MixinString
import com.github.valkyrie.language.psi_node.ValkyrieStringNode
import com.intellij.json.json5.Json5Language
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionPerformer
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import org.intellij.lang.regexp.RegExpLanguage
import javax.swing.Icon

class LanguageInjectorPerformer : LanguageInjectionPerformer {
    override fun isPrimary(): Boolean = true
    override fun performInjection(registrar: MultiHostRegistrar, injection: Injection, context: PsiElement): Boolean {
        return when (context) {
            is ValkyrieStringNode -> context.registerInject(registrar)
            else -> false
        }
    }
}

class LanguageInjector: MultiHostInjector {
    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        when (context) {
            is ValkyrieStringNode -> {
                registrar.startInjecting(RegExpLanguage.INSTANCE)
                    .addPlace(null, null, context, TextRange(0, context.text.length))
                    .doneInjecting()
            }
            else -> return
        }
    }

    override fun elementsToInjectIn(): MutableList<out Class<out PsiElement>> {
       return mutableListOf(ValkyrieStringNode::class.java)
    }

    private fun tryInject(language: String?): Injection? = when (language) {
        "re", "regex", "regexr" -> SimpleInjection(RegExpLanguage.INSTANCE, "", "", null)
        "json", "json5" -> SimpleInjection(Json5Language.INSTANCE, "", "", null)
        else -> null
    }
}
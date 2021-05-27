package com.github.valkyrie.ide.matcher

import com.github.valkyrie.language.psi.ValkyrieTypes
import com.github.valkyrie.language.psi_node.ValkyrieStringNode
import com.intellij.json.json5.Json5Language
import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.LanguageInjectionPerformer
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import org.intellij.lang.regexp.RegExpLanguage

class ValkyrieInjectionContributor : LanguageInjectionContributor {
    override fun getInjection(context: PsiElement): Injection? {
        val parent = context.parent;
        if (parent is ValkyrieStringNode && context.elementType == ValkyrieTypes.STRING_TEXT) {
            val identifier = parent.identifier ?: return null;
            return tryInject(identifier.text)
        }
        return null
    }

    private fun tryInject(language: String): Injection? = when (language) {
        "re", "regex", "regexr" -> SimpleInjection(RegExpLanguage.INSTANCE, "", "", null)
        "json", "json5" -> SimpleInjection(Json5Language.INSTANCE, "", "", null)
        else -> null
    }
}

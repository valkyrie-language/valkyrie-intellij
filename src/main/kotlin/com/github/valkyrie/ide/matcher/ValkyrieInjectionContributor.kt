package com.github.valkyrie.ide.matcher

import com.github.valkyrie.language.psi_node.ValkyrieStringNode
import com.intellij.json.json5.Json5Language
import com.intellij.lang.Language
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import org.intellij.lang.regexp.RegExpLanguage

class ValkyrieInjectionContributor : LanguageInjectionContributor {
    override fun getInjection(context: PsiElement): Injection? {
        return ValkyrieInjection.tryInject(context)
    }
}

class ValkyrieInjection(private val language: String) : Injection {
    companion object {

    }

    constructor(node: ValkyrieStringNode) : this(node.identifier?.text ?: "")

    override fun getInjectedLanguageId(): String = language
    override fun getInjectedLanguage(): Language? = when (language) {
        "re", "regex" -> {
            RegExpLanguage.INSTANCE
        }

        "json", "json5" -> {
            Json5Language.INSTANCE
        }

        else -> {
            null
        }
    }

    override fun getPrefix(): String = ""
    override fun getSuffix(): String = ""
    override fun getSupportId(): String? = null
}
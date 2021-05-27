package com.github.valkyrie.ide.matcher

import com.github.valkyrie.language.psi_node.ValkyrieStringNode
import com.intellij.json.json5.Json5Language
import com.intellij.lang.Language
import com.intellij.lang.Language.ANY
import com.intellij.lang.Language.getRegisteredLanguages
import com.intellij.lang.html.HTMLLanguage
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.lang.xml.XMLLanguage
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import org.intellij.lang.regexp.RegExpLanguage

class LanguageInjector : MultiHostInjector {
    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        when (context) {
            is ValkyrieStringNode -> {
                context.injectPerform(registrar)
            }

            else -> return
        }
    }
    override fun elementsToInjectIn(): MutableList<out Class<out PsiElement>> {
        return mutableListOf(ValkyrieStringNode::class.java)
    }
}

private fun ValkyrieStringNode.injectPerform(registrar: MultiHostRegistrar) {
    val remap = when (injectLanguage) {
        "js" -> "javascript"
        "kt" -> "kotlin"
        "json5", "jsonp" -> "json"
        else -> injectLanguage
    }

    when (remap) {
        "re" -> registrar.fastRegister(RegExpLanguage.INSTANCE, this)
        "re_x" -> registrar.startInjecting(RegExpLanguage.INSTANCE)
            .addPlace("(?x)", null, this, injectRange)
            .doneInjecting()

        "json" -> registrar.fastRegister(Json5Language.INSTANCE, this)
        "xml" -> registrar.fastRegister(XMLLanguage.INSTANCE, this)
        "html" -> registrar.fastRegister(HTMLLanguage.INSTANCE, this)
        else -> {
            getRegisteredLanguages()
                .filter { it != ANY }
                .firstOrNull { it.id == injectLanguage }
                ?.let { registrar.fastRegister(it, this) }
        }
    }
}

private fun MultiHostRegistrar.fastRegister(language: Language, node: ValkyrieStringNode) {
    this.startInjecting(language)
        .addPlace(null, null, node, node.injectRange)
        .doneInjecting()
}
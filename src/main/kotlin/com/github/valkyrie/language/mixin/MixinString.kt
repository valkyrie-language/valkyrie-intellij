package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.github.valkyrie.language.psi.childrenWithLeaves
import com.github.valkyrie.language.psi.endOffset
import com.github.valkyrie.language.psi.startOffset
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.github.valkyrie.language.psi_node.ValkyrieStringNode
import com.intellij.json.json5.Json5Language
import com.intellij.json.psi.impl.JSStringLiteralEscaper
import com.intellij.lang.ASTNode
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.openapi.util.TextRange
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.util.elementType
import org.intellij.lang.regexp.RegExpLanguage

// PsiReference
open class MixinString(node: ASTNode) : ValkyrieASTBase(node), PsiLanguageInjectionHost {
    override fun getOriginalElement(): ValkyrieStringNode {
        return this as ValkyrieStringNode
    }

    fun stringStartOffset(): Int {
        return stringTextRaw().startOffset
    }

    fun stringEndOffset(): Int {
        return stringTextRaw().endOffset
    }

    fun stringMode(): String {
        val identifier = originalElement.identifier as? ValkyrieIdentifierNode ?: return ""
        return identifier.name
    }

    fun stringTextRaw(): PsiElement {
        return this.childrenWithLeaves.last {
            it.elementType == ValkyrieTypes.STRING_TEXT
        }
    }

    override fun isValidHost(): Boolean = true

    override fun updateText(text: String): PsiLanguageInjectionHost {
        return this
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return StringRaw(this)
    }


    fun registerInject(registrar: MultiHostRegistrar): Boolean {
        registrar.startInjecting(RegExpLanguage.INSTANCE)
            .addPlace(null, null, this, TextRange(0, text.length))
            .doneInjecting()
        return true
    }


}

class StringRaw(private val host: PsiLanguageInjectionHost) : LiteralTextEscaper<PsiLanguageInjectionHost>(host) {
    override fun decode(rangeInsideHost: TextRange, outChars: StringBuilder): Boolean {
        TODO("Not yet implemented")
    }

    override fun getOffsetInHost(offsetInDecoded: Int, rangeInsideHost: TextRange): Int {
        TODO("Not yet implemented")
    }

    override fun isOneLine(): Boolean {
        return host.text.contains("\n")
    }
}
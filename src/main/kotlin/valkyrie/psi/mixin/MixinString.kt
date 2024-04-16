package valkyrie.psi.mixin

import com.intellij.json.json5.Json5Language
import com.intellij.lang.ASTNode
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost
import org.intellij.lang.regexp.RegExpLanguage
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieIdentifierNode
import valkyrie.psi.node.ValkyrieString
import valkyrie.psi.node.ValkyrieStringNode


abstract class MixinString : ValkyrieElement, PsiLanguageInjectionHost, ValkyrieString {
    constructor(node: ASTNode) : super(node)

    override fun isValidHost(): Boolean {
        return identifier != null
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        TODO("Not yet implemented")
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return YggdrasilRegexEscaper(this as ValkyrieStringNode)
    }

    fun injectPerform(r: MultiHostRegistrar) {
        val id = (identifier as? ValkyrieIdentifierNode)?.name;

        when (id) {
            null -> {

            }

            "json" -> {
                val range = TextRange(1, textLength - 1);
                r.startInjecting(Json5Language.INSTANCE).addPlace(null, null, this, range).doneInjecting()
            }

            "re" -> {
                val range = TextRange(1, textLength - 1);
                r.startInjecting(RegExpLanguage.INSTANCE).addPlace(null, null, this, range).doneInjecting()
            }

            "regex" -> {
                val range = TextRange(1, textLength - 1);
                r.startInjecting(RegExpLanguage.INSTANCE).addPlace("(?x)", null, this, range).doneInjecting()
            }
        }
    }
}

private class YggdrasilRegexEscaper : LiteralTextEscaper<PsiLanguageInjectionHost> {
    private val host: ValkyrieStringNode

    constructor(host: ValkyrieStringNode) : super(host) {
        this.host = host
    }

    override fun decode(rangeInsideHost: TextRange, outChars: StringBuilder): Boolean {
        outChars.append(myHost!!.text, rangeInsideHost.startOffset, rangeInsideHost.endOffset)
        return true
    }

    override fun getOffsetInHost(offsetInDecoded: Int, rangeInsideHost: TextRange): Int {
        var offset = offsetInDecoded + rangeInsideHost.startOffset
        if (offset < rangeInsideHost.startOffset) {
            offset = rangeInsideHost.startOffset
        }
        if (offset > rangeInsideHost.endOffset) {
            offset = rangeInsideHost.endOffset
        }
        return offset
    }

    override fun isOneLine(): Boolean {
        return host.text.contains("\n")
    }
}

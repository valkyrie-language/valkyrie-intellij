package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost
import org.intellij.lang.regexp.RegExpLanguage
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieRegex
import yggdrasil.psi.node.ValkyrieRegexNode

abstract class MixinRegex(node: ASTNode) : ValkyrieElement(node), PsiLanguageInjectionHost, ValkyrieRegex {

    override fun isValidHost(): Boolean {
        return true
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        TODO("Not yet implemented")
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return YggdrasilRegexEscaper(this as ValkyrieRegexNode)
    }

    fun injectPerform(r: MultiHostRegistrar) {
        if (text.startsWith('/')) {
            val range = TextRange(1, textLength - 1);
            r.startInjecting(RegExpLanguage.INSTANCE).addPlace("(?x)", null, this, range).doneInjecting()
        } else {
            val range = TextRange(0, textLength);
            r.startInjecting(RegExpLanguage.INSTANCE).addPlace(null, null, this, range).doneInjecting()
        }
    }
}

private class YggdrasilRegexEscaper : LiteralTextEscaper<PsiLanguageInjectionHost> {
    private val host: ValkyrieRegexNode

    constructor(host: ValkyrieRegexNode) : super(host) {
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

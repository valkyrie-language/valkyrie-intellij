package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.node.ValkyrieString
import valkyrie.psi.node.ValkyrieStringNode


abstract class MixinString : ValkyrieElement, PsiLanguageInjectionHost, ValkyrieString {
    var stringHead: PsiElement = this.findChildByType(ValkyrieTypes.STRING_L)!!
    var stringBody: PsiElement? = this.findChildByType(ValkyrieTypes.STRING_TEXT)
    var stringTail: PsiElement = this.findChildByType(ValkyrieTypes.STRING_R)!!

    constructor(node: ASTNode) : super(node) {

    }

    override fun isValidHost(): Boolean {
        return identifierSafe != null
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        TODO("Not yet implemented")
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return YggdrasilRegexEscaper(this as ValkyrieStringNode)
    }

    override fun subtreeChanged() {
        stringHead = this.findChildByType(ValkyrieTypes.STRING_L)!!
        stringBody = this.findChildByType(ValkyrieTypes.STRING_TEXT)
        stringTail = this.findChildByType(ValkyrieTypes.STRING_R)!!
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

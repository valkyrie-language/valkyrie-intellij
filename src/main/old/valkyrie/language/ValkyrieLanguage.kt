package valkyrie.language

import com.intellij.lang.Language
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.v4.runtime.Token
import valkyrie.language.antlr.ValkyrieAntlrParser

private const val LANGUAGE_ID = "Valkyrie"


object ValkyrieLanguage : Language(LANGUAGE_ID) {
    init {
        PSIElementTypeFactory.defineLanguageIElementTypes(
            ValkyrieLanguage, ValkyrieAntlrParser.tokenNames, ValkyrieAntlrParser.ruleNames
        )
    }

    private fun readResolve(): Any = ValkyrieLanguage
    override fun getDisplayName(): String {
        return super.getDisplayName()
    }

    override fun getMimeTypes(): Array<String> {
        return arrayOf("text/x-valkyrie")
    }

    fun createTokenSet(vararg types: Int): TokenSet {
        val tokenIElementTypes = PSIElementTypeFactory.getTokenIElementTypes(ValkyrieLanguage)

        val elementTypes = arrayOfNulls<IElementType>(types.size)
        for (i in types.indices) {
            if (types[i] == Token.EOF) {
                elementTypes[i] = PSIElementTypeFactory.getEofElementType(ValkyrieLanguage)
            } else {
                elementTypes[i] = tokenIElementTypes[types[i]]
            }
        }

        return TokenSet.create(*elementTypes)
    }
}
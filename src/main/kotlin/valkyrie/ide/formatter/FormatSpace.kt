package valkyrie.ide.formatter

import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet
import valkyrie.ide.matcher.ValkyrieBracketMatch
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrLexer.*
import valkyrie.language.antlr.ValkyrieLexer

private val removeSpaceBefore = TokenSet.orSet(
    createTokenSet(ValkyrieLanguage, DOT, OP_PROPORTION, COLON, GENERIC_L, GENERIC_R),
    ValkyrieBracketMatch.Instance.Right,

)

private val removeSpaceNewlineBefore = TokenSet.orSet(
    createTokenSet(ValkyrieLanguage, COMMA, OP_PROPORTION)

)

private val removeSpaceAfter = TokenSet.orSet(
    createTokenSet(ValkyrieLanguage, DOT, OP_PROPORTION, GENERIC_L, GENERIC_R)
)

private val removeSpaceNewlineAfter = TokenSet.orSet(
    createTokenSet(ValkyrieLanguage, DOT, OP_PROPORTION, OP_HASH, OP_AT)
)

// 左右插入一个空格
private val spaceAroundOperator = TokenSet.orSet(
    createTokenSet(ValkyrieLanguage, KW_IN),
    ValkyrieLexer.OperatorInfix
)

private val addSpaceAfter = TokenSet.orSet(
    createTokenSet(ValkyrieLanguage, COMMA, COLON)
)

private val newlineIndentAfter = TokenSet.create()

data class FormatSpace(val commonSettings: CommonCodeStyleSettings, val spacingBuilder: SpacingBuilder) {
    companion object {
        fun create(settings: CodeStyleSettings): FormatSpace {
            val commonSettings = settings.getCommonSettings(ValkyrieLanguage)
            return FormatSpace(commonSettings, createSpacingBuilder(commonSettings))
        }

        private fun createSpacingBuilder(commonSettings: CommonCodeStyleSettings): SpacingBuilder {
            return SpacingBuilder(commonSettings)
                .after(addSpaceAfter).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                .around(spaceAroundOperator).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                .before(removeSpaceBefore).spaceIf(false)
                .before(removeSpaceNewlineBefore).spacing(0, 0, 0, false, 0)
                .after(removeSpaceAfter).spaceIf(false)
                .after(removeSpaceNewlineAfter).spacing(0, 0, 0, false, 0)
                .after(newlineIndentAfter).spacing(0, 0, 0, true, 1)
        }
    }
}
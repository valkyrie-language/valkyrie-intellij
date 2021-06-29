package valkyrie.ide.formatter

import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.tree.TokenSet
import valkyrie.ValkyrieLanguage
import valkyrie.language.psi.ValkyrieTypes.*

private val removeSpaceBefore = TokenSet.create(
    PARENTHESIS_R,
    BRACKET_R,
    COMMA,
    COLON,
    SEMICOLON,
    DOT
)

private val removeSpaceNewlineBefore = TokenSet.create(
    OP_UNTIL,
    OP_PROPORTION
)

private val removeSpaceAfter = TokenSet.create(
    BRACKET_L,
    PARENTHESIS_L,
    BRACKET_L,
)

private val removeSpaceNewlineAfter = TokenSet.create(
    OP_UNTIL,
    DOT,
    OP_PROPORTION,
    OP_AT,
    OP_HASH,
)

private val binaryOperator = TokenSet.create(
    OP_EQ, OP_TO,
    OP_ADD, OP_SUB, OP_MUL, OP_DIV, OP_MOD,
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
                // ,
                .after(COMMA).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                // k: v
                // k = v
                .around(binaryOperator).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                .before(removeSpaceBefore).spaceIf(false)
                .after(removeSpaceAfter).spaceIf(false)
                .before(removeSpaceNewlineBefore).spacing(0, 0, 0, false, 0)
                .after(removeSpaceNewlineAfter).spacing(0, 0, 0, false, 0)
                .after(newlineIndentAfter).spacing(0, 0, 0, true, 1)
        }
    }
}
package valkyrie.ide.formatter

import valkyrie.ValkyrieLanguage
import valkyrie.language.psi.ValkyrieTypes.*
import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.tree.TokenSet

private val removeSpaceBefore = TokenSet.create(
    PARENTHESIS_R, BRACKET_R, COMMA, SEMICOLON
)

private val removeSpaceAfter = TokenSet.create(
    BRACKET_L,
    PARENTHESIS_L,
    BRACKET_L,
)

private val removeSpaceNewlineBefore = TokenSet.create(
    OP_UNTIL,
)

private val removeSpaceNewlineAfter = TokenSet.create(
    OP_UNTIL,
    DOT,
    OP_PROPORTION,
    KW_MACRO,
)

data class FormatSpace(val commonSettings: CommonCodeStyleSettings, val spacingBuilder: SpacingBuilder) {
    companion object {
        fun create(settings: CodeStyleSettings): FormatSpace {
            val commonSettings = settings.getCommonSettings(ValkyrieLanguage)
            return FormatSpace(commonSettings, createSpacingBuilder(commonSettings))
        }


        private val newline_indent_after = TokenSet.create()
        private val binary_operator = TokenSet.create(OP_EQ, OP_TO)
        private val left_bracket = TokenSet.create(PARENTHESIS_L, BRACKET_L)

        private fun createSpacingBuilder(commonSettings: CommonCodeStyleSettings): SpacingBuilder {
            return SpacingBuilder(commonSettings)
                // ,
                .after(COMMA).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                // k: v
                .after(COLON).spacing(1, 1, 0, false, 0)
                // k = v
                .around(binary_operator).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
//                .after(left_bracket).spacing(0, 0, 0, false, 0)
//                .before(left_bracket).spacing(1, 1, 0, false, 0)
                .before(removeSpaceBefore).spaceIf(false)
                .after(removeSpaceAfter).spaceIf(false)
                .before(removeSpaceNewlineBefore).spacing(0, 0, 0, false, 0)
                .after(removeSpaceNewlineAfter).spacing(0, 0, 0, false, 0)
                .after(newline_indent_after).spacing(0, 0, 0, true, 1)
        }
    }
}
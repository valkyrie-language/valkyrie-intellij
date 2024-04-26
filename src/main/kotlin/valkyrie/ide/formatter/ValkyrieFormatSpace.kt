package valkyrie.ide.formatter

import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.tree.TokenSet
import valkyrie.ide.matcher.ValkyrieBraceMatch
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.ValkyrieTypes.*

private val removeSpaceNewlineBefore = TokenSet.orSet(
    TokenSet.create(COMMA, NAME_SPLIT)
)

private val removeSpaceBefore = TokenSet.orSet(
    TokenSet.create(DOT, COLON),
    ValkyrieBraceMatch.Right,
)

private val removeSpaceAfter = TokenSet.orSet(
    ValkyrieBraceMatch.Left,
)

private val removeSpaceNewlineAfter = TokenSet.orSet(
//    ValkyrieLanguage.createTokenSet(DOT, OP_PROPORTION, OP_HASH, OP_AT)
)

// 左右插入一个空格
private val spaceAroundOperator = TokenSet.orSet(
    TokenSet.create(OP_ARROW1)
//    ValkyrieLexer.OperatorInfix
)

private val addSpaceAfter = TokenSet.orSet(
    TokenSet.create(COMMA),
    TokenSet.create(KW_YIELD, KW_RETURN, KW_RESUME, KW_CONTINUE, KW_BREAK)
)

private val newlineIndentAfter = TokenSet.create()

data class ValkyrieFormatSpace(val commonSettings: CommonCodeStyleSettings, val spacingBuilder: SpacingBuilder) {
    companion object {
        fun create(settings: CodeStyleSettings): ValkyrieFormatSpace {
            val commonSettings = settings.getCommonSettings(ValkyrieLanguage)
            return ValkyrieFormatSpace(commonSettings, createSpacingBuilder(commonSettings))
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
package com.github.valkyrie.ide.formatter

import com.github.valkyrie.ValkyrieLanguage
import com.github.valkyrie.language.psi.ValkyrieTypes.*
import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.tree.TokenSet

data class ValkyrieFormatSpace(
    val commonSettings: CommonCodeStyleSettings,
    val spacingBuilder: SpacingBuilder,
) {
    companion object {
        fun create(settings: CodeStyleSettings): ValkyrieFormatSpace {
            val commonSettings = settings.getCommonSettings(ValkyrieLanguage.INSTANCE)
            return ValkyrieFormatSpace(commonSettings, createSpacingBuilder(commonSettings))
        }

        private val remove_space_before = TokenSet.create(
            PARENTHESIS_R,
            BRACKET_R,
            COMMA,
            SEMICOLON
        )
        private val remove_space_after = TokenSet.create(
            PARENTHESIS_L,
            BRACKET_L,
            COLON,
        )
        private val remove_space_newline_after = TokenSet.create(
            BRACKET_L,
            DOT,
            DOLLAR,
            STAR,
            HYPHEN,
            PROPORTION,
            AT
        )
        private val remove_space_newline_before = TokenSet.create(
            BRACKET_R,
        )
        private val newline_indent_after = TokenSet.create(TO)

        private val separators = TokenSet.create(COMMA, SEMICOLON)

        private fun createSpacingBuilder(commonSettings: CommonCodeStyleSettings): SpacingBuilder {
            val custom = SpacingBuilder(commonSettings)
                // ,
                .after(separators).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                // k: v
                .after(COLON).spacing(1, 1, 0, false, 0)
                // k = v
                .around(EQ).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
            // SpacingBuilder { }
            // .before(PROPERTIES_BLOCK).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)

            return custom
                .before(remove_space_before).spaceIf(false)
                .after(remove_space_after).spaceIf(false)
                .before(remove_space_newline_before).spacing(0, 0, 0, false, 0)
                .after(remove_space_newline_after).spacing(0, 0, 0, false, 0)
                .after(newline_indent_after).spacing(0, 0, 0, true, 1)
        }
    }
}
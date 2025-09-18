package valkyrie.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import valkyrie.language.dialect_std.ValkyrieLanguage
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * Valkyrie 代码格式化构建器
 */
class ValkyrieFormatBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val element = formattingContext.psiElement
        val settings = formattingContext.codeStyleSettings
        val containingFile = formattingContext.containingFile

        val spacingBuilder = createSpacingBuilder(settings)
        val block = ValkyrieFormatBlock(
            element.node,
            null,
            Indent.getNoneIndent(),
            null,
            spacingBuilder
        )

        return FormattingModelProvider.createFormattingModelForPsiFile(
            containingFile,
            block,
            settings
        )
    }

    private fun createSpacingBuilder(settings: CodeStyleSettings): SpacingBuilder {
        val valkyrieSettings = settings.getCustomSettings(ValkyrieCodeStyleSettings::class.java)
        return SpacingBuilder(settings, ValkyrieLanguage)
            // 大括号前后的空格
            .between(ValkyrieTokenTypes.BRACE_L, ValkyrieTokenTypes.BRACE_R)
            .spacing(0, 0, 0, false, 0)
            // 【保留】处理非空的大括号
            // 当 { 和 } 不直接相邻时（因为中间有其他代码），上面的规则不生效，
            // 下面这两条通用规则就会生效。
            .after(ValkyrieTokenTypes.BRACE_L).lineBreakInCode()
            .before(ValkyrieTokenTypes.BRACE_R).lineBreakInCode()

            // 小括号的空格
            .before(ValkyrieTokenTypes.PARENTHESIS_L).spaces(0)
            .after(ValkyrieTokenTypes.PARENTHESIS_L).spaces(0)
            .before(ValkyrieTokenTypes.PARENTHESIS_R).spaces(0)
            .after(ValkyrieTokenTypes.PARENTHESIS_R).spaces(0)

            // 方括号的空格
            .before(ValkyrieTokenTypes.BRACKET_L).spaces(0)
            .after(ValkyrieTokenTypes.BRACKET_L).spaces(0)
            .before(ValkyrieTokenTypes.BRACKET_R).spaces(0)
            .after(ValkyrieTokenTypes.BRACKET_R).spaces(0)

            // 冒号前后的空格
            .before(ValkyrieTokenTypes.COLON).spaces(0)
            .after(ValkyrieTokenTypes.COLON).spaces(1)

            // 分号前后的空格
            .before(ValkyrieTokenTypes.SEMICOLON).spaces(0)
            .after(ValkyrieTokenTypes.SEMICOLON).lineBreakInCode()

            // 逗号后的空格
            .before(ValkyrieTokenTypes.COMMA).spaces(0)
            .after(ValkyrieTokenTypes.COMMA).spaces(1)

            // 点号前后不加空格
            .around(ValkyrieTokenTypes.DOT).spaces(0)

            // 箭头前后的空格
            .around(ValkyrieTokenTypes.ARROW).spaces(1)

            // 赋值操作符前后的空格
            .around(ValkyrieTokenTypes.ASSIGN).spaces(1)
            .around(ValkyrieTokenTypes.PLUS_ASSIGN).spaces(1)
            .around(ValkyrieTokenTypes.MINUS_ASSIGN).spaces(1)
            .around(ValkyrieTokenTypes.MULTIPLY_ASSIGN).spaces(1)
            .around(ValkyrieTokenTypes.DIVIDE_ASSIGN).spaces(1)

            // 算术操作符前后的空格
            .around(ValkyrieTokenTypes.PLUS).spaces(1)
            .around(ValkyrieTokenTypes.MINUS).spaces(1)
            .around(ValkyrieTokenTypes.MULTIPLY).spaces(1)
            .around(ValkyrieTokenTypes.SLASH).spaces(1)
            .around(ValkyrieTokenTypes.PERCENT).spaces(1)
            .around(ValkyrieTokenTypes.POWER).spaces(1)

            // 比较操作符
            .around(ValkyrieTokenTypes.EQUAL).spaces(1)
            .around(ValkyrieTokenTypes.NOT_EQUAL).spaces(1)
            .around(ValkyrieTokenTypes.ANGLE_L).spaces(1)
            .around(ValkyrieTokenTypes.LESS_EQUAL).spaces(1)
            .around(ValkyrieTokenTypes.ANGLE_R).spaces(1)
            .around(ValkyrieTokenTypes.GREATER_EQUAL).spaces(1)

            // 逻辑操作符
            .around(ValkyrieTokenTypes.LOGIC_AND).spaces(1)
            .around(ValkyrieTokenTypes.LOGIC_OR).spaces(1)

            // 关键字后的空格 - 使用spaceIf避免重复添加空格
            .after(ValkyrieTokenTypes.IF).spaceIf(true)
            .after(ValkyrieTokenTypes.LOOP).spaceIf(true)
            .after(ValkyrieTokenTypes.WHILE).spaceIf(true)
            .after(ValkyrieTokenTypes.MATCH).spaceIf(true)
            .after(ValkyrieTokenTypes.RETURN).spaceIf(true)
            .after(ValkyrieTokenTypes.LET).spaceIf(true)
            .after(ValkyrieTokenTypes.MICRO).spaceIf(true)
            .after(ValkyrieTokenTypes.MACRO).spaceIf(true)
            .between(ValkyrieTokenTypes.CLASS, ValkyrieTokenTypes.SYMBOL).spacing(1, 1, 0, false, 0)
            .after(ValkyrieTokenTypes.UNION).spaceIf(true)
// --- 【新增】为 namespace 添加具体的间距规则 ---

// 规则 1: 处理 `namespace!` 的情况，强制 0 空格
            .between(ValkyrieTokenTypes.NAMESPACE, ValkyrieTokenTypes.WOW)
            .spacing(0, 0, 0, false, 0)

// 规则 2: 处理 `! id` 的情况，强制 1 空格
// 假设你的 id token 类型是 IDENTIFIER，请替换成你实际的类型
            .between(ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.SYMBOL)
            .spaces(1)

// 规则 3: 处理 `namespace id` 的情况 (没有 !)，强制 1 空格
            .between(ValkyrieTokenTypes.NAMESPACE, ValkyrieTokenTypes.SYMBOL)
            .spaces(1)
    }

    override fun getRangeAffectingIndent(file: PsiFile, offset: Int, elementAtOffset: ASTNode): TextRange? {
        return null
    }
}


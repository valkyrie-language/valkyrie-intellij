package valkyrie.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.parsers.ValkyrieTypes

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
        return SpacingBuilder(settings, ValkyrieLanguage.INSTANCE)
            // 大括号前后的空格
            .between(ValkyrieTypes.BRACE_L, ValkyrieTypes.BRACE_R)
            .spacing(0, 0, 0, false, 0)
            // 【保留】处理非空的大括号
            // 当 { 和 } 不直接相邻时（因为中间有其他代码），上面的规则不生效，
            // 下面这两条通用规则就会生效。
            .after(ValkyrieTypes.BRACE_L).lineBreakInCode()
            .before(ValkyrieTypes.BRACE_R).lineBreakInCode()

            // 小括号的空格
            .before(ValkyrieTypes.PARENTHESIS_L).spaces(0)
            .after(ValkyrieTypes.PARENTHESIS_L).spaces(0)
            .before(ValkyrieTypes.PARENTHESIS_R).spaces(0)
            .after(ValkyrieTypes.PARENTHESIS_R).spaces(0)

            // 方括号的空格
            .before(ValkyrieTypes.BRACKET_L).spaces(0)
            .after(ValkyrieTypes.BRACKET_L).spaces(0)
            .before(ValkyrieTypes.BRACKET_R).spaces(0)
            .after(ValkyrieTypes.BRACKET_R).spaces(0)

            // 冒号前后的空格
            .before(ValkyrieTypes.COLON).spaces(0)
            .after(ValkyrieTypes.COLON).spaces(1)

            // 分号前后的空格
            .before(ValkyrieTypes.SEMICOLON).spaces(0)
            .after(ValkyrieTypes.SEMICOLON).lineBreakInCode()

            // 逗号后的空格
            .before(ValkyrieTypes.COMMA).spaces(0)
            .after(ValkyrieTypes.COMMA).spaces(1)

            // 点号前后不加空格
            .around(ValkyrieTypes.DOT).spaces(0)

            // 箭头前后的空格
            .around(ValkyrieTypes.ARROW).spaces(1)

            // 赋值操作符前后的空格
            .around(ValkyrieTypes.ASSIGN).spaces(1)
            .around(ValkyrieTypes.PLUS_ASSIGN).spaces(1)
            .around(ValkyrieTypes.MINUS_ASSIGN).spaces(1)
            .around(ValkyrieTypes.MULTIPLY_ASSIGN).spaces(1)
            .around(ValkyrieTypes.DIVIDE_ASSIGN).spaces(1)

            // 算术操作符前后的空格
            .around(ValkyrieTypes.PLUS).spaces(1)
            .around(ValkyrieTypes.MINUS).spaces(1)
            .around(ValkyrieTypes.MULTIPLY).spaces(1)
            .around(ValkyrieTypes.SLASH).spaces(1)
            .around(ValkyrieTypes.PERCENT).spaces(1)
            .around(ValkyrieTypes.POWER).spaces(1)

            // 比较操作符
            .around(ValkyrieTypes.EQUAL).spaces(1)
            .around(ValkyrieTypes.NOT_EQUAL).spaces(1)
            .around(ValkyrieTypes.ANGLE_L).spaces(1)
            .around(ValkyrieTypes.LESS_EQUAL).spaces(1)
            .around(ValkyrieTypes.ANGLE_R).spaces(1)
            .around(ValkyrieTypes.GREATER_EQUAL).spaces(1)

            // 逻辑操作符
            .around(ValkyrieTypes.LOGIC_AND).spaces(1)
            .around(ValkyrieTypes.LOGIC_OR).spaces(1)

            // 关键字后的空格 - 使用spaceIf避免重复添加空格
            .after(ValkyrieTypes.IF).spaceIf(true)
            .after(ValkyrieTypes.LOOP).spaceIf(true)
            .after(ValkyrieTypes.WHILE).spaceIf(true)
            .after(ValkyrieTypes.MATCH).spaceIf(true)
            .after(ValkyrieTypes.RETURN).spaceIf(true)
            .after(ValkyrieTypes.LET).spaceIf(true)
            .after(ValkyrieTypes.MICRO).spaceIf(true)
            .after(ValkyrieTypes.MACRO).spaceIf(true)
            .between(ValkyrieTypes.CLASS, ValkyrieTypes.SYMBOL).spacing(1, 1, 0, false, 0)
            .after(ValkyrieTypes.UNION).spaceIf(true)
// --- 【新增】为 namespace 添加具体的间距规则 ---

// 规则 1: 处理 `namespace!` 的情况，强制 0 空格
            .between(ValkyrieTypes.NAMESPACE, ValkyrieTypes.WOW)
            .spacing(0, 0, 0, false, 0)

// 规则 2: 处理 `! id` 的情况，强制 1 空格
// 假设你的 id token 类型是 IDENTIFIER，请替换成你实际的类型
            .between(ValkyrieTypes.WOW, ValkyrieTypes.SYMBOL)
            .spaces(1)

// 规则 3: 处理 `namespace id` 的情况 (没有 !)，强制 1 空格
            .between(ValkyrieTypes.NAMESPACE, ValkyrieTypes.SYMBOL)
            .spaces(1)
    }

    override fun getRangeAffectingIndent(file: PsiFile, offset: Int, elementAtOffset: ASTNode): TextRange? {
        return null
    }
}


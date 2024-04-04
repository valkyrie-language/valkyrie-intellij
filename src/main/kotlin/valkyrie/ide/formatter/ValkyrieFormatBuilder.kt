package valkyrie.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Valkyrie 代码格式化构建器
 */
class ValkyrieFormatBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val element = formattingContext.psiElement
        val settings = formattingContext.codeStyleSettings
        val containingFile = formattingContext.containingFile

        val spacingBuilder = createSpacingBuilder(settings)
        val block = ValkyrieBlock(
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
            .between(ValkyrieTokenTypes.CLASS, ValkyrieTokenTypes.IDENTIFIER).spacing(1, 1, 0, false, 0)
            .after(ValkyrieTokenTypes.UNION).spaceIf(true)
// --- 【新增】为 namespace 添加具体的间距规则 ---

// 规则 1: 处理 `namespace!` 的情况，强制 0 空格
            .between(ValkyrieTokenTypes.NAMESPACE, ValkyrieTokenTypes.WOW)
            .spacing(0, 0, 0, false, 0)

// 规则 2: 处理 `! id` 的情况，强制 1 空格
// 假设你的 id token 类型是 IDENTIFIER，请替换成你实际的类型
            .between(ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.IDENTIFIER)
            .spaces(1)

// 规则 3: 处理 `namespace id` 的情况 (没有 !)，强制 1 空格
            .between(ValkyrieTokenTypes.NAMESPACE, ValkyrieTokenTypes.IDENTIFIER)
            .spaces(1)
    }

    override fun getRangeAffectingIndent(file: PsiFile, offset: Int, elementAtOffset: ASTNode): TextRange? {
        return null
    }
}

/**
 * Valkyrie 格式化块
 */
class ValkyrieBlock(
    private val node: ASTNode,
    private val alignment: Alignment?,
    private val indent: Indent,
    private val wrap: Wrap?,
    private val spacingBuilder: SpacingBuilder
) : ASTBlock {

    override fun getNode(): ASTNode = node

    override fun getTextRange(): TextRange = node.textRange

    override fun getSubBlocks(): List<Block> {
        val blocks = mutableListOf<Block>()

        var child = node.firstChildNode
        while (child != null) {
            if (child.textLength > 0) {
                val childIndent = getChildIndent(child)
                val childAlignment = getChildAlignment(child)
                val childWrap = getChildWrap(child)

                blocks.add(
                    ValkyrieBlock(
                        child,
                        childAlignment,
                        childIndent,
                        childWrap,
                        spacingBuilder
                    )
                )
            }
            child = child.treeNext
        }

        return blocks
    }

    private fun getChildIndent(child: ASTNode): Indent {
        return when (node.elementType) {
            ValkyrieElementTypes.OBJECT_BODY,
            ValkyrieElementTypes.UNION_BODY,
            ValkyrieElementTypes.FUNCTION_BODY,
            ValkyrieElementTypes.USING_BODY -> {
                // 对于object body、union body、function body和using body中的子元素，需要缩进
                when (child.elementType) {
                    ValkyrieTokenTypes.BRACE_L, ValkyrieTokenTypes.BRACE_R -> Indent.getNoneIndent()
                    else -> Indent.getNormalIndent()
                }
            }

            ValkyrieElementTypes.IF_STATEMENT,
            ValkyrieElementTypes.ELSE_CLAUSE,
            ValkyrieElementTypes.EACH_STATEMENT,
            ValkyrieElementTypes.WHILE_STATEMENT,
            ValkyrieElementTypes.MATCH_STATEMENT,
            ValkyrieElementTypes.LOOP_STATEMENT -> Indent.getNormalIndent()
            // FLAGS 相关的缩进处理
            ValkyrieElementTypes.FLAGS_STATEMENT -> {
                when (child.elementType) {
                    ValkyrieElementTypes.FLAGS_ITEM -> Indent.getNormalIndent()
                    else -> Indent.getNoneIndent()
                }
            }

            else -> Indent.getNoneIndent()
        }
    }

    private fun getChildAlignment(child: ASTNode): Alignment? {
        return when (node.elementType) {
            ValkyrieElementTypes.OBJECT_BODY,
            ValkyrieElementTypes.UNION_BODY,
            ValkyrieElementTypes.USING_BODY -> {
                when (child.elementType) {
                    ValkyrieElementTypes.FIELD_DECLARATION,
                    ValkyrieElementTypes.METHOD_DECLARATION,
                    ValkyrieElementTypes.DOMAIN_DECLARATION,
                    ValkyrieElementTypes.USING_ITEM -> Alignment.createAlignment()

                    else -> null
                }
            }

            ValkyrieElementTypes.TERM_PARAMETER_LIST -> {
                when (child.elementType) {
                    ValkyrieElementTypes.TERM_PARAMETER_ITEM -> Alignment.createAlignment()
                    else -> null
                }
            }
            // FLAGS 相关的对齐处理
            ValkyrieElementTypes.FLAGS_STATEMENT -> {
                when (child.elementType) {
                    ValkyrieElementTypes.FLAGS_ITEM -> Alignment.createAlignment()
                    else -> null
                }
            }

            else -> null
        }
    }

    private fun getChildWrap(child: ASTNode): Wrap? {
        return null
    }

    override fun getWrap(): Wrap? = wrap

    override fun getIndent(): Indent = indent

    override fun getAlignment(): Alignment? = alignment

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        return when (node.elementType) {
            ValkyrieElementTypes.OBJECT_BODY,
            ValkyrieElementTypes.UNION_BODY,
            ValkyrieElementTypes.FUNCTION_BODY -> ChildAttributes(Indent.getNormalIndent(), null)

            ValkyrieElementTypes.TERM_PARAMETER_LIST -> {
                if (newChildIndex > 0) {
                    ChildAttributes(Indent.getContinuationIndent(), Alignment.createAlignment())
                } else {
                    ChildAttributes(Indent.getNoneIndent(), null)
                }
            }
            // FLAGS 相关的子属性处理
            ValkyrieElementTypes.FLAGS_STATEMENT -> ChildAttributes(Indent.getNormalIndent(), Alignment.createAlignment())
            else -> ChildAttributes(Indent.getNoneIndent(), null)
        }
    }

    override fun isIncomplete(): Boolean = false

    override fun isLeaf(): Boolean = node.firstChildNode == null
}
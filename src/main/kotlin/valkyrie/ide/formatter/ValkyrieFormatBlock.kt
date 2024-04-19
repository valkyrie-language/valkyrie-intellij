package valkyrie.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * Valkyrie 格式化块
 */
class ValkyrieFormatBlock(val n: ASTNode, val a: Alignment?, val i: Indent, val w: Wrap?, val s: SpacingBuilder) : ASTBlock {
    override fun getNode(): ASTNode = n

    override fun getTextRange(): TextRange = n.textRange

    override fun getSubBlocks(): List<Block> {
        val blocks = mutableListOf<Block>()
        var child = n.firstChildNode
        while (child != null) {
            if (child.textLength > 0) {
                val childIndent = getChildIndent(child)
                val childAlignment = getChildAlignment(child)
                val childWrap = getChildWrap(child)
                blocks.add(ValkyrieFormatBlock(child, childAlignment, childIndent, childWrap, s))
            }
            child = child.treeNext
        }
        return blocks
    }

    private fun getChildIndent(child: ASTNode): Indent {
        return when (n.elementType) {
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
        return when (n.elementType) {
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

    override fun getWrap(): Wrap? = w

    override fun getIndent(): Indent = i

    override fun getAlignment(): Alignment? = a

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return s.getSpacing(this, child1, child2)
    }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        return when (n.elementType) {
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
            ValkyrieElementTypes.FLAGS_STATEMENT -> ChildAttributes(
                Indent.getNormalIndent(),
                Alignment.createAlignment()
            )

            else -> ChildAttributes(Indent.getNoneIndent(), null)
        }
    }

    override fun isIncomplete(): Boolean = false

    override fun isLeaf(): Boolean = n.firstChildNode == null
}
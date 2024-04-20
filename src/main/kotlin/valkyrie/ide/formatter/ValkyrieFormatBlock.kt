package valkyrie.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import valkyrie.psi.parsers.ValkyrieTypes

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
            ValkyrieTypes.OBJECT_BODY,
            ValkyrieTypes.UNION_BODY,
            ValkyrieTypes.FUNCTION_BODY,
            ValkyrieTypes.USING_BODY -> {
                // 对于object body、union body、function body和using body中的子元素，需要缩进
                when (child.elementType) {
                    ValkyrieTypes.BRACE_L, ValkyrieTypes.BRACE_R -> Indent.getNoneIndent()
                    else -> Indent.getNormalIndent()
                }
            }

            ValkyrieTypes.IF_STATEMENT,
            ValkyrieTypes.ELSE_CLAUSE,
            ValkyrieTypes.EACH_STATEMENT,
            ValkyrieTypes.WHILE_STATEMENT,
            ValkyrieTypes.MATCH_STATEMENT,
            ValkyrieTypes.LOOP_STATEMENT -> Indent.getNormalIndent()

            ValkyrieTypes.FLAGS_STATEMENT -> {
                when (child.elementType) {
                    ValkyrieTypes.FLAGS_ITEM -> Indent.getNormalIndent()
                    else -> Indent.getNoneIndent()
                }
            }

            else -> Indent.getNoneIndent()
        }
    }

    private fun getChildAlignment(child: ASTNode): Alignment? {
        return when (n.elementType) {
            ValkyrieTypes.OBJECT_BODY,
            ValkyrieTypes.UNION_BODY,
            ValkyrieTypes.USING_BODY -> {
                when (child.elementType) {
                    ValkyrieTypes.FIELD_DECLARATION,
                    ValkyrieTypes.METHOD_DECLARATION,
                    ValkyrieTypes.DOMAIN_DECLARATION,
                    ValkyrieTypes.USING_ITEM -> Alignment.createAlignment()

                    else -> null
                }
            }

            ValkyrieTypes.TERM_PARAMETER_LIST -> {
                when (child.elementType) {
                    ValkyrieTypes.TERM_PARAMETER_ITEM -> Alignment.createAlignment()
                    else -> null
                }
            }
            // FLAGS 相关的对齐处理
            ValkyrieTypes.FLAGS_STATEMENT -> {
                when (child.elementType) {
                    ValkyrieTypes.FLAGS_ITEM -> Alignment.createAlignment()
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
            ValkyrieTypes.OBJECT_BODY,
            ValkyrieTypes.UNION_BODY,
            ValkyrieTypes.FUNCTION_BODY -> ChildAttributes(Indent.getNormalIndent(), null)

            ValkyrieTypes.TERM_PARAMETER_LIST -> {
                if (newChildIndex > 0) {
                    ChildAttributes(Indent.getContinuationIndent(), Alignment.createAlignment())
                } else {
                    ChildAttributes(Indent.getNoneIndent(), null)
                }
            }
            // FLAGS 相关的子属性处理
            ValkyrieTypes.FLAGS_STATEMENT -> ChildAttributes(
                Indent.getNormalIndent(),
                Alignment.createAlignment()
            )

            else -> ChildAttributes(Indent.getNoneIndent(), null)
        }
    }

    override fun isIncomplete(): Boolean = false

    override fun isLeaf(): Boolean = n.firstChildNode == null
}
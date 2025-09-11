package valkyrie.psi

import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguage

/**
 * Valkyrie PSI 元素类型
 */
class ValkyrieElementType(debugName: String) : IElementType(debugName, ValkyrieLanguage.INSTANCE) {
    override fun toString(): String = "ValkyrieElementType." + super.toString()
}

/**
 * Valkyrie PSI 元素类型定义
 */
object ValkyrieElementTypes {
    // 文件根节点
    @JvmField val FILE = ValkyrieElementType("FILE")
    
    // 语句
    @JvmField val LET_STATEMENT = ValkyrieElementType("LET_STATEMENT")
    @JvmField val NAMESPACE_STATEMENT = ValkyrieElementType("NAMESPACE_STATEMENT")
    @JvmField val USING_STATEMENT = ValkyrieElementType("USING_STATEMENT")
    @JvmField val EXPRESSION_STATEMENT = ValkyrieElementType("EXPRESSION_STATEMENT")
    @JvmField val BLOCK_STATEMENT = ValkyrieElementType("BLOCK_STATEMENT")
    
    // 表达式
    @JvmField val IDENTIFIER_EXPRESSION = ValkyrieElementType("IDENTIFIER_EXPRESSION")
    @JvmField val LITERAL_EXPRESSION = ValkyrieElementType("LITERAL_EXPRESSION")
    @JvmField val BINARY_EXPRESSION = ValkyrieElementType("BINARY_EXPRESSION")
    @JvmField val UNARY_EXPRESSION = ValkyrieElementType("UNARY_EXPRESSION")
    @JvmField val PARENTHESIZED_EXPRESSION = ValkyrieElementType("PARENTHESIZED_EXPRESSION")
    
    // 模式
    @JvmField val IDENTIFIER_PATTERN = ValkyrieElementType("IDENTIFIER_PATTERN")
    @JvmField val MUTABLE_PATTERN = ValkyrieElementType("MUTABLE_PATTERN")
    
    // 类型
    @JvmField val TYPE_REFERENCE = ValkyrieElementType("TYPE_REFERENCE")
    
    // 其他
    @JvmField val PARAMETER_LIST = ValkyrieElementType("PARAMETER_LIST")
    @JvmField val ARGUMENT_LIST = ValkyrieElementType("ARGUMENT_LIST")
    @JvmField val QUALIFIED_NAME = ValkyrieElementType("QUALIFIED_NAME")
}
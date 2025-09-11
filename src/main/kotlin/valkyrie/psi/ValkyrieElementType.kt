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
    @JvmField
    val FILE = ValkyrieElementType("FILE")

    // 通用类型
    @JvmField
    val STATEMENT = ValkyrieElementType("STATEMENT")
    @JvmField
    val EXPRESSION = ValkyrieElementType("EXPRESSION")
    @JvmField
    val PATTERN = ValkyrieElementType("PATTERN")

    // 语句
    @JvmField
    val LET_STATEMENT = ValkyrieElementType("LET_STATEMENT")
    @JvmField
    val CLASS_STATEMENT = ValkyrieElementType("CLASS_STATEMENT")
    @JvmField
    val UNION_STATEMENT = ValkyrieElementType("UNION_STATEMENT")
    @JvmField
    val TRAIT_STATEMENT = ValkyrieElementType("TRAIT_STATEMENT")
    @JvmField
    val NAMESPACE_STATEMENT = ValkyrieElementType("NAMESPACE_STATEMENT")
    @JvmField
    val NAMESPACE_PATH = ValkyrieElementType("NAMESPACE_PATH")
    @JvmField
    val USING_STATEMENT = ValkyrieElementType("USING_STATEMENT")
    @JvmField
    val EXPRESSION_STATEMENT = ValkyrieElementType("EXPRESSION_STATEMENT")
    @JvmField
    val UNTIL_STATEMENT = ValkyrieElementType("UNTIL_STATEMENT")
    @JvmField
    val MATCH_STATEMENT = ValkyrieElementType("MATCH_STATEMENT")
    @JvmField
    val MATCH_CASE = ValkyrieElementType("MATCH_CASE")
    @JvmField
    val CATCH_STATEMENT = ValkyrieElementType("CATCH_STATEMENT")
    @JvmField
    val TRY_STATEMENT = ValkyrieElementType("TRY_STATEMENT")
    @JvmField
    val WHEN_CLAUSE = ValkyrieElementType("WHEN_CLAUSE")

    @JvmField
    val BLOCK_STATEMENT = ValkyrieElementType("BLOCK_STATEMENT")
    
    // 专用的body类型
    @JvmField
    val OBJECT_BODY = ValkyrieElementType("OBJECT_BODY")
    @JvmField
    val UNION_BODY = ValkyrieElementType("UNION_BODY")
    @JvmField
    val VARIANT_BODY = ValkyrieElementType("VARIANT_BODY")
    @JvmField
    val BLOCK_BODY = ValkyrieElementType("BLOCK_BODY")

    // 表达式
    @JvmField
    val IDENTIFIER_NODE = ValkyrieElementType("IDENTIFIER_NODE")
    @JvmField
    val LITERAL_EXPRESSION = ValkyrieElementType("LITERAL_EXPRESSION")
    @JvmField
    val BINARY_EXPRESSION = ValkyrieElementType("BINARY_EXPRESSION")
    @JvmField
    val UNARY_EXPRESSION = ValkyrieElementType("UNARY_EXPRESSION")
    @JvmField
    val PARENTHESIZED_EXPRESSION = ValkyrieElementType("PARENTHESIZED_EXPRESSION")
    @JvmField
    val CALL_EXPRESSION = ValkyrieElementType("CALL_EXPRESSION")
    @JvmField
    val GENERIC_CALL_EXPRESSION = ValkyrieElementType("GENERIC_CALL_EXPRESSION")
    @JvmField
    val POSTFIX_EXPRESSION = ValkyrieElementType("POSTFIX_EXPRESSION")
    @JvmField
    val DOT_EXPRESSION = ValkyrieElementType("DOT_EXPRESSION")
    @JvmField
    val TRAILING_CLOSURE_EXPRESSION = ValkyrieElementType("TRAILING_CLOSURE_EXPRESSION")

    @JvmField
    val LABEL_STATEMENT = ValkyrieElementType("LABEL_STATEMENT")

    @JvmField
    val RETURN_STATEMENT = ValkyrieElementType("RETURN_STATEMENT")
    @JvmField
    val BREAK_STATEMENT = ValkyrieElementType("BREAK_STATEMENT")
    @JvmField
    val CONTINUE_STATEMENT = ValkyrieElementType("CONTINUE_STATEMENT")
    @JvmField
    val YIELD_STATEMENT = ValkyrieElementType("YIELD_STATEMENT")
    @JvmField
    val RAISE_STATEMENT = ValkyrieElementType("RAISE_STATEMENT")

    @JvmField
    val MUTABLE_PATTERN = ValkyrieElementType("MUTABLE_PATTERN")

    // 类型
    @JvmField
    val TYPE_REFERENCE = ValkyrieElementType("TYPE_REFERENCE")
    @JvmField
    val UNION_TYPE = ValkyrieElementType("UNION_TYPE")
    @JvmField
    val INTERSECTION_TYPE = ValkyrieElementType("INTERSECTION_TYPE")

    // Class 和 Union 内部结构
    @JvmField
    val FIELD_DECLARATION = ValkyrieElementType("FIELD_DECLARATION")
    @JvmField
    val METHOD_DECLARATION = ValkyrieElementType("METHOD_DECLARATION")
    @JvmField
    val INSTANCE_METHOD_DECLARATION = ValkyrieElementType("INSTANCE_METHOD_DECLARATION")
    @JvmField
    val STATIC_METHOD_DECLARATION = ValkyrieElementType("STATIC_METHOD_DECLARATION")
    @JvmField
    val DOMAIN_DECLARATION = ValkyrieElementType("DOMAIN_DECLARATION")
    @JvmField
    val UNION_VARIANT = ValkyrieElementType("UNION_VARIANT")

    // 注解节点（统一管理attributes和modifiers）
    @JvmField
    val ANNOTATION_NODE = ValkyrieElementType("ANNOTATION_NODE")
    
    // 修饰符
    @JvmField
    val MODIFIER_NODE = ValkyrieElementType("MODIFIER_NODE")
    @JvmField
    val MODIFIER_LIST = ValkyrieElementType("MODIFIER_LIST")
    
    // 其他
    @JvmField
    val ATTRIBUTE = ValkyrieElementType("ATTRIBUTE")
    @JvmField
    val ATTRIBUTE_LIST = ValkyrieElementType("ATTRIBUTE_LIST")
    @JvmField
    val MACRO_CALL = ValkyrieElementType("MACRO_CALL")
    @JvmField
    val ATTRIBUTE_ARGS = ValkyrieElementType("ATTRIBUTE_ARGS")
    
    // 其他
    @JvmField val PARAMETER_LIST = ValkyrieElementType("PARAMETER_LIST")
    @JvmField val PARAMETER = ValkyrieElementType("PARAMETER")
    @JvmField val ARGUMENT_LIST = ValkyrieElementType("ARGUMENT_LIST")
    @JvmField val QUALIFIED_NAME = ValkyrieElementType("QUALIFIED_NAME")
    @JvmField val GENERIC_PARAMETER_LIST = ValkyrieElementType("GENERIC_PARAMETER_LIST")
    
    // 注释
    @JvmField val DOC_COMMENT = ValkyrieElementType("DOC_COMMENT")
}
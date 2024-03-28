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

    @JvmField
    val TUPLE_PATTERN = ValkyrieElementType("TUPLE_PATTERN")

    @JvmField
    val NAMED_TUPLE_PATTERN = ValkyrieElementType("NAMED_TUPLE_PATTERN")

    @JvmField
    val STRUCT_PATTERN = ValkyrieElementType("STRUCT_PATTERN")

    @JvmField
    val DICT_PATTERN = ValkyrieElementType("DICT_PATTERN")

    @JvmField
    val ARRAY_PATTERN = ValkyrieElementType("ARRAY_PATTERN")

    @JvmField
    val OBJECT_PATTERN = ValkyrieElementType("OBJECT_PATTERN")

    // 语句
    @JvmField
    val LET_STATEMENT = ValkyrieElementType("LET_STATEMENT")

    @JvmField
    val CLASS_STATEMENT = ValkyrieElementType("CLASS_STATEMENT")

    @JvmField
    val NEURAL_STATEMENT = ValkyrieElementType("NEURAL_STATEMENT")

    @JvmField
    val WIDGET_STATEMENT = ValkyrieElementType("WIDGET_STATEMENT")

    @JvmField
    val SINGLETON_STATEMENT = ValkyrieElementType("SINGLETON_STATEMENT")

    @JvmField
    val UNION_STATEMENT = ValkyrieElementType("UNION_STATEMENT")

    @JvmField
    val UNITY_STATEMENT = ValkyrieElementType("UNITY_STATEMENT")

    @JvmField
    val FLAGS_STATEMENT = ValkyrieElementType("FLAGS_STATEMENT")

    @JvmField
    val EIDOS_STATEMENT = ValkyrieElementType("ENUMS_STATEMENT")


    @JvmField
    val TRAIT_STATEMENT = ValkyrieElementType("TRAIT_STATEMENT")

    @JvmField
    val TRAIT_ALIAS = ValkyrieElementType("TRAIT_ALIAS")

    @JvmField
    val IMPLY_STATEMENT = ValkyrieElementType("IMPLY_STATEMENT")

    @JvmField
    val STRUCTURE_STATEMENT = ValkyrieElementType("STRUCTURE_STATEMENT")

    @JvmField
    val NAMESPACE_STATEMENT = ValkyrieElementType("NAMESPACE_STATEMENT")

    @JvmField
    val NAMESPACE_PATH = ValkyrieElementType("NAMESPACE_PATH")

    @JvmField
    val USING_STATEMENT = ValkyrieElementType("USING_STATEMENT")

    @JvmField
    val USING_BODY = ValkyrieElementType("USING_BODY")

    @JvmField
    val USING_ITEM = ValkyrieElementType("USING_ITEM")

    @JvmField
    val EXPRESSION_STATEMENT = ValkyrieElementType("EXPRESSION_STATEMENT")

    @JvmField
    val UNTIL_STATEMENT = ValkyrieElementType("UNTIL_STATEMENT")

    @JvmField
    val WHILE_STATEMENT = ValkyrieElementType("WHILE_STATEMENT")

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
    val IF_STATEMENT = ValkyrieElementType("IF_STATEMENT")

    @JvmField
    val IF_MAIN_PART = ValkyrieElementType("IF_MAIN_PART")

    @JvmField
    val ELSE_IF_PART = ValkyrieElementType("ELSE_IF_PART")


    @JvmField
    val ELSE_PART = ValkyrieElementType("ELSE_PART")

    @JvmField
    val ELSE_CLAUSE = ValkyrieElementType("ELSE_CLAUSE")

    @JvmField
    val IF_LET_STATEMENT = ValkyrieElementType("IF_LET_STATEMENT")

    @JvmField
    val DECLARE_TESTS = ValkyrieElementType("DECLARE_TESTS")

    // 元编程相关元素类型
    @JvmField
    val DECLARE_MICRO = ValkyrieElementType("DECLARE_MICRO")

    @JvmField
    val ASSIGN_MICRO = ValkyrieElementType("DECLARE_MICRO")

    @JvmField
    val DECLARE_MEZZO = ValkyrieElementType("DECLARE_MEZZO")

    @JvmField
    val ASSIGN_MEZZO = ValkyrieElementType("MEZZO_DECLARATION")

    @JvmField
    val DECLARE_MACRO = ValkyrieElementType("DECLARE_MACRO")

    @JvmField
    val ASSIGN_MACRO = ValkyrieElementType("ASSIGN_MACRO")

    @JvmField
    val COMPILE_TIME_BLOCK = ValkyrieElementType("COMPILE_TIME_BLOCK")

    @JvmField
    val TEMPLATE_BLOCK = ValkyrieElementType("TEMPLATE_BLOCK")

    @JvmField
    val TEMPLATE_IF = ValkyrieElementType("TEMPLATE_IF")

    @JvmField
    val TEMPLATE_IF_MARK = ValkyrieElementType("TEMPLATE_IF")

    @JvmField
    val TEMPLATE_ELSE_IF = ValkyrieElementType("TEMPLATE_ELSE_IF")

    @JvmField
    val TEMPLATE_ELSE = ValkyrieElementType("TEMPLATE_ELSE")

    @JvmField
    val TEMPLATE_FOR = ValkyrieElementType("TEMPLATE_FOR")

    @JvmField
    val TEMPLATE_WHILE = ValkyrieElementType("TEMPLATE_WHILE")

    @JvmField
    val TEMPLATE_MATCH = ValkyrieElementType("TEMPLATE_MATCH")

    @JvmField
    val TEMPLATE_END_MARK = ValkyrieElementType("TEMPLATE_END_MARK")

    @JvmField
    val TEMPLATE_TEXT = ValkyrieElementType("TEMPLATE_TEXT")

    @JvmField
    val BLOCK_STATEMENT = ValkyrieElementType("BLOCK_STATEMENT")

    // 专用的body类型
    @JvmField
    val OBJECT_BODY = ValkyrieElementType("OBJECT_BODY")

    @JvmField
    val UNION_BODY = ValkyrieElementType("UNION_BODY")

    @JvmField
    val FUNCTION_BODY = ValkyrieElementType("FUNCTION_BODY")

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
    val TUPLE_EXPRESSION = ValkyrieElementType("TUPLE_EXPRESSION")

    @JvmField
    val NAMED_TUPLE_EXPRESSION = ValkyrieElementType("NAMED_TUPLE_EXPRESSION")

    @JvmField
    val AS_EXPRESSION = ValkyrieElementType("AS_EXPRESSION")

    @JvmField
    val CALL_EXPRESSION = ValkyrieElementType("CALL_EXPRESSION")

    @JvmField
    val GENERIC_CALL_EXPRESSION = ValkyrieElementType("GENERIC_CALL_EXPRESSION")

    @JvmField
    val POSTFIX_EXPRESSION = ValkyrieElementType("POSTFIX_EXPRESSION")

    @JvmField
    val DOT_EXPRESSION = ValkyrieElementType("DOT_EXPRESSION")

    @JvmField
    val PATH_EXPRESSION = ValkyrieElementType("PATH_EXPRESSION")

    @JvmField
    val TRAILING_CLOSURE_EXPRESSION = ValkyrieElementType("TRAILING_CLOSURE_EXPRESSION")

    @JvmField
    val ARRAY_EXPRESSION = ValkyrieElementType("ARRAY_EXPRESSION")

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
    val RESUME_STATEMENT = ValkyrieElementType("RESUME_STATEMENT")

    @JvmField
    val SCOPE_STATEMENT = ValkyrieElementType("SCOPE_STATEMENT")

    @JvmField
    val EACH_STATEMENT = ValkyrieElementType("FOR_STATEMENT")

    @JvmField
    val LOOP_STATEMENT = ValkyrieElementType("LOOP_STATEMENT")

    @JvmField
    val ASSIGN_STATEMENT = ValkyrieElementType("ASSIGN_STATEMENT")

    @JvmField
    val MUTABLE_PATTERN = ValkyrieElementType("MUTABLE_PATTERN")

    // 类型
    @JvmField
    val TYPE_REFERENCE = ValkyrieElementType("TYPE_REFERENCE")

    @JvmField
    val UNION_TYPE = ValkyrieElementType("UNION_TYPE")

    @JvmField
    val INTERSECTION_TYPE = ValkyrieElementType("INTERSECTION_TYPE")

    @JvmField
    val FUNCTION_TYPE = ValkyrieElementType("FUNCTION_TYPE")

    @JvmField
    val OPTIONAL_TYPE = ValkyrieElementType("OPTIONAL_TYPE")

    @JvmField
    val ARRAY_TYPE = ValkyrieElementType("ARRAY_TYPE")

    @JvmField
    val TUPLE_TYPE = ValkyrieElementType("TUPLE_TYPE")

    @JvmField
    val PARENTHESIZED_TYPE = ValkyrieElementType("PARENTHESIZED_TYPE")

    @JvmField
    val PRIMITIVE_TYPE = ValkyrieElementType("PRIMITIVE_TYPE")

    // 类型提示和默认值相关
    @JvmField
    val TYPE_HINT = ValkyrieElementType("TYPE_HINT")

    @JvmField
    val RETURN_TYPE = ValkyrieElementType("RETURN_TYPE")

    @JvmField
    val EFFECT_TYPE = ValkyrieElementType("EFFECT_TYPE")

    @JvmField
    val DEFAULT_TYPE = ValkyrieElementType("DEFAULT_TYPE")

    @JvmField
    val DEFAULT_VALUE = ValkyrieElementType("DEFAULT_VALUE")

    // Class 和 Union 内部结构
    @JvmField
    val INHERIT_LIST = ValkyrieElementType("CLASS_INHERIT")

    @JvmField
    val INHERIT_ITEM = ValkyrieElementType("INHERIT_ITEM")

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

    @JvmField
    val FLAGS_ITEM = ValkyrieElementType("FLAGS_ITEM")


    // 注解节点（统一管理attributes和modifiers）
    @JvmField
    val ANNOTATION_NODE = ValkyrieElementType("ANNOTATION_NODE")

    // 修饰符
    @JvmField
    val MODIFIER_NODE = ValkyrieElementType("MODIFIER_NODE")

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
    @JvmField
    val TERM_PARAMETER_LIST = ValkyrieElementType("PARAMETER_LIST")

    @JvmField
    val TERM_PARAMETER_ITEM = ValkyrieElementType("PARAMETER")

    @JvmField
    val ARGUMENT_LIST = ValkyrieElementType("ARGUMENT_LIST")

    @JvmField
    val GENERIC_PARAMETER_LIST = ValkyrieElementType("GENERIC_PARAMETER_LIST")

    @JvmField
    val GENERIC_PARAMETER = ValkyrieElementType("GENERIC_PARAMETER")

    // 注释
    @JvmField
    val DOC_COMMENT = ValkyrieElementType("DOC_COMMENT")

    // 错误元素
    @JvmField
    val ERROR_ELEMENT = ValkyrieElementType("ERROR_ELEMENT")
}
package valkyrie.psi

/**
 * Valkyrie PSI 元素类型定义
 */
object ValkyrieElementTypes {


    // 文件根节点
    @JvmField
    val FILE = valkyrie.psi.ValkyrieElementType("FILE")

    // 通用类型
    @JvmField
    val STATEMENT = valkyrie.psi.ValkyrieElementType("STATEMENT")

    @JvmField
    val EXPRESSION = valkyrie.psi.ValkyrieElementType("EXPRESSION")

    @JvmField
    val PATTERN = valkyrie.psi.ValkyrieElementType("PATTERN")

    @JvmField
    val BARE_PATTERN= valkyrie.psi.ValkyrieElementType("BARE_PATTERN")
    @JvmField
    val TUPLE_PATTERN = valkyrie.psi.ValkyrieElementType("TUPLE_PATTERN")

    @JvmField
    val TABLE_PATTERN = valkyrie.psi.ValkyrieElementType("TABLE_PATTERN")

    @JvmField
    val OBJECT_PATTERN = valkyrie.psi.ValkyrieElementType("OBJECT_PATTERN")

    // 语句
    @JvmField
    val LET_STATEMENT = valkyrie.psi.ValkyrieElementType("LET_STATEMENT")

    @JvmField
    val CLASS_STATEMENT = valkyrie.psi.ValkyrieElementType("CLASS_STATEMENT")

    @JvmField
    val NEURAL_STATEMENT = valkyrie.psi.ValkyrieElementType("NEURAL_STATEMENT")

    @JvmField
    val WIDGET_STATEMENT = valkyrie.psi.ValkyrieElementType("WIDGET_STATEMENT")

    @JvmField
    val SINGLETON_STATEMENT = valkyrie.psi.ValkyrieElementType("SINGLETON_STATEMENT")

    @JvmField
    val UNION_STATEMENT = valkyrie.psi.ValkyrieElementType("UNION_STATEMENT")

    @JvmField
    val UNITY_STATEMENT = valkyrie.psi.ValkyrieElementType("UNITY_STATEMENT")

    @JvmField
    val FLAGS_STATEMENT = valkyrie.psi.ValkyrieElementType("FLAGS_STATEMENT")

    @JvmField
    val EIDOS_STATEMENT = valkyrie.psi.ValkyrieElementType("ENUMS_STATEMENT")


    @JvmField
    val TRAIT_STATEMENT = valkyrie.psi.ValkyrieElementType("TRAIT_STATEMENT")

    @JvmField
    val TRAIT_ALIAS = valkyrie.psi.ValkyrieElementType("TRAIT_ALIAS")

    @JvmField
    val IMPLY_STATEMENT = valkyrie.psi.ValkyrieElementType("IMPLY_STATEMENT")

    @JvmField
    val STRUCTURE_STATEMENT = valkyrie.psi.ValkyrieElementType("STRUCTURE_STATEMENT")

    @JvmField
    val NAMESPACE_STATEMENT = valkyrie.psi.ValkyrieElementType("NAMESPACE_STATEMENT")

    @JvmField
    val NAMESPACE_PATH = valkyrie.psi.ValkyrieElementType("NAMESPACE_PATH")

    @JvmField
    val USING_STATEMENT = valkyrie.psi.ValkyrieElementType("USING_STATEMENT")

    @JvmField
    val USING_BODY = valkyrie.psi.ValkyrieElementType("USING_BODY")

    @JvmField
    val USING_ITEM = valkyrie.psi.ValkyrieElementType("USING_ITEM")

    @JvmField
    val EXPRESSION_STATEMENT = valkyrie.psi.ValkyrieElementType("EXPRESSION_STATEMENT")

    @JvmField
    val UNTIL_STATEMENT = valkyrie.psi.ValkyrieElementType("UNTIL_STATEMENT")

    @JvmField
    val WHILE_STATEMENT = valkyrie.psi.ValkyrieElementType("WHILE_STATEMENT")

    @JvmField
    val MATCH_STATEMENT = valkyrie.psi.ValkyrieElementType("MATCH_STATEMENT")

    @JvmField
    val MATCH_CASE = valkyrie.psi.ValkyrieElementType("MATCH_CASE")

    @JvmField
    val MATCH_BODY = valkyrie.psi.ValkyrieElementType("MATCH_BODY")

    @JvmField
    val INTEGER_LITERAL = valkyrie.psi.ValkyrieElementType("INTEGER_LITERAL")

    @JvmField
    val DECIMAL_LITERAL = valkyrie.psi.ValkyrieElementType("DECIMAL_LITERAL")

    @JvmField
    val BOOLEAN_LITERAL = valkyrie.psi.ValkyrieElementType("BOOLEAN_LITERAL")

    @JvmField
    val CATCH_STATEMENT = valkyrie.psi.ValkyrieElementType("CATCH_STATEMENT")

    @JvmField
    val TRY_STATEMENT = valkyrie.psi.ValkyrieElementType("TRY_STATEMENT")

    @JvmField
    val WHEN_CLAUSE = valkyrie.psi.ValkyrieElementType("WHEN_CLAUSE")

    @JvmField
    val IF_STATEMENT = valkyrie.psi.ValkyrieElementType("IF_STATEMENT")

    @JvmField
    val IF_MAIN_PART = valkyrie.psi.ValkyrieElementType("IF_MAIN_PART")

    @JvmField
    val ELSE_IF_PART = valkyrie.psi.ValkyrieElementType("ELSE_IF_PART")


    @JvmField
    val ELSE_PART = valkyrie.psi.ValkyrieElementType("ELSE_PART")

    @JvmField
    val ELSE_CLAUSE = valkyrie.psi.ValkyrieElementType("ELSE_CLAUSE")

    @JvmField
    val IF_LET_STATEMENT = valkyrie.psi.ValkyrieElementType("IF_LET_STATEMENT")

    @JvmField
    val DECLARE_TESTS = valkyrie.psi.ValkyrieElementType("DECLARE_TESTS")

    // 元编程相关元素类型
    @JvmField
    val DECLARE_MICRO = valkyrie.psi.ValkyrieElementType("DECLARE_MICRO")

    @JvmField
    val ASSIGN_MICRO = valkyrie.psi.ValkyrieElementType("DECLARE_MICRO")

    @JvmField
    val DECLARE_MEZZO = valkyrie.psi.ValkyrieElementType("DECLARE_MEZZO")

    @JvmField
    val ASSIGN_MEZZO = valkyrie.psi.ValkyrieElementType("MEZZO_DECLARATION")

    @JvmField
    val DECLARE_MACRO = valkyrie.psi.ValkyrieElementType("DECLARE_MACRO")

    @JvmField
    val ASSIGN_MACRO = valkyrie.psi.ValkyrieElementType("ASSIGN_MACRO")

    @JvmField
    val COMPILE_TIME_BLOCK = valkyrie.psi.ValkyrieElementType("COMPILE_TIME_BLOCK")

    @JvmField
    val TEMPLATE_BLOCK = valkyrie.psi.ValkyrieElementType("TEMPLATE_BLOCK")

    @JvmField
    val TEMPLATE_IF = valkyrie.psi.ValkyrieElementType("TEMPLATE_IF")

    @JvmField
    val TEMPLATE_IF_MARK = valkyrie.psi.ValkyrieElementType("TEMPLATE_IF")

    @JvmField
    val TEMPLATE_ELSE_IF = valkyrie.psi.ValkyrieElementType("TEMPLATE_ELSE_IF")

    @JvmField
    val TEMPLATE_ELSE_IF_MARK = valkyrie.psi.ValkyrieElementType("TEMPLATE_ELSE_IF_MARK")

    @JvmField
    val TEMPLATE_ELSE = valkyrie.psi.ValkyrieElementType("TEMPLATE_ELSE")

    @JvmField
    val TEMPLATE_ELSE_MARK = valkyrie.psi.ValkyrieElementType("TEMPLATE_ELSE_MARK")

    @JvmField
    val TEMPLATE_FOR = valkyrie.psi.ValkyrieElementType("TEMPLATE_FOR")

    @JvmField
    val TEMPLATE_WHILE = valkyrie.psi.ValkyrieElementType("TEMPLATE_WHILE")

    @JvmField
    val TEMPLATE_MATCH = valkyrie.psi.ValkyrieElementType("TEMPLATE_MATCH")

    @JvmField
    val TEMPLATE_END_MARK = valkyrie.psi.ValkyrieElementType("TEMPLATE_END_MARK")

    @JvmField
    val TEMPLATE_TEXT = valkyrie.psi.ValkyrieElementType("TEMPLATE_TEXT")

    @JvmField
    val BLOCK_STATEMENT = valkyrie.psi.ValkyrieElementType("BLOCK_STATEMENT")

    // 专用的body类型
    @JvmField
    val OBJECT_BODY = valkyrie.psi.ValkyrieElementType("OBJECT_BODY")

    @JvmField
    val UNION_BODY = valkyrie.psi.ValkyrieElementType("UNION_BODY")

    @JvmField
    val FUNCTION_BODY = valkyrie.psi.ValkyrieElementType("FUNCTION_BODY")

    // 表达式
    @JvmField
    val IDENTIFIER_NODE = valkyrie.psi.ValkyrieElementType("IDENTIFIER_NODE")

    @JvmField
    val LITERAL_EXPRESSION = valkyrie.psi.ValkyrieElementType("LITERAL_EXPRESSION")

    @JvmField
    val BINARY_EXPRESSION = valkyrie.psi.ValkyrieElementType("BINARY_EXPRESSION")

    @JvmField
    val UNARY_EXPRESSION = valkyrie.psi.ValkyrieElementType("UNARY_EXPRESSION")

    @JvmField
    val PARENTHESIZED_EXPRESSION = valkyrie.psi.ValkyrieElementType("PARENTHESIZED_EXPRESSION")

    @JvmField
    val TUPLE_EXPRESSION = valkyrie.psi.ValkyrieElementType("TUPLE_EXPRESSION")

    @JvmField
    val NAMED_TUPLE_EXPRESSION = valkyrie.psi.ValkyrieElementType("NAMED_TUPLE_EXPRESSION")

    @JvmField
    val AS_EXPRESSION = valkyrie.psi.ValkyrieElementType("AS_EXPRESSION")

    @JvmField
    val CALL_EXPRESSION = valkyrie.psi.ValkyrieElementType("CALL_EXPRESSION")

    @JvmField
    val CALL_TYPE_ARGUMENT = valkyrie.psi.ValkyrieElementType("GENERIC_CALL_EXPRESSION")

    @JvmField
    val POSTFIX_EXPRESSION = valkyrie.psi.ValkyrieElementType("POSTFIX_EXPRESSION")

    @JvmField
    val DOT_EXPRESSION = valkyrie.psi.ValkyrieElementType("DOT_EXPRESSION")

    @JvmField
    val PATH_EXPRESSION = valkyrie.psi.ValkyrieElementType("PATH_EXPRESSION")

    @JvmField
    val TRAILING_CLOSURE_EXPRESSION = valkyrie.psi.ValkyrieElementType("TRAILING_CLOSURE_EXPRESSION")

    @JvmField
    val ARRAY_EXPRESSION = valkyrie.psi.ValkyrieElementType("ARRAY_EXPRESSION")

    @JvmField
    val TABLE_EXPRESSION = valkyrie.psi.ValkyrieElementType("TABLE_EXPRESSION")

    @JvmField
    val TABLE_PAIR = valkyrie.psi.ValkyrieElementType("TABLE_PAIR")

    @JvmField
    val SLICE_EXPRESSION = valkyrie.psi.ValkyrieElementType("SLICE_EXPRESSION")

    @JvmField
    val SLICE_ITEM = valkyrie.psi.ValkyrieElementType("SLICE_ITEM")

    @JvmField
    val INDEX_EXPRESSION = valkyrie.psi.ValkyrieElementType("INDEX_EXPRESSION")

    @JvmField
    val LABEL_STATEMENT = valkyrie.psi.ValkyrieElementType("LABEL_STATEMENT")

    @JvmField
    val RETURN_STATEMENT = valkyrie.psi.ValkyrieElementType("RETURN_STATEMENT")

    @JvmField
    val BREAK_STATEMENT = valkyrie.psi.ValkyrieElementType("BREAK_STATEMENT")

    @JvmField
    val CONTINUE_STATEMENT = valkyrie.psi.ValkyrieElementType("CONTINUE_STATEMENT")

    @JvmField
    val YIELD_STATEMENT = valkyrie.psi.ValkyrieElementType("YIELD_STATEMENT")

    @JvmField
    val RAISE_STATEMENT = valkyrie.psi.ValkyrieElementType("RAISE_STATEMENT")

    @JvmField
    val RESUME_STATEMENT = valkyrie.psi.ValkyrieElementType("RESUME_STATEMENT")

    @JvmField
    val SCOPE_STATEMENT = valkyrie.psi.ValkyrieElementType("SCOPE_STATEMENT")

    @JvmField
    val EACH_STATEMENT = valkyrie.psi.ValkyrieElementType("FOR_STATEMENT")

    @JvmField
    val LOOP_STATEMENT = valkyrie.psi.ValkyrieElementType("LOOP_STATEMENT")

    @JvmField
    val ASSIGN_STATEMENT = valkyrie.psi.ValkyrieElementType("ASSIGN_STATEMENT")

    @JvmField
    val MUTABLE_PATTERN = valkyrie.psi.ValkyrieElementType("MUTABLE_PATTERN")

    // 类型
    @JvmField
    val TYPE_REFERENCE = valkyrie.psi.ValkyrieElementType("TYPE_REFERENCE")

    @JvmField
    val UNION_TYPE = valkyrie.psi.ValkyrieElementType("UNION_TYPE")

    @JvmField
    val INTERSECTION_TYPE = valkyrie.psi.ValkyrieElementType("INTERSECTION_TYPE")

    @JvmField
    val FUNCTION_TYPE = valkyrie.psi.ValkyrieElementType("FUNCTION_TYPE")

    @JvmField
    val OPTIONAL_TYPE = valkyrie.psi.ValkyrieElementType("OPTIONAL_TYPE")

    @JvmField
    val ARRAY_TYPE = valkyrie.psi.ValkyrieElementType("ARRAY_TYPE")

    @JvmField
    val TABLE_TYPE = valkyrie.psi.ValkyrieElementType("TABLE_TYPE")

    @JvmField
    val TUPLE_TYPE = valkyrie.psi.ValkyrieElementType("TUPLE_TYPE")

    @JvmField
    val PARENTHESIZED_TYPE = valkyrie.psi.ValkyrieElementType("PARENTHESIZED_TYPE")

    @JvmField
    val PRIMITIVE_TYPE = valkyrie.psi.ValkyrieElementType("PRIMITIVE_TYPE")

    // 类型提示和默认值相关
    @JvmField
    val TYPE_HINT = valkyrie.psi.ValkyrieElementType("TYPE_HINT")

    @JvmField
    val RETURN_TYPE = valkyrie.psi.ValkyrieElementType("RETURN_TYPE")

    @JvmField
    val EFFECT_TYPE = valkyrie.psi.ValkyrieElementType("EFFECT_TYPE")

    @JvmField
    val DEFAULT_TYPE = valkyrie.psi.ValkyrieElementType("DEFAULT_TYPE")

    @JvmField
    val DEFAULT_VALUE = valkyrie.psi.ValkyrieElementType("DEFAULT_VALUE")

    // Class 和 Union 内部结构
    @JvmField
    val INHERIT_LIST = valkyrie.psi.ValkyrieElementType("CLASS_INHERIT")

    @JvmField
    val INHERIT_ITEM = valkyrie.psi.ValkyrieElementType("INHERIT_ITEM")

    @JvmField
    val FIELD_DECLARATION = valkyrie.psi.ValkyrieElementType("FIELD_DECLARATION")

    @JvmField
    val METHOD_DECLARATION = valkyrie.psi.ValkyrieElementType("METHOD_DECLARATION")

    @JvmField
    val INSTANCE_METHOD_DECLARATION = valkyrie.psi.ValkyrieElementType("INSTANCE_METHOD_DECLARATION")

    @JvmField
    val STATIC_METHOD_DECLARATION = valkyrie.psi.ValkyrieElementType("STATIC_METHOD_DECLARATION")

    @JvmField
    val DOMAIN_DECLARATION = valkyrie.psi.ValkyrieElementType("DOMAIN_DECLARATION")

    @JvmField
    val UNION_VARIANT = valkyrie.psi.ValkyrieElementType("UNION_VARIANT")

    @JvmField
    val FLAGS_ITEM = valkyrie.psi.ValkyrieElementType("FLAGS_ITEM")


    // 注解节点（统一管理attributes和modifiers）
    @JvmField
    val ANNOTATION_NODE = valkyrie.psi.ValkyrieElementType("ANNOTATION_NODE")

    // 修饰符
    @JvmField
    val MODIFIER_NODE = valkyrie.psi.ValkyrieElementType("MODIFIER_NODE")

    // 其他
    @JvmField
    val ATTRIBUTE = valkyrie.psi.ValkyrieElementType("ATTRIBUTE")

    @JvmField
    val ATTRIBUTE_LIST = valkyrie.psi.ValkyrieElementType("ATTRIBUTE_LIST")

    @JvmField
    val MACRO_CALL = valkyrie.psi.ValkyrieElementType("MACRO_CALL")

    @JvmField
    val ATTRIBUTE_ARGS = valkyrie.psi.ValkyrieElementType("ATTRIBUTE_ARGS")

    // 其他
    @JvmField
    val TERM_PARAMETER_LIST = valkyrie.psi.ValkyrieElementType("PARAMETER_LIST")

    @JvmField
    val TERM_PARAMETER_ITEM = valkyrie.psi.ValkyrieElementType("PARAMETER")

    @JvmField
    val ARGUMENT_LIST = valkyrie.psi.ValkyrieElementType("ARGUMENT_LIST")

    @JvmField
    val GENERIC_PARAMETER_LIST = valkyrie.psi.ValkyrieElementType("GENERIC_PARAMETER_LIST")

    @JvmField
    val GENERIC_PARAMETER = valkyrie.psi.ValkyrieElementType("GENERIC_PARAMETER")

    // 注释
    @JvmField
    val DOC_COMMENT = valkyrie.psi.ValkyrieElementType("DOC_COMMENT")

    // 错误元素
    @JvmField
    val ERROR_ELEMENT = valkyrie.psi.ValkyrieElementType("ERROR_ELEMENT")
}
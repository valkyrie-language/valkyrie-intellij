package valkyrie.psi

/**
 * Valkyrie PSI 元素类型定义
 */
object ValkyrieElementTypes {
    val VECTOR_TYPE = ValkyrieElementType("VECTOR_TYPE")
    val TABLE_ITEM = ValkyrieElementType("TABLE_ITEM")
    val TYPE_GROUP = ValkyrieElementType("GROUP_TYPE")
    val TYPE_TUPLE_ITEM = ValkyrieElementType("TUPLE_ITEM")
    val TYPE_EXPRESSION = ValkyrieElementType("TYPE_EXPRESSION")
    val PREFIX_TYPE_EXPRESSION = ValkyrieElementType("PREFIX_TYPE_EXPRESSION")
    val POSTFIX_TYPE_EXPRESSION = ValkyrieElementType("POSTFIX_TYPE_EXPRESSION")
    val GENERIC_APPLICATION_TYPE = ValkyrieElementType("GENERIC_APPLICATION_TYPE")
    val INFIX_TYPE = ValkyrieElementType("INFIX_TYPE")
    val SUBTRACTION_TYPE = ValkyrieElementType("SUBTRACTION_TYPE")
    val SUM_TYPE = ValkyrieElementType("SUM_TYPE")

    // 文件根节点
    @JvmField
    val STRING_LITERAL = ValkyrieElementType("STRING_LITERAL")

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
    val BARE_PATTERN = ValkyrieElementType("BARE_PATTERN")

    @JvmField
    val TUPLE_PATTERN = ValkyrieElementType("TUPLE_PATTERN")

    @JvmField
    val TABLE_PATTERN = ValkyrieElementType("TABLE_PATTERN")

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
    val MATCH_BODY = ValkyrieElementType("MATCH_BODY")

    @JvmField
    val INTEGER_LITERAL = ValkyrieElementType("INTEGER_LITERAL")

    @JvmField
    val DECIMAL_LITERAL = ValkyrieElementType("DECIMAL_LITERAL")

    @JvmField
    val BOOLEAN_LITERAL = ValkyrieElementType("BOOLEAN_LITERAL")

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
    val TEMPLATE_ELSE_IF_MARK = ValkyrieElementType("TEMPLATE_ELSE_IF_MARK")

    @JvmField
    val TEMPLATE_ELSE = ValkyrieElementType("TEMPLATE_ELSE")

    @JvmField
    val TEMPLATE_ELSE_MARK = ValkyrieElementType("TEMPLATE_ELSE_MARK")

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
    val CALL_TYPE_ARGUMENT = ValkyrieElementType("GENERIC_CALL_EXPRESSION")

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
    val TABLE_EXPRESSION = ValkyrieElementType("TABLE_EXPRESSION")

    @JvmField
    val TABLE_PAIR = ValkyrieElementType("TABLE_PAIR")

    @JvmField
    val SLICE_EXPRESSION = ValkyrieElementType("SLICE_EXPRESSION")

    @JvmField
    val SLICE_ITEM = ValkyrieElementType("SLICE_ITEM")

    @JvmField
    val INDEX_EXPRESSION = ValkyrieElementType("INDEX_EXPRESSION")

    @JvmField
    val LABEL_STATEMENT = ValkyrieElementType("LABEL_STATEMENT")

    @JvmField
    val RETURN_STATEMENT = ValkyrieElementType("RETURN_STATEMENT")

    @JvmField
    val BREAK_STATEMENT = ValkyrieElementType("BREAK_STATEMENT")

    @JvmField
    val CONTINUE_STATEMENT = ValkyrieElementType("CONTINUE_STATEMENT")

    @JvmField
    val FALLTHROUGH_STATEMENT = ValkyrieElementType("FALLTHROUGH_STATEMENT")

    @JvmField
    val YIELD_STATEMENT = ValkyrieElementType("YIELD_STATEMENT")

    @JvmField
    val RAISE_STATEMENT = ValkyrieElementType("RAISE_STATEMENT")

    @JvmField
    val RESUME_STATEMENT = ValkyrieElementType("RESUME_STATEMENT")

    @JvmField
    val SCOPE_STATEMENT = ValkyrieElementType("SCOPE_STATEMENT")

    // XML 和 Slot 相关节点
    @JvmField
    val XML_SLOT_EXPRESSION = ValkyrieElementType("XML_SLOT_EXPRESSION")

    @JvmField
    val XML_TEXT_NODE = ValkyrieElementType("XML_TEXT_NODE")

    @JvmField
    val XML_ELEMENT = ValkyrieElementType("XML_ELEMENT")

    @JvmField
    val XML_ATTRIBUTE = ValkyrieElementType("XML_ATTRIBUTE")

    @JvmField
    val XML_ATTRIBUTE_VALUE = ValkyrieElementType("XML_ATTRIBUTE_VALUE")

    @JvmField
    val XML_COMMENT = ValkyrieElementType("XML_COMMENT")

    // SFC (Single File Component) 相关节点
    @JvmField
    val SFC_TEMPLATE = ValkyrieElementType("SFC_TEMPLATE")

    @JvmField
    val SFC_SCRIPT = ValkyrieElementType("SFC_SCRIPT")

    @JvmField
    val SFC_STYLE = ValkyrieElementType("SFC_STYLE")

    @JvmField
    val SFC_COMPONENT = ValkyrieElementType("SFC_COMPONENT")

    @JvmField
    val SLOT_STATEMENT = ValkyrieElementType("SLOT_STATEMENT")

    @JvmField
    val EACH_STATEMENT = ValkyrieElementType("FOR_STATEMENT")
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
    val TABLE_TYPE = ValkyrieElementType("TABLE_TYPE")

    @JvmField
    val TYPE_TUPLE_LIST = ValkyrieElementType("TUPLE_TYPE")

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
    val GENERIC_PARAMETER_ITEM = ValkyrieElementType("GENERIC_PARAMETER")


    @JvmField
    val GENERIC_ARGUMENT_LIST = ValkyrieElementType("GENERIC_ARGUMENT_LIST")

    // 注释
    @JvmField
    val DOC_COMMENT = ValkyrieElementType("DOC_COMMENT")

    // 错误元素
    @JvmField
    val ERROR_ELEMENT = ValkyrieElementType("ERROR_ELEMENT")
}
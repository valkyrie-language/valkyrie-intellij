package valkyrie.cst

import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguage

// leaf node of the lexer stream
class ValkyrieCST(show: String) : IElementType(show, ValkyrieLanguage) {
    override fun toString(): String = "CST<${super.toString()}>"
}

// 括号

@JvmField
val BRACE_L = ValkyrieCST("{")


@JvmField
val BRACE_R = ValkyrieCST("}")


@JvmField
val BRACKET_L = ValkyrieCST("[")


@JvmField
val BRACKET_R = ValkyrieCST("]")


@JvmField
val PARENTHESIS_L = ValkyrieCST("(")


@JvmField
val PARENTHESIS_R = ValkyrieCST(")")

// 分隔符

@JvmField
val COLON = ValkyrieCST(":")


@JvmField
val NAME_JOIN = ValkyrieCST("∷")


@JvmField
val SEMICOLON = ValkyrieCST(";")


@JvmField
val COMMA = ValkyrieCST(",")


@JvmField
val QUESTION = ValkyrieCST("?")

//

@JvmField
val OP_MACRO_UPPER = ValkyrieCST("◤")


@JvmField
val OP_MACRO_LOWER = ValkyrieCST("↯")

@JvmField
val OP_MACRO = ValkyrieCST("@")


@JvmField
val OP_LEQ = ValkyrieCST("⩽")


@JvmField
val OP_LE = ValkyrieCST("<")


@JvmField
val OP_GEQ = ValkyrieCST("⩾")


@JvmField
val OP_GE = ValkyrieCST(">")


@JvmField
val DOT = ValkyrieCST(".")


@JvmField
val EQ = ValkyrieCST("=")


// 基本运算符

@JvmField
val OP_ADD = ValkyrieCST("+")


@JvmField
val OP_ADD_ASSIGN = ValkyrieCST("+=")


@JvmField
val OP_SUB = ValkyrieCST("-")


@JvmField
val OP_SUB_ASSIGN = ValkyrieCST("-=")


@JvmField
val OP_MUL = ValkyrieCST("×")


@JvmField
val OP_MUL_ASSIGN = ValkyrieCST("×=")


@JvmField
val OP_DIV = ValkyrieCST("/")


@JvmField
val OP_DIV_ASSIGN = ValkyrieCST("/=")


@JvmField
val OP_POW = ValkyrieCST("^")


@JvmField
val OP_POW_ASSIGN = ValkyrieCST("^=")


@JvmField
val OP_ARROW = ValkyrieCST("⟶")


@JvmField
val OP_OR = ValkyrieCST("|")


@JvmField
val OP_AND = ValkyrieCST("&")


@JvmField
val OP_NOT = ValkyrieCST("!")


@JvmField
val LOGIC_AND = ValkyrieCST("∧")


@JvmField
val LOGIC_XAND = ValkyrieCST("⩟")


@JvmField
val LOGIC_NAND = ValkyrieCST("⊼")


@JvmField
val LOGIC_OR = ValkyrieCST("∨")


@JvmField
val LOGIC_XOR = ValkyrieCST("⊻")


@JvmField
val LOGIC_NOR = ValkyrieCST("⊽")

// 软关键字

@JvmField
val KW_CLASS = ValkyrieCST("CLASS")


@JvmField
val KW_TRAIT = ValkyrieCST("TRAIT")


@JvmField
val KW_UNION = ValkyrieCST("UNION")


@JvmField
val KW_UNITE = ValkyrieCST("UNITE")


@JvmField
val KW_NEURAL = ValkyrieCST("NEURAL")


@JvmField
val KW_SINGLETON = ValkyrieCST("SINGLETON")


@JvmField
val KW_COMPONENT = ValkyrieCST("COMPONENT")


@JvmField
val KW_ENUMERATE = ValkyrieCST("ENUMERATE")


@JvmField
val KW_FLAGS = ValkyrieCST("FLAGS")


@JvmField
val KW_MICRO = ValkyrieCST("MICRO")


@JvmField
val KW_MEZZO = ValkyrieCST("MEZZO")


@JvmField
val KW_MACRO = ValkyrieCST("MACRO")

//

@JvmField
val KW_FROM = ValkyrieCST("FROM")

// 基本类型

@JvmField
val STRING = ValkyrieCST("STRING")


@JvmField
val NUMBER = ValkyrieCST("NUMBER")


@JvmField
val SYMBOL = ValkyrieCST("SYMBOL")


@JvmField
val SYMBOL_RAW = ValkyrieCST("SYMBOL<RAW>")

// 其他

@JvmField
val COMMENT_LINE_HEAD = ValkyrieCST("COMMENT_#")

@JvmField
val COMMENT_LINE = ValkyrieCST("Comment Line")

@JvmField
val COMMENT_LINE_TEXT = ValkyrieCST("COMMENT_LINE_TEXT")

@JvmField
val COMMENT_BLOCK = ValkyrieCST("COMMENT<BLOCK>")

@JvmField
val ANGLE_L: IElementType = ValkyrieCST("<")

@JvmField
val ANGLE_R: IElementType = ValkyrieCST(">")

@JvmField
val ANY_DICT: IElementType = ValkyrieCST("…")

@JvmField
val ANY_LIST: IElementType = ValkyrieCST("‥")

@JvmField
val ASSIGN_L: IElementType = ValkyrieCST("ASSIGN_L")

@JvmField
val ASSIGN_R: IElementType = ValkyrieCST("ASSIGN_R")

@JvmField
val BIND: IElementType = ValkyrieCST("=")

@JvmField
val BUILDER_L: IElementType = ValkyrieCST("BUILDER_L")

@JvmField
val BUILDER_R: IElementType = ValkyrieCST("BUILDER_R")

@JvmField
val CEIL_L: IElementType = ValkyrieCST("CEIL_L")

@JvmField
val CEIL_R: IElementType = ValkyrieCST("CEIL_R")

@JvmField
val COLOR: IElementType = ValkyrieCST("COLOR")


@JvmField
val DECIMAL: IElementType = ValkyrieCST("DECIMAL")

@JvmField
val DOLLAR: IElementType = ValkyrieCST("$")

@JvmField
val DOMAIN_L: IElementType = ValkyrieCST("DOMAIN_L")

@JvmField
val DOMAIN_R: IElementType = ValkyrieCST("DOMAIN_R")

@JvmField
val FLOOR_L: IElementType = ValkyrieCST("FLOOR_L")

@JvmField
val FLOOR_R: IElementType = ValkyrieCST("FLOOR_R")

@JvmField
val GENERIC_L: IElementType = ValkyrieCST("GENERIC_L")

@JvmField
val GENERIC_R: IElementType = ValkyrieCST("GENERIC_R")

@JvmField
val INTEGER: IElementType = ValkyrieCST("<<INTEGER>>")

@JvmField
val KW_AS: IElementType = ValkyrieCST("KW_AS")

@JvmField
val KW_BOOLEAN: IElementType = ValkyrieCST("KW_BOOLEAN")

@JvmField
val KW_BREAK: IElementType = ValkyrieCST("KW_BREAK")

@JvmField
val KW_CASE: IElementType = ValkyrieCST("KW_CASE")

@JvmField
val KW_CATCH: IElementType = ValkyrieCST("KW_CATCH")

@JvmField
val KW_CONTINUE: IElementType = ValkyrieCST("KW_CONTINUE")

@JvmField
val KW_EACH: IElementType = ValkyrieCST("KW_EACH")

@JvmField
val KW_ELSE: IElementType = ValkyrieCST("KW_ELSE")

@JvmField
val KW_END: IElementType = ValkyrieCST("KW_END")

@JvmField
val KW_EXCLUDE: IElementType = ValkyrieCST("KW_EXCLUDE")

@JvmField
val KW_FOR: IElementType = ValkyrieCST("KW_FOR")

@JvmField
val KW_FUNCTION: IElementType = ValkyrieCST("KW_FUNCTION")

@JvmField
val KW_IF: IElementType = ValkyrieCST("KW_IF")

@JvmField
val KW_IMPLY: IElementType = ValkyrieCST("KW_IMPLY")

@JvmField
val KW_IN: IElementType = ValkyrieCST("KW_IN")

@JvmField
val KW_INFER: IElementType = ValkyrieCST("KW_INFER")

@JvmField
val KW_IS: IElementType = ValkyrieCST("KW_IS")

@JvmField
val KW_LAMBDA: IElementType = ValkyrieCST("KW_LAMBDA")

@JvmField
val KW_LET: IElementType = ValkyrieCST("KW_LET")

@JvmField
val KW_LOOP: IElementType = ValkyrieCST("KW_LOOP")

@JvmField
val KW_MATCH: IElementType = ValkyrieCST("KW_MATCH")

@JvmField
val KW_NAMESPACE: IElementType = ValkyrieCST("KW_NAMESPACE")

@JvmField
val KW_NEW: IElementType = ValkyrieCST("KW_NEW")

@JvmField
val KW_NIL: IElementType = ValkyrieCST("KW_NIL")

@JvmField
val KW_NOT: IElementType = ValkyrieCST("KW_NOT")

@JvmField
val KW_NULL: IElementType = ValkyrieCST("KW_NULL")

@JvmField
val KW_OBJECT: IElementType = ValkyrieCST("KW_OBJECT")

@JvmField
val KW_RAISE: IElementType = ValkyrieCST("KW_RAISE")

@JvmField
val KW_RESUME: IElementType = ValkyrieCST("KW_RESUME")

@JvmField
val KW_RETURN: IElementType = ValkyrieCST("KW_RETURN")

@JvmField
val KW_TESTS: IElementType = ValkyrieCST("KW_TESTS")

@JvmField
val KW_THEN: IElementType = ValkyrieCST("KW_THEN")

@JvmField
val KW_THROUGH: IElementType = ValkyrieCST("KW_THROUGH")

@JvmField
val KW_TRY: IElementType = ValkyrieCST("KW_TRY")

@JvmField
val KW_TYPE: IElementType = ValkyrieCST("KW_TYPE")

@JvmField
val KW_UNTIL: IElementType = ValkyrieCST("KW_UNTIL")

@JvmField
val KW_USING: IElementType = ValkyrieCST("KW_USING")

@JvmField
val KW_WHEN: IElementType = ValkyrieCST("KW_WHEN")

@JvmField
val KW_WHERE: IElementType = ValkyrieCST("KW_WHERE")

@JvmField
val KW_WHILE: IElementType = ValkyrieCST("KW_WHILE")

@JvmField
val KW_WITH: IElementType = ValkyrieCST("KW_WITH")

@JvmField
val KW_YIELD: IElementType = ValkyrieCST("KW_YIELD")

@JvmField
val NAME_SCOPE: IElementType = ValkyrieCST("NAME_SCOPE")

@JvmField
val NAME_SPLIT: IElementType = ValkyrieCST("∷")

@JvmField
val NUMBER_BASE: IElementType = ValkyrieCST("NUMBER_BASE")

@JvmField
val NUMBER_EXPONENT: IElementType = ValkyrieCST("NUMBER_EXPONENT")

@JvmField
val NUMBER_SUFFIX: IElementType = ValkyrieCST("NUMBER_SUFFIX")

@JvmField
val OFFSET_L: IElementType = ValkyrieCST("OFFSET_L")

@JvmField
val OFFSET_R: IElementType = ValkyrieCST("OFFSET_R")

@JvmField
val OP_AND_THEN: IElementType = ValkyrieCST("OP_AND_THEN")

@JvmField
val OP_ARROW1: IElementType = ValkyrieCST("OP_ARROW1")

@JvmField
val OP_ARROW2: IElementType = ValkyrieCST("OP_ARROW2")

@JvmField
val OP_ARROW3: IElementType = ValkyrieCST("OP_ARROW3")

@JvmField
val OP_BANG: IElementType = ValkyrieCST("OP_BANG")

@JvmField
val OP_BASE: IElementType = ValkyrieCST("OP_BASE")

@JvmField
val OP_CELSIUS: IElementType = ValkyrieCST("OP_CELSIUS")

@JvmField
val OP_DEREFERENCE: IElementType = ValkyrieCST("OP_DEREFERENCE")

@JvmField
val OP_DIV_CEIL: IElementType = ValkyrieCST("OP_DIV_CEIL")

@JvmField
val OP_DIV_FLOOR: IElementType = ValkyrieCST("OP_DIV_FLOOR")

@JvmField
val OP_DIV_REM: IElementType = ValkyrieCST("OP_DIV_REM")

@JvmField
val OP_DIV_ROUND: IElementType = ValkyrieCST("OP_DIV_ROUND")

@JvmField
val OP_EE: IElementType = ValkyrieCST("OP_EE")

@JvmField
val OP_END: IElementType = ValkyrieCST("OP_END")

@JvmField
val OP_EXPONENT: IElementType = ValkyrieCST("OP_EXPONENT")

@JvmField
val OP_FAHRENHEIT: IElementType = ValkyrieCST("OP_FAHRENHEIT")

@JvmField
val OP_GG: IElementType = ValkyrieCST("≫")

@JvmField
val OP_GGG: IElementType = ValkyrieCST("⋙")

@JvmField
val OP_L10N: IElementType = ValkyrieCST("OP_L10N")

@JvmField
val OP_LABEL: IElementType = ValkyrieCST("OP_LABEL")

@JvmField
val OP_LL: IElementType = ValkyrieCST("≪")

@JvmField
val OP_LLL: IElementType = ValkyrieCST("⋘")

@JvmField
val OP_MAP: IElementType = ValkyrieCST("OP_MAP")

@JvmField
val OP_NE: IElementType = ValkyrieCST("OP_NE")

@JvmField
val OP_REFERENCE: IElementType = ValkyrieCST("OP_REFERENCE")

@JvmField
val OP_REM: IElementType = ValkyrieCST("OP_REM")

@JvmField
val OP_REM_ASSIGN: IElementType = ValkyrieCST("OP_REM_ASSIGN")

@JvmField
val OP_RR: IElementType = ValkyrieCST("OP_RR")

@JvmField
val OP_SET_THEN: IElementType = ValkyrieCST("OP_SET_THEN")

@JvmField
val OP_SQRT: IElementType = ValkyrieCST("OP_SQRT")

@JvmField
val OP_SURD3: IElementType = ValkyrieCST("OP_SURD3")

@JvmField
val OP_SURD4: IElementType = ValkyrieCST("OP_SURD4")

@JvmField
val OP_UNTIL: IElementType = ValkyrieCST("OP_UNTIL")

@JvmField
val OP_UNWRAP_ELSE: IElementType = ValkyrieCST("OP_UNWRAP_ELSE")

@JvmField
val OP_UNWRAP_OR: IElementType = ValkyrieCST("OP_UNWRAP_OR")

@JvmField
val STAR: IElementType = ValkyrieCST("STAR")

@JvmField
val STRING_L: IElementType = ValkyrieCST("STRING_L")

@JvmField
val STRING_R: IElementType = ValkyrieCST("STRING_R")

@JvmField
val STRING_TEXT: IElementType = ValkyrieCST("STRING_TEXT")

@JvmField
val TEMPLATE_L: IElementType = ValkyrieCST("TEMPLATE_L")

@JvmField
val TEMPLATE_R: IElementType = ValkyrieCST("TEMPLATE_R")
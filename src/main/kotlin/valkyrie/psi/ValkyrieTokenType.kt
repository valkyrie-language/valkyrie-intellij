package valkyrie.psi

import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguage

/**
 * Valkyrie Token 类型定义
 */
class ValkyrieTokenType(debugName: String) : IElementType(debugName, ValkyrieLanguage.INSTANCE) {
    override fun toString(): String = "ValkyrieTokenType." + super.toString()
}

/**
 * Valkyrie 所有 Token 类型
 */
object ValkyrieTokenTypes {
    // 关键字
    @JvmField val LET = ValkyrieTokenType("LET")
    @JvmField val MUT = ValkyrieTokenType("MUT")
    @JvmField val REF = ValkyrieTokenType("REF")
    @JvmField val IF = ValkyrieTokenType("IF")
    @JvmField val ELSE = ValkyrieTokenType("ELSE")
    @JvmField val WHILE = ValkyrieTokenType("WHILE")
    @JvmField val FOR = ValkyrieTokenType("FOR")
    @JvmField val FUNCTION = ValkyrieTokenType("FUNCTION")
    @JvmField val CLASS = ValkyrieTokenType("CLASS")
    @JvmField val TRAIT = ValkyrieTokenType("TRAIT")
    @JvmField val RETURN = ValkyrieTokenType("RETURN")
    @JvmField val BREAK = ValkyrieTokenType("BREAK")
    @JvmField val CONTINUE = ValkyrieTokenType("CONTINUE")
    
    // 标识符和字面量
    @JvmField val IDENTIFIER = ValkyrieTokenType("IDENTIFIER")
    @JvmField val INTEGER = ValkyrieTokenType("INTEGER")
    @JvmField val FLOAT = ValkyrieTokenType("FLOAT")
    @JvmField val STRING = ValkyrieTokenType("STRING")
    @JvmField val BOOLEAN = ValkyrieTokenType("BOOLEAN")
    
    // 操作符
    @JvmField val ASSIGN = ValkyrieTokenType("ASSIGN")  // =
    @JvmField val PLUS = ValkyrieTokenType("PLUS")    // +
    @JvmField val MINUS = ValkyrieTokenType("MINUS")  // -
    @JvmField val MULTIPLY = ValkyrieTokenType("MULTIPLY") // *
    @JvmField val DIVIDE = ValkyrieTokenType("DIVIDE") // /
    @JvmField val MODULO = ValkyrieTokenType("MODULO") // %
    @JvmField val EQUAL = ValkyrieTokenType("EQUAL")  // ==
    @JvmField val NOT_EQUAL = ValkyrieTokenType("NOT_EQUAL") // !=
    @JvmField val LESS = ValkyrieTokenType("LESS")    // <
    @JvmField val GREATER = ValkyrieTokenType("GREATER") // >
    @JvmField val LESS_EQUAL = ValkyrieTokenType("LESS_EQUAL") // <=
    @JvmField val GREATER_EQUAL = ValkyrieTokenType("GREATER_EQUAL") // >=
    @JvmField val AND = ValkyrieTokenType("AND")      // &&
    @JvmField val OR = ValkyrieTokenType("OR")        // ||
    @JvmField val NOT = ValkyrieTokenType("NOT")      // !
    
    // 分隔符
    @JvmField val SEMICOLON = ValkyrieTokenType("SEMICOLON") // ;
    @JvmField val COMMA = ValkyrieTokenType("COMMA")   // ,
    @JvmField val DOT = ValkyrieTokenType("DOT")       // .
    @JvmField val COLON = ValkyrieTokenType("COLON")   // :
    @JvmField val ARROW = ValkyrieTokenType("ARROW")   // ->
    
    // 括号
    @JvmField val LPAREN = ValkyrieTokenType("LPAREN") // (
    @JvmField val RPAREN = ValkyrieTokenType("RPAREN") // )
    @JvmField val LBRACE = ValkyrieTokenType("LBRACE") // {
    @JvmField val RBRACE = ValkyrieTokenType("RBRACE") // }
    @JvmField val LBRACKET = ValkyrieTokenType("LBRACKET") // [
    @JvmField val RBRACKET = ValkyrieTokenType("RBRACKET") // ]
    
    // 注释和空白
    @JvmField val LINE_COMMENT = ValkyrieTokenType("LINE_COMMENT")
    @JvmField val BLOCK_COMMENT = ValkyrieTokenType("BLOCK_COMMENT")
    @JvmField val WHITESPACE = ValkyrieTokenType("WHITESPACE")
    @JvmField val NEWLINE = ValkyrieTokenType("NEWLINE")
    
    // 错误 token
    @JvmField val BAD_CHARACTER = ValkyrieTokenType("BAD_CHARACTER")
}
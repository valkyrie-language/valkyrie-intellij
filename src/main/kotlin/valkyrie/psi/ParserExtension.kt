package valkyrie.psi

import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.psi.tree.TokenSet
import valkyrie.psi.ValkyrieTypes.*

class ParserExtension : GeneratedParserUtilBase() {
    companion object {
        val Keywords = TokenSet.create(
            KW_NAMESPACE, KW_USING, KW_AS, KW_EXCLUDE,
            KW_TYPE,
            KW_ENUMERATE, KW_FLAGS,
            KW_CLASS, KW_COMPONENT, KW_SINGLETON, KW_NEURAL,
            KW_UNION,
            KW_UNITE,
            KW_TRAIT, KW_FROM,

            KW_INFER, KW_WHERE,
            KW_IMPLY,

            KW_FUNCTION, KW_MACRO, KW_LET,

            KW_NEW, KW_OBJECT, KW_LAMBDA, DOLLAR,

            KW_IF, KW_ELSE, KW_THROUGH,
            KW_LOOP, KW_WHILE, KW_UNTIL,
            KW_FOR, KW_IN,
            KW_RETURN, KW_RESUME, KW_BREAK, KW_CONTINUE, KW_YIELD, KW_RAISE,
            KW_TRY, KW_MATCH, KW_CATCH,
            KW_WITH, KW_CASE, KW_WHEN,
            KW_IS, KW_NOT,
            KW_NIL,

            ANY_LIST,
            ANY_DICT,
        )

        val OperatorPrefix: TokenSet = TokenSet.create(
            OP_BANG,
            OP_SQRT,
            OP_SURD3,
            OP_SURD4,


            )
        val OperatorInfix = TokenSet.create(
            OP_ADD, OP_ADD_ASSIGN,
            OP_SUB, OP_SUB_ASSIGN,
            OP_MUL, OP_MUL_ASSIGN,
            OP_DIV, OP_DIV_ASSIGN,
            OP_DIV_FLOOR, OP_DIV_CEIL, OP_DIV_ROUND,
            OP_REM, OP_REM_ASSIGN,
            OP_DIV_REM,
            OP_POW,
            OP_AND,
            OP_OR,
            OP_UNTIL,
            OP_GGG, OP_GEQ, OP_GG,
            OP_LLL, OP_LEQ, OP_LL,
            OP_EE, OP_NE,

            OP_AND_THEN,
//            OP_AND, OP_AND_ASSIGN,
//            OP_OR, OP_OR_ASSIGN,
//            OP_XOR, OP_XOR_ASSIGN,
//            OP_SHL, OP_SHL_ASSIGN,
        )
        val OperatorSuffix = TokenSet.create(
            OP_BANG,
            OP_CELSIUS, OP_FAHRENHEIT,
        )
        val Operators = TokenSet.orSet(
            OperatorPrefix,
            OperatorInfix,
            OperatorSuffix,
        );

        val Comments: TokenSet = TokenSet.create();
        val CompletionWords: TokenSet = TokenSet.create(
            SYMBOL, SYMBOW_RAW
        )
    }
}


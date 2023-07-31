package valkyrie.psi

import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.psi.tree.TokenSet
import valkyrie.psi.ValkyrieTypes.*

class ParserExtension : GeneratedParserUtilBase() {
    companion object {
        val OperatorPrefix: TokenSet = TokenSet.create(
            OP_BANG,

        )
        val OperatorInfix: TokenSet = TokenSet.create(
            OP_ADD, OP_ADD_ASSIGN,
            OP_SUB, OP_SUB_ASSIGN,
            OP_MUL, OP_MUL_ASSIGN,
            OP_DIV, OP_DIV_ASSIGN,
//            OP_MOD, OP_MOD_ASSIGN,
            OP_POW, OP_POW_ASSIGN,
//            OP_AND, OP_AND_ASSIGN,
//            OP_OR, OP_OR_ASSIGN,
//            OP_XOR, OP_XOR_ASSIGN,
//            OP_SHL, OP_SHL_ASSIGN,
        )
        val OperatorSuffix: TokenSet = TokenSet.create(
            OP_BANG,
        )
        val Operators = TokenSet.orSet(
            OperatorPrefix,
            OperatorInfix,
            OperatorSuffix
        );

        val Comments: TokenSet = TokenSet.create();
        val CompletionWords: TokenSet = TokenSet.create(
            SYMBOL, SYMBOW_RAW
        )
    }
}


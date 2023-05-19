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
            OP_PLUS,
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


package valkyrie.psi

import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.psi.tree.TokenSet
import valkyrie.psi.ValkyrieTypes.*

class ParserExtension : GeneratedParserUtilBase() {
    companion object {
        val Keywords: TokenSet = TokenSet.create(
            // declare keywords
            KW_GRAMMAR, KW_GROUP, KW_CLASS, KW_UNION, KW_CLIMB,
            // import keywords
            KW_IMPORT, KW_AS,
            // tok
            KW_MACRO,
            // special
//            KW_ANY, KW_BOOLEAN,
//            OP_CONCAT,
//            // control flow
//            KW_PUSH, KW_PEEK, KW_DROP, KW_PULL,
            //
        )
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


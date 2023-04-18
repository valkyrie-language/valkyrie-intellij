package valkyrie.psi

import com.intellij.lang.ASTFactory
import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.GeneratedMarkerVisitor
import com.intellij.psi.impl.PsiManagerEx
import com.intellij.psi.impl.source.DummyHolderFactory
import com.intellij.psi.tree.IElementType
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

fun PsiElement.replaceLeaf(kind: IElementType, text: String) {
    val myManager = PsiManagerEx.getInstanceEx(project)
    val holderElement = DummyHolderFactory.createHolder(myManager, null).treeElement
    val newElement = ASTFactory.leaf(kind, holderElement.charTable.intern(text))
    holderElement.rawAddChildren(newElement)
    GeneratedMarkerVisitor.markGenerated(newElement.psi)
    val psi = newElement.psi
    this.replace(psi)
}

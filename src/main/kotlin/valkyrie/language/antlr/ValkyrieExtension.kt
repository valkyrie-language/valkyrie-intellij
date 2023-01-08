package valkyrie.language.antlr


import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.impl.source.tree.CompositeElement
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import valkyrie.language.ast.ValkyrieBinaryExpression


fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun extractExpression(node: CompositeElement): ANTLRPsiNode {
    val infix = node.findPsiChildByType(ValkyrieLexer.OperatorInfix);
    return if (infix == null) {
//        println("extractExpression: ${node.elementType} ${node.text}")
        ANTLRPsiNode(node)
    } else {
        ValkyrieBinaryExpression(node, infix)
    }
}


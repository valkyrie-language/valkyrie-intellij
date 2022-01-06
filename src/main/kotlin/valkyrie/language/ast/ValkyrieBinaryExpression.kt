package valkyrie.language.ast

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class ValkyrieBinaryExpression(node: CompositeElement, infix: PsiElement) : ANTLRPsiNode(node) {
    val lhs: ANTLRPsiNode;
    val rhs: ANTLRPsiNode;
    val operator: ValkyrieOperatorNode

    init {
        lhs = ANTLRPsiNode(node.firstChildNode)
        rhs = ANTLRPsiNode(node.lastChildNode)
        operator = when (infix.text) {
            "*" -> {
                ValkyrieOperatorNode(infix)
            }

            else -> {
                ValkyrieOperatorNode(infix)
            }
        }
    }
}

class ValkyrieOperatorNode : ANTLRPsiLeafNode {


    constructor(type: IElementType, text: String) : super(type, text)
    constructor(infix: PsiElement) : super(infix.elementType!!, infix.text) {


    }
}
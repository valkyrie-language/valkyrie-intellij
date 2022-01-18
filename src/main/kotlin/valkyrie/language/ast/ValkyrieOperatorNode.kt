package valkyrie.language.ast

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode

class ValkyrieOperatorNode : ANTLRPsiLeafNode {


    constructor(type: IElementType, text: String) : super(type, text)
    constructor(infix: PsiElement) : super(infix.elementType!!, infix.text) {


    }
}
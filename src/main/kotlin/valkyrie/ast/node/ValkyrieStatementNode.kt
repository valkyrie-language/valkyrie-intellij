package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParserMonad
import valkyrie.ast.advanceChoice
import valkyrie.cst.SEMICOLON

class ValkyrieStatementNode(node: ASTNode) : ASTWrapperPsiElement(node) {

    override fun toString(): String {
        return "ValkyrieStatement"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {

            return builder.advanceChoice(
                ValkyrieTermExpressionNode,
                SkipSeparator(SEMICOLON),
                //
                ValkyrieMicroNode,
                ValkyrieMacroNode,
                ValkyrieMezzoNode,
                //
                ValkyrieClassNode,
                ValkyrieTraitNode,
                //
                ValkyrieNamespaceNode,
                //
                ValkyrieSingletonNode,
                ValkyrieWidgetNode,
                ValkyrieNeuralNode,
            )
        }
    }
}
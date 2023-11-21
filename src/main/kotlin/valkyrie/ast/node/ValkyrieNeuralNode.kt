package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareNeural
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_NEURAL
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieNeuralNode(node: ASTNode) : ValkyrieClassNode(node) {
    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Neural
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return identifier
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareNeural(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "NeuralDeclaration"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseClass(builder, ParseKeywords(KW_NEURAL), DeclareNeural, false)
        }
    }
}



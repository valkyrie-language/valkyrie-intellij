package valkyrie.ast.node

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareClass
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_NEURAL
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import javax.swing.Icon

class ValkyrieNeuralDeclarationNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val keyword = findChildByClass(ValkyrieKeywordNode::class.java)!!
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)
    val superClasses = findChildByClass(ValkyrieInheritListNode::class.java)?.items ?: arrayOf()

    override val color: HighlightColor?
        get() = HighlightColor.SYM_CLASS

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Class
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
            return parseClass(builder, ValkyrieKeyword(KW_NEURAL), DeclareClass, false)
        }
    }
}



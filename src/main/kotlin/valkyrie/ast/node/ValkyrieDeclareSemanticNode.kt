package valkyrie.ast.node

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DefineField
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.parseDefaultValue
import valkyrie.psi.ValkyrieDeclaration
import javax.swing.Icon

class ValkyrieDeclareSemanticNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)!!

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return this.identifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareSemantic(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "ObjectField"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieAnnotationAreaNode.parse(builder)
            // 解析字段名
            if (!ValkyrieIdentifierNode.parse(builder)) {
                marker.rollbackTo()
                return false
            }
            parseDefaultValue(builder)
            marker.done(DefineField)
            return true
        }
    }
}


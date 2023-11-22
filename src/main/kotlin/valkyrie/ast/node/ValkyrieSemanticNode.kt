package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DefineSemantic
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.parser.parseDefaultValue
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import javax.swing.Icon

class ValkyrieSemanticNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)!!

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return this.identifier
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Semantic
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareSemantic(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "Semantic"
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
            marker.done(DefineSemantic)
            return true
        }
    }
}


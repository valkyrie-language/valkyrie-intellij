package valkyrie.ast.node

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DefineMethod
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.advanceIgnore
import valkyrie.psi.ValkyrieDeclaration
import javax.swing.Icon

class ValkyrieObjectMethodNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)!!

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return this.identifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Function
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareMethod(this)
            else -> visitor.visitElement(this)
        }
    }


    override fun toString(): String {
        return "ObjectMethod"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieAnnotationAreaNode.parse(builder)
            
            // 解析字段名
            if (ValkyrieIdentifierNode.parse(builder)) {
                
            } else {
                marker.drop()
                return false
            }
            // 解析形式参数
            if (ValkyrieParameterListNode.parse(builder)) {
                
            } else {
                marker.drop()
                return false
            }
            ValkyrieFunctionBodyNode.parse(builder)
            marker.done(DefineMethod)
            return true
        }
    }
}

package valkyrie.ast.node

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareSingleton
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_SINGLETON
import javax.swing.Icon

class ValkyrieSingletonDeclarationNode(node: ASTNode) : ValkyrieClassDeclarationNode(node) {
    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Static
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareSingleton(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "SingletonDeclaration"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseClass(builder, ValkyrieKeyword(KW_SINGLETON), DeclareSingleton, false)
        }
    }
}



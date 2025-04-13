package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareWidget
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_COMPONENT
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieWidgetDeclarationNode(node: ASTNode) : ValkyrieClassDeclarationNode(node) {
    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Widget
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return identifier
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareWidget(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "WidgetDeclaration"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseClass(builder, ParseKeywords(KW_COMPONENT), DeclareWidget, false)
        }
    }
}
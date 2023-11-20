package valkyrie.ast.node

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ValkyrieVisitor
import valkyrie.psi.ValkyrieElement
import javax.swing.Icon

class ValkyrieDeclareImplyNode(node: ASTNode) : ValkyrieElement(node) {
    val keyword = findChildByClass(ValkyrieKeywordNode::class.java)!!
    val namepath = findChildByClass(ValkyrieNamePathNode::class.java)

    override fun getName(): String {
        return this.namepath?.identifier?.name ?: "⟪anonymous imply⟫"
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.IdeaModule
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareImply(this)
            else -> visitor.visitElement(this)
        }
    }
}

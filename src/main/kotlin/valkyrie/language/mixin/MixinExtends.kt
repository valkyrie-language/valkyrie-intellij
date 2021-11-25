package valkyrie.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ViewableNode
import valkyrie.language.psi.ValkyrieContext
import valkyrie.language.psi_node.ValkyrieExtendsStatementNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import javax.swing.Icon

open class MixinExtends(node: ASTNode) : ViewableNode(node), ValkyrieContext {
    override fun getOriginalElement() = this as ValkyrieExtendsStatementNode

    val identifier: ValkyrieIdentifierNode
        get() {
            return originalElement.namepath.identifierList.last() as ValkyrieIdentifierNode
        }


    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.EntryPoints
    override fun getNavigationElement(): PsiElement {
        return this.originalElement
    }
}


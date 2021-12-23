package valkyrie.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.ast.DeclareNode
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi_node.ValkyrieExtensionStatementNode
import javax.swing.Icon

open class MixinExtension(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieExtensionStatementNode {
        return this as ValkyrieExtensionStatementNode
    }

    override fun getNameIdentifier(): ValkyrieASTBase {
        TODO("Not yet implemented")
    }

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Module

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}


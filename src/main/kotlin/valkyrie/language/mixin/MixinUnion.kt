package valkyrie.language.mixin

import valkyrie.language.ast.DeclareNode
import valkyrie.language.ast.ValkyrieASTBase
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.psi_node.ValkyrieUnionStatementNode
import javax.swing.Icon

open class MixinUnion(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieUnionStatementNode {
        return this as ValkyrieUnionStatementNode
    }

    override fun getNameIdentifier() = originalElement.modified.lastChild as ValkyrieIdentifierNode
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Enum

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}


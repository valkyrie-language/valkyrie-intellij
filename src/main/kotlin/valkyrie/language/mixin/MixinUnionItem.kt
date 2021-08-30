package valkyrie.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.ast.DeclareNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.psi_node.ValkyrieUnionItemNode
import javax.swing.Icon

open class MixinUnionItem(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement() = this as ValkyrieUnionItemNode;

    override fun getNameIdentifier() = originalElement.identifier as ValkyrieIdentifierNode
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Enum
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}


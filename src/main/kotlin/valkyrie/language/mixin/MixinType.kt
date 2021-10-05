package valkyrie.language.mixin

import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.ast.DeclareNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.psi_node.ValkyrieTypeStatementNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinType(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieTypeStatementNode {
        return this as ValkyrieTypeStatementNode
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return originalElement.genericType.identifier as ValkyrieIdentifierNode
    }

    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.TYPE

    override fun getPresentation(): ItemPresentation = PresentationData(
        this.nameIdentifier.name,
        "",
        getIcon(0),
        null
    )

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}


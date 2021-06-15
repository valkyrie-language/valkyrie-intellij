package valkyrie.language.mixin

import valkyrie.ide.file.ValkyrieIconProvider
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.DeclareNode
import valkyrie.language.ast.addChildrenView
import valkyrie.language.psi_node.ValkyrieClassDefineNode
import valkyrie.language.psi_node.ValkyrieClassItemNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.psi_node.ValkyrieObjectKeyNode

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinClassField(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieClassItemNode {
        return this as ValkyrieClassItemNode
    }

    override fun getNameIdentifier(): ValkyrieObjectKeyNode {
        return originalElement.objectKey as ValkyrieObjectKeyNode
    }

    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.FIELD

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}


package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.file.ValkyrieIconProvider
import valkyrie.language.ast.DeclareNode
import valkyrie.language.psi_node.ValkyrieClassFieldNode
import valkyrie.language.psi_node.ValkyrieObjectKeyNode
import javax.swing.Icon

open class MixinClassField(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement() = this as ValkyrieClassFieldNode

    override fun getNameIdentifier(): ValkyrieObjectKeyNode {
        return originalElement.objectKey as ValkyrieObjectKeyNode
    }

    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.FIELD

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}


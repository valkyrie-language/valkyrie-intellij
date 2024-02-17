package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.traits.HasTypeParameter

class ValkyrieGenericList(node: ASTNode) : ValkyrieElementNode(node), HasTypeParameter {
    override val typeParameters: List<ValkyrieTypeParameterItem>
        get() = TODO("Not yet implemented")
}

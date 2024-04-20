package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.traits.HasTypeParameter

class ValkyrieGenericList(node: ASTNode) : ValkyrieElementNode(node), HasTypeParameter {
    override val typeParameters: List<ValkyrieTypeParameterItem>
        get() = findChildrenByClass(ValkyrieTypeParameterItem::class.java).toList()
}

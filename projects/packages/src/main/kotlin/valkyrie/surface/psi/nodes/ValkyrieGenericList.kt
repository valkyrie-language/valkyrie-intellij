package valkyrie.surface.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.surface.parser.ValkyrieElementNode
import valkyrie.surface.traits.HasTypeParameter

class ValkyrieGenericList(node: ASTNode) : ValkyrieElementNode(node), HasTypeParameter {
    override val typeParameters: List<ValkyrieTypeParameterItem>
        get() = findChildrenByClass(ValkyrieTypeParameterItem::class.java).toList()
}

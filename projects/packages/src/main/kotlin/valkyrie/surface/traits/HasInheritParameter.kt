package valkyrie.surface.traits

import valkyrie.surface.psi.nodes.ValkyrieTermParameterItem
import valkyrie.surface.psi.nodes.ValkyrieTypeParameterItem

interface HasInheritParameter {
    /**
     * 惰性返回参数列表
     */
    val inheritParameters: List<ValkyrieTermParameterItem>
}
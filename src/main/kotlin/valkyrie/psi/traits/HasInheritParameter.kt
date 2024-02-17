package valkyrie.psi.traits

import valkyrie.psi.nodes.ValkyrieTermParameterItem
import valkyrie.psi.nodes.ValkyrieTypeParameterItem

interface HasInheritParameter {
    /**
     * 惰性返回参数列表
     */
    val inheritParameters: List<ValkyrieTermParameterItem>
}
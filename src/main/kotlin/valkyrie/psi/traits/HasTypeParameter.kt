package valkyrie.psi.traits

import valkyrie.psi.nodes.ValkyrieTermParameterItem

interface HasTypeParameter {
    /**
     * 惰性返回参数列表
     */
    val parameters: MutableList<ValkyrieTermParameterItem>
}

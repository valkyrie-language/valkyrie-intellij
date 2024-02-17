package valkyrie.psi.traits

import valkyrie.psi.nodes.ValkyrieTypeParameterItem

interface HasTypeParameter {
    /**
     * 惰性返回参数列表
     */
    val typeParameters: List<ValkyrieTypeParameterItem>
}


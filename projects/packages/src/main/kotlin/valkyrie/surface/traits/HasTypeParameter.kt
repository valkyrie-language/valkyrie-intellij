package valkyrie.surface.traits

import valkyrie.surface.psi.nodes.ValkyrieTypeParameterItem

interface HasTypeParameter {
    /**
     * 惰性返回参数列表
     */
    val typeParameters: List<ValkyrieTypeParameterItem>
}


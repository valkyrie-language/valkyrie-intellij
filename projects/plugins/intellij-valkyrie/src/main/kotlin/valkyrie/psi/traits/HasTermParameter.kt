package valkyrie.psi.traits

import valkyrie.psi.nodes.ValkyrieTermParameterItem

interface HasTermParameter {
    /**
     * 惰性返回参数列表
     */
    val termParameters: List<ValkyrieTermParameterItem>
}


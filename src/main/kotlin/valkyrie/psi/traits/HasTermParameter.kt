package valkyrie.psi.traits

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.ValkyrieTermParameterItem
import valkyrie.psi.nodes.ValkyrieTermParameterList

interface HasTermParameter {
    /**
     * 惰性返回参数列表
     */
    val parameters: List<ValkyrieTermParameterItem>
}


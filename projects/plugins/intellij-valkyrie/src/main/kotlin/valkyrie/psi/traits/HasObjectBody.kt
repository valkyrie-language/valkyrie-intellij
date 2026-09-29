package valkyrie.psi.traits

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.ValkyrieDomainDeclaration
import valkyrie.psi.nodes.ValkyrieFieldDeclaration
import valkyrie.psi.nodes.ValkyrieMethodDeclaration
import valkyrie.psi.nodes.ValkyrieObjectBodyNode

interface HasObjectBody {
    fun getObjectBody(): ValkyrieObjectBodyNode {
        return PsiTreeUtil.findChildOfType(
            this as PsiElement,
            ValkyrieObjectBodyNode::class.java
        )!!
    }

    val methods: List<ValkyrieMethodDeclaration>
        get() = getObjectBody().getMethods().filterNotNull()
    val fields: List<ValkyrieFieldDeclaration>
        get() = getObjectBody().getFields().filterNotNull()
    val domains: List<ValkyrieDomainDeclaration>
        get() = getObjectBody().getDomains().filterNotNull()
}

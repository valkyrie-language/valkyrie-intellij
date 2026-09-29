package vos.intellij.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import vos.intellij.language.ast.DeclareNode
import vos.intellij.language.file.VosIcons
import vos.intellij.language.psi_node.VosClassBoundNode
import vos.intellij.language.psi_node.VosIdentifierNode

open class MixinClassBound(node: ASTNode) : DeclareNode(node) {
    override fun getIcon(flags: Int) = VosIcons.BOUND
    override fun getOriginalElement() = this as VosClassBoundNode
    override fun getNameIdentifier() = originalElement.identifier as VosIdentifierNode

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}



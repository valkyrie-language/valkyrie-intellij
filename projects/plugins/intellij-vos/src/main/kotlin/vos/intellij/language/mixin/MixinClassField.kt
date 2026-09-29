package vos.intellij.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import vos.intellij.language.ast.DeclareNode
import vos.intellij.language.file.VosIcons
import vos.intellij.language.psi_node.VosClassFieldNode
import vos.intellij.language.psi_node.VosIdentifierNode

open class MixinClassField(node: ASTNode) : DeclareNode(node) {
    override fun getIcon(flags: Int) = VosIcons.FIELD
    override fun getOriginalElement() = this as VosClassFieldNode
    override fun getNameIdentifier() = originalElement.identifier as VosIdentifierNode
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}



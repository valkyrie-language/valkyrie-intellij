package vos.intellij.language.mixin

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import vos.intellij.ide.view.ViewElement
import vos.intellij.language.file.VosIcons
import vos.intellij.language.psi.searchChildrenOfType
import javax.swing.Icon

open class MixinArray(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun getOriginalElement(): vos.intellij.language.psi_node.VosArrayNode {
        return this as vos.intellij.language.psi_node.VosArrayNode
    }
    override fun getIcon(flags: Int): Icon = VosIcons.ANNOTATION

    fun getChildrenView(): Array<ViewElement> {
        return this.searchChildrenOfType(NavigatablePsiElement::class.java)
            .map { ViewElement(it) }
            .toTypedArray()
    }
}
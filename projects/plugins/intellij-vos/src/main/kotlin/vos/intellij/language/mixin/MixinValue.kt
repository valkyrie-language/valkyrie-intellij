package vos.intellij.language.mixin

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import vos.intellij.language.file.VosIcons
import vos.intellij.language.psi_node.VosValueNode
import javax.swing.Icon

open class MixinValue(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun getOriginalElement(): VosValueNode {
        return this as VosValueNode
    }
    override fun getIcon(flags: Int): Icon = VosIcons.ANNOTATION
}


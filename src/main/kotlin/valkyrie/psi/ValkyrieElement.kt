package valkyrie.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import javax.swing.Icon

open class ValkyrieElement(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.EmptyNode
    }

    override fun getIcon(flags: Int): Icon {
        return baseIcon
    }
}
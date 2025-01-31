package valkyrie.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.impl.source.tree.SharedImplUtil
import valkyrie.language.file.ValkyrieFileNode
import javax.swing.Icon

open class ValkyrieElement(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun getContainingFile(): ValkyrieFileNode? {
        return SharedImplUtil.findFileElement(node)?.psi as? ValkyrieFileNode
    }

    override fun getName(): String {
        return "⟪anonymous⟫"
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.EmptyNode
    }

    override fun getIcon(flags: Int): Icon {
        return baseIcon
    }
}


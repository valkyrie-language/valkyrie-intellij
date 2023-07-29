package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieUsingStatement
import javax.swing.Icon

abstract class MixinUsing(node: ASTNode) : ValkyrieElement(node), ValkyrieUsingStatement {
    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.NativeLibrariesFolder
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }
}
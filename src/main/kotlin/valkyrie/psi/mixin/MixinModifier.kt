package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieModifier
import javax.swing.Icon

abstract class MixinModifier(node: ASTNode) : ValkyrieElement(node), ValkyrieModifier {
    override fun getName(): String {
        return this.text.trim('`')
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Annotationtype
    }


    override fun getPresentation(): ItemPresentation {
        return PresentationData(name, "", baseIcon, null)
    }
}


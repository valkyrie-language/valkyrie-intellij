package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieExpressionTag
import javax.swing.Icon

abstract class MixinExpressionTag(node: ASTNode) : ValkyrieElement(node), ValkyrieExpressionTag {
    override fun getName(): String {
        return this.identifierFree?.text ?: ""
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }
}



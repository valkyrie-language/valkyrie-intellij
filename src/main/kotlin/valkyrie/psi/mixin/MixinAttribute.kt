package valkyrie.psi.mixin

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieAttributeItem

import javax.swing.Icon

abstract class MixinAttribute(node: ASTNode) : ValkyrieElement(node), ValkyrieAttributeItem {
    override fun getName(): String {
        return namepathFree.identifier?.text ?: "<<Missing Name>>"
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Attribute
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData(name, "", baseIcon, null)
    }
}



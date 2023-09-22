package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.ValkyrieTypes.KW_CLASS
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieNewValue
import javax.swing.Icon

abstract class MixinBuilder(node: ASTNode) : ValkyrieElement(node), ValkyrieNewValue {
    override fun getKeyword(): PsiElement {
        return findKeyword(KW_CLASS)
    }

    override fun getNavigationElement(): PsiElement {
        return this.keyword
    }

    override fun getName(): String {
        return "⟪anonymous object⟫"
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.ClassInitializer
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData(name, "", baseIcon, null)
    }
}



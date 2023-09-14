package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieLambdaStatement
import valkyrie.psi.node.ValkyrieNewLambda
import valkyrie.psi.node.ValkyrieNewValue
import javax.swing.Icon

abstract class MixinBuilder(node: ASTNode) : ValkyrieElement(node), ValkyrieNewValue {
    override fun getNavigationElement(): PsiElement {
        return this.firstChild
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


abstract class MixinLambda(node: ASTNode) : ValkyrieElement(node), ValkyrieLambdaStatement {
    override fun getNavigationElement(): PsiElement {
        return this.firstChild
    }


    override fun getName(): String {
        return "⟪anonymous function⟫"
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Lambda
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData(name, "", baseIcon, null)
    }
}
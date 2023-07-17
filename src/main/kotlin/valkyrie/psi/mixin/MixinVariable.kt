package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieLetPatternItemNode
import valkyrie.psi.node.ValkyrieLetStatement
import javax.swing.Icon

abstract class MixinVariable(node: ASTNode) : ValkyrieElement(node) {
    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Variable
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }
}

fun ValkyrieLetStatement.getVariableList(): List<ValkyrieLetPatternItemNode> {
    return this.letPattern?.letPatternItemList?.map { it as ValkyrieLetPatternItemNode } ?: emptyList()
}


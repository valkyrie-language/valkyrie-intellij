package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieCasePatternPair

import javax.swing.Icon

abstract class MixinCasePatternPair(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieCasePatternPair {

    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}
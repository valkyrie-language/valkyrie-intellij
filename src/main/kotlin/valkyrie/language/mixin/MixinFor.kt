package valkyrie.language.mixin

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi_node.ValkyrieForStatementNode
import valkyrie.language.psi_node.ValkyrieNormalPatternNode
import valkyrie.language.symbol.ValkyrieVariables

open class MixinFor(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getOriginalElement(): ValkyrieForStatementNode {
        return this as ValkyrieForStatementNode
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, null, getIcon(0), null)
    }

    fun getVariables(): ValkyrieVariables {
        val out = ValkyrieVariables()
        val normal = originalElement.normalPattern
        if (normal is ValkyrieNormalPatternNode) {
            out.extend(normal.getVariables())
        }
        return out
    }
}


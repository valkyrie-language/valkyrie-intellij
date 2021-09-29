package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi_node.ValkyrieNormalPatternNode
import valkyrie.language.symbol.ValkyrieVariables


open class MixinNormalPattern(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getOriginalElement() = this as ValkyrieNormalPatternNode;
    fun getVariables(): ValkyrieVariables {
        val out = ValkyrieVariables()
        for (item in originalElement.patternItemList) {
            out.insert(item.identifier, ValkyrieHighlightColor.SYM_LOCAL)
        }
        return out
    }
}


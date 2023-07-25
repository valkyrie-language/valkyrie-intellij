package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.highlight.HighlightColor
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes.KW_TRAIT
import valkyrie.psi.node.ValkyrieDeclareTrait
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon


abstract class MixinTrait(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareTrait {
    val keyword: PsiElement = findKeyword(KW_TRAIT)
    override val color: HighlightColor = HighlightColor.SYM_TRAIT

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Trait
    }


}



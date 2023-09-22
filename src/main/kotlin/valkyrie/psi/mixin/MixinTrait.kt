package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.highlight.HighlightColor
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes.KW_TRAIT
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareTrait
import javax.swing.Icon

abstract class MixinTrait(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareTrait {
    override val color: HighlightColor = HighlightColor.SYM_TRAIT
    override fun getKeyword(): PsiElement {
        return findKeyword(KW_TRAIT)
    }

    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Trait
    }
}

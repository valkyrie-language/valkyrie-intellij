package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.ValkyrieTypes.KW_FLAGS
import valkyrie.psi.ValkyrieTypes.KW_SINGLETON
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareFlags
import javax.swing.Icon

abstract class MixinFlags(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareFlags {
    override fun getKeyword(): PsiElement {
        return findKeyword(KW_FLAGS)
    }
    override fun getNavigationElement(): PsiElement {
        return this.identifierFree ?: this
    }

    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierFree as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Flags
    }
}
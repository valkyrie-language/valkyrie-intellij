package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.node.ValkyrieDeclareEnumerate
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinEnumerate(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareEnumerate {

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Enumeration
    }

    val keyword: PsiElement
        get() {
            return this.findKeyword(ValkyrieTypes.KW_ENUMERATE)
        }
}


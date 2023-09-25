package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareNamespace

import javax.swing.Icon

abstract class MixinNamespace(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareNamespace {
    override fun getNameIdentifier(): MixinIdentifier? {
        return this.namepathAuto?.lastChild as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Namespace
    }
}


val ValkyrieDeclareNamespace.keyword: PsiElement
    get() {
        return findKeyword(ValkyrieTypes.KW_NAMESPACE)
    }


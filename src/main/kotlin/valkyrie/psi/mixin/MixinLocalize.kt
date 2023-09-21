package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.reference.declaration.ValkyrieNamepathReference
import valkyrie.psi.ValkyrieElement

import valkyrie.psi.node.ValkyrieLocalizeCall

abstract class MixinLocalize(node: ASTNode) : ValkyrieElement(node), ValkyrieLocalizeCall {
    val identifier: MixinIdentifier? = identifierSafeList.lastOrNull() as? MixinIdentifier;


    override fun getNavigationElement(): PsiElement {
        return this
    }

    override fun getName(): String {
        return identifier?.name ?: "⟪anonymous localize⟫"
    }

    override fun getReference(): ValkyrieNamepathReference? {
        return references.lastOrNull()
    }

    override fun getReferences(): Array<ValkyrieNamepathReference> {
        return ValkyrieNamepathReference.fromList(this as MixinNamepath)
    }
}
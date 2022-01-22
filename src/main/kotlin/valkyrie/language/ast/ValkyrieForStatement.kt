package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement

class ValkyrieForStatement(node: CompositeElement) : ASTWrapperPsiElement(node) {

}

class ValkyrieForParameterItem(node: CompositeElement) : ASTWrapperPsiElement(node)    , PsiNameIdentifierOwner {
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement? {
        TODO("Not yet implemented")
    }

}
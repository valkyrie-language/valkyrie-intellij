package vos.intellij.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import vos.intellij.language.ast.DeclareNode
import javax.swing.Icon

open class MixinSchema(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getIcon(flags: Int): Icon {
        TODO("Not yet implemented")
    }

}



package valkyrie.psi.parsers

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class ValkyrieElementNode(node: ASTNode) : ASTWrapperPsiElement(node) {

    override fun getOriginalElement(): ValkyrieElementNode? {
        return this as ValkyrieElementNode
    }

    override fun findElementAt(offset: Int): PsiElement? {
        return super.findElementAt(offset)
    }

    override fun getNavigationElement(): PsiElement {
        return super.getNavigationElement()
    }

    override fun getElementIcon(flags: Int): Icon? {
        return super.getElementIcon(flags)
    }

}
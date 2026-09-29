package vos.intellij.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import vos.intellij.ide.view.ViewElement
import vos.intellij.language.ast.DeclareNode
import vos.intellij.language.file.VosIcons
import vos.intellij.language.psi.searchChildrenOfType
import vos.intellij.language.psi_node.VosClassStatementNode
import vos.intellij.language.psi_node.VosIdentifierNode

open class MixinClassStatement(node: ASTNode) : DeclareNode(node) {
    override fun getIcon(flags: Int) = VosIcons.CLASS
    override fun getOriginalElement() = this as VosClassStatementNode
    override fun getNameIdentifier() = originalElement.identifier as VosIdentifierNode
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
    override fun getChildrenView(): Array<ViewElement> {
        val out = mutableListOf<ViewElement>()
//        for (it in originalElement.modifiers.searchChildrenOfType(NavigatablePsiElement::class.java)) {
//            out.add(ViewElement(it, PresentationData("Modifier", it.text, VosIcons.ANNOTATION, null)))
//        }
        for (it in originalElement.classBlock.searchChildrenOfType(MixinClassBound::class.java)) {
            out.add(ViewElement(it))
        }
        for (it in originalElement.classBlock.searchChildrenOfType(MixinClassField::class.java)) {
            out.add(ViewElement(it))
        }
        return out.toTypedArray()
    }
}



package valkyrie.language.mixin

import valkyrie.ide.file.ValkyrieIconProvider
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.DeclareNode
import valkyrie.language.ast.addChildrenView
import valkyrie.language.psi_node.ValkyrieClassDefineNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinClassMethod(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieClassDefineNode {
        return this as ValkyrieClassDefineNode
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return originalElement.identifier as ValkyrieIdentifierNode
    }

    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.FUNCTION

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val childrenView: MutableList<ValkyrieViewElement> = mutableListOf()
        originalElement.addAnnotationView(childrenView)
        originalElement.modified.addChildrenView(childrenView)
        originalElement.defineTuple.addChildrenView(childrenView)
        originalElement.defineBlock.addChildrenView(childrenView)
        return childrenView.toTypedArray()
    }
}


package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.DeclareNode
import valkyrie.language.ast.addChildrenView
import valkyrie.language.psi.ValkyrieContext
import valkyrie.language.psi_node.ValkyrieClassMethodNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import javax.swing.Icon

open class MixinClassMethod(node: ASTNode) : DeclareNode(node), ValkyrieContext {
    override fun getOriginalElement() = this as ValkyrieClassMethodNode

    override fun getNameIdentifier() = originalElement.identifier as ValkyrieIdentifierNode

    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.FUNCTION

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val childrenView: MutableList<ValkyrieViewElement> = mutableListOf()
        originalElement.addAnnotationView(childrenView)
//        originalElement.modifiers.addChildrenView(childrenView)
        originalElement.defineTuple.addChildrenView(childrenView)
        originalElement.defineBlock.addChildrenView(childrenView)
        return childrenView.toTypedArray()
    }
}


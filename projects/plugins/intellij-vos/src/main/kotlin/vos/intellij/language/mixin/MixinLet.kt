package vos.intellij.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import vos.intellij.ide.view.ViewElement
import vos.intellij.language.ast.DeclareNode
import vos.intellij.language.file.VosIcons
import vos.intellij.language.psi_node.VosIdentifierNode
import vos.intellij.language.psi_node.VosLetStatementNode

open class MixinLet(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): VosLetStatementNode {
        return this as VosLetStatementNode
    }

    override fun getIcon(flags: Int) = when (this.firstChild.text) {
        "let", "val", "const" -> VosIcons.CONSTANT
        else -> VosIcons.MUTABLE
    }

    override fun getNameIdentifier(): VosIdentifierNode {
        return originalElement.identifier as VosIdentifierNode
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}



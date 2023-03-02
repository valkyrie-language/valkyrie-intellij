package valkyrie.language.ast.classes

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieGenericDeclarationItem(node: CompositeElement) : ASTWrapperPsiElement(node),
    PsiNameIdentifierOwner,
    ValkyrieHighlightElement {
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return ValkyrieIdentifierNode.find(this)
    }

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(p0: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun on_highlight(e: NodeHighlighter) {
        e.register(nameIdentifier, ValkyrieHighlightColor.SYM_GENERIC)
    }
}
package valkyrie.language.ast.classes

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.ExpUiIcons
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.ast.ValkyrieModifiedNode
import valkyrie.language.psi.ValkyrieHighlightElement
import javax.swing.Icon

class ValkyrieClassCustomNode(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement {
    val dsl by lazy { ValkyrieModifiedNode.findIdentifier(this)!! };
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };
    override fun on_highlight(e: NodeHighlighter) {
        e.register_modifiers(modifiers)
    }

    override fun getBaseIcon(): Icon {
        return ExpUiIcons.FileTypes.Json
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(dsl, baseIcon)
    }
}
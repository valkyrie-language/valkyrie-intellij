package valkyrie.language.ast.classes

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.ast.ValkyrieModifiedNode
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieTemplateStatement(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement {
    val parameters by lazy { ValkyrieIdentifierNode.findMany(this) }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) }
//    override fun getBaseIcon(): Icon {
//        return AllIcons.Actions.InlayRenameInNoCodeFilesActive
//    }

//    override fun getPresentation(): ItemPresentation {
//        return PresentationData("generic", null, this.baseIcon, null)
//    }

    override fun on_highlight(e: NodeHighlighter) {
        e.register_modifiers(modifiers)
        for (mod in parameters) {
            e.register(mod, ValkyrieHighlightColor.SYM_GENERIC)
        }
    }

}
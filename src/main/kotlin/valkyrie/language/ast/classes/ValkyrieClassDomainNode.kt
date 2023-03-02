package valkyrie.language.ast.classes

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.ExpUiIcons
import com.intellij.navigation.GotoRelatedItem
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.ast.ValkyrieModifiedNode
import valkyrie.language.psi.ValkyrieHighlightElement
import valkyrie.language.psi.ValkyrieLineMarkElement
import javax.swing.Icon

class ValkyrieClassDomainNode(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement, ValkyrieLineMarkElement {
    val custom by lazy { ValkyrieModifiedNode.findIdentifier(this)!! };
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };
    override fun on_highlight(e: NodeHighlighter) {
        e.register(custom, ValkyrieHighlightColor.SYM_MACRO)
        e.register_modifiers(modifiers)
    }

    override fun getBaseIcon(): Icon {
        return ExpUiIcons.FileTypes.Json
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(custom, baseIcon)
    }

    override fun on_line_mark(e: MutableCollection<in LineMarkerInfo<*>>) {
        val item = RelatedItemLineMarkerInfo(
            custom.firstChild,
            custom.textRange,
            baseIcon,
            null,
            null,
            GutterIconRenderer.Alignment.RIGHT // 下
        ) { mutableListOf(GotoRelatedItem(this)) };
        e.add(item)
    }
}
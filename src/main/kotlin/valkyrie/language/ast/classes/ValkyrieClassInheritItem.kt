package valkyrie.language.ast.classes

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.navigation.GotoRelatedItem
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.ast.ValkyrieModifiedNode
import valkyrie.language.psi.ValkyrieLineMarkElement
import javax.swing.Icon

class ValkyrieClassInheritItem(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieLineMarkElement {
    val inherit by lazy { ValkyrieModifiedNode.findIdentifier(this)!! }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };


    public override fun getBaseIcon(): Icon {
        return AllIcons.Gutter.OverridingMethod
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(inherit, this.baseIcon)
    }

    override fun on_line_mark(e: MutableCollection<in LineMarkerInfo<*>>) {
        val info = RelatedItemLineMarkerInfo(
            inherit.firstChild,
            inherit.textRange,
            baseIcon,
            null,
            null,
            GutterIconRenderer.Alignment.RIGHT // 上
        ) { mutableListOf(GotoRelatedItem(this)) }
        e.add(info)
    }


}
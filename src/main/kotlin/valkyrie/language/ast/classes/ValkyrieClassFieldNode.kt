package valkyrie.language.ast.classes

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.icons.AllIcons
import com.intellij.navigation.GotoRelatedItem
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.antlr.register
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.ast.ValkyrieModifiedNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieHighlightElement
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieClassFieldNode(node: CompositeElement) : ValkyrieScopeNode(node), PsiNameIdentifierOwner, ValkyrieHighlightElement {
    val field by lazy { ValkyrieModifiedNode.findIdentifier(this)!! }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };

    override fun getName(): String {
        return field.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return field
    }

    override fun isVisibilitySupported(): Boolean {
        return true;
    }

    override fun getBaseIcon(): Icon {
        for (m in modifiers) {
            if (m.name == "inherit") {
                return AllIcons.Gutter.OverridingMethod
            }
        }
        return ValkyrieIconProvider.Instance.Field
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(field, this.baseIcon)
    }

    fun getLineMark(): LineMarkerInfo<*> {
        return RelatedItemLineMarkerInfo(
            nameIdentifier.firstChild,
            nameIdentifier.textRange,
            baseIcon,
            null,
            null,
            GutterIconRenderer.Alignment.RIGHT // 下
        ) { mutableListOf(GotoRelatedItem(this)) }
    }

    override fun on_highlight(e: HighlightInfoHolder) {
        e.register(nameIdentifier, ValkyrieHighlightColor.SYM_FIELD)
        for (mod in modifiers) {
            e.register(mod, ValkyrieHighlightColor.MODIFIER)
        }
    }
}


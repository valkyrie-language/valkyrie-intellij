package valkyrie.language.ast

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
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieHighlightElement
import valkyrie.language.psi.ValkyrieLineMarkElement
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon


class ValkyrieClassMethodNode(node: CompositeElement) : ValkyrieScopeNode(node), PsiNameIdentifierOwner, ValkyrieLineMarkElement, ValkyrieHighlightElement {
    val method by lazy { ValkyrieModifiedNode.findIdentifier(this)!! }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };
    override fun getName(): String {
        return method.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }


    override fun getBaseIcon(): Icon {
        if (method.name == "constructor") {
            return AllIcons.Gutter.ImplementingMethod
        }
        for (m in modifiers) {
            if (m.name == "get" || m.name == "set") {
                return AllIcons.Nodes.Property
            }
        }
        return ValkyrieIconProvider.Instance.Method
    }


    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(method, this.baseIcon)
    }

    override fun getLineMark(): LineMarkerInfo<*> {
        return RelatedItemLineMarkerInfo(
            nameIdentifier.firstChild,
            nameIdentifier.textRange,
            baseIcon,
            null,
            null,
            GutterIconRenderer.Alignment.RIGHT // 上
        ) { mutableListOf(GotoRelatedItem(this)) }
    }

    override fun getNameIdentifier(): PsiElement {
        return method
    }

    override fun highlight(info: HighlightInfoHolder) {
        if (method.name == "constructor") {
            info.register(nameIdentifier, ValkyrieHighlightColor.KEYWORD)
        } else {
            info.register(nameIdentifier, ValkyrieHighlightColor.SYM_FUNCTION_SELF)
        }
        for (mod in modifiers) {
            info.register(mod, ValkyrieHighlightColor.MODIFIER)
        }
    }
}


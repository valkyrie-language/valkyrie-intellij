package valkyrie.language.ast

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.navigation.GotoRelatedItem
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.antlr.recursiveSearch
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieLineMarkElement
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon


class ValkyrieClassStatement(node: CompositeElement) : ValkyrieScopeNode(node), PsiNameIdentifierOwner, ValkyrieLineMarkElement {
    private val _identifier by lazy { ValkyrieIdentifierNode.find(this)!! }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };
    val inherits: Array<ValkyrieClassInheritItem> by lazy {
        val inherit = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_class_inherit);
        PsiTreeUtil.getChildrenOfType(inherit, ValkyrieClassInheritItem::class.java) ?: emptyArray()
    }

    override fun getName(): String {
        return _identifier.text;
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return _identifier;
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.CLASS
    }

    override fun getContainingFile(): ValkyrieFileNode {
        return super.getContainingFile() as ValkyrieFileNode
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(_identifier, this.baseIcon)
    }


    fun getFields(): Array<ValkyrieClassFieldNode> {
        val output = mutableListOf<ValkyrieClassFieldNode>();
        this.recursiveSearch {
            if (it is ValkyrieClassFieldNode) {
                output.add(it);
                false
            } else {
                true
            }
        }
        return output.toTypedArray()
    }

    override fun getLineMark(): LineMarkerInfo<*> {
        return RelatedItemLineMarkerInfo(

            nameIdentifier.firstChild,
            nameIdentifier.textRange,
            AllIcons.Gutter.OverridenMethod,
            null,
            null,
            GutterIconRenderer.Alignment.RIGHT // 上
        ) { mutableListOf(GotoRelatedItem(this)) }
    }
}


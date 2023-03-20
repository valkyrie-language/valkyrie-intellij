package valkyrie.language.ast.classes

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
import valkyrie.ide.formatter.ValkyrieRewriter
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.antlr.traversal
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.ast.ValkyrieModifiedNode
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieHighlightElement
import valkyrie.language.psi.ValkyrieLineMarkElement
import valkyrie.language.psi.ValkyrieRewritableElement
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon


class ValkyrieClassStatement(node: CompositeElement) : ValkyrieScopeNode(node), PsiNameIdentifierOwner, ValkyrieLineMarkElement,
    ValkyrieHighlightElement, ValkyrieRewritableElement {
    private val _identifier = ValkyrieIdentifierNode.find(this)!!
    val modifiers = ValkyrieModifiedNode.findModifiers(this)
    val inherits: Array<ValkyrieClassInheritItem> = run {
        val inherit = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_class_inherit);
        PsiTreeUtil.getChildrenOfType(inherit, ValkyrieClassInheritItem::class.java) ?: emptyArray()
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return _identifier;
    }


    override fun getName(): String {
        return _identifier.text;
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
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
        this.traversal {
            if (it is ValkyrieClassFieldNode) {
                output.add(it);
                false
            } else {
                true
            }
        }
        return output.toTypedArray()
    }

    override fun on_highlight(e: NodeHighlighter) {
        e.register(nameIdentifier, ValkyrieHighlightColor.SYM_CLASS)
        e.register_modifiers(modifiers)
    }

    override fun on_rewrite(e: ValkyrieRewriter) {
        for (field in getFields()) {
            e.fixDelimiter(field, e.settings.class_field_trailing)
        }
    }

    override fun on_line_mark(e: MutableCollection<in LineMarkerInfo<*>>) {
        val info = RelatedItemLineMarkerInfo(
            nameIdentifier.firstChild,
            nameIdentifier.textRange,
            AllIcons.Gutter.OverridenMethod,
            null,
            null,
            GutterIconRenderer.Alignment.RIGHT // 上
        ) { mutableListOf(GotoRelatedItem(this)) }
        e.add(info)
    }
}


package valkyrie.language.ast

import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.language.psi.ValkyrieRewritableElement
import valkyrie.ide.formatter.ValkyrieRewriter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.antlr.register
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieHighlightElement
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieUnionStatement(node: CompositeElement) : ValkyrieScopeNode(node), PsiNameIdentifierOwner, ValkyrieHighlightElement,
    ValkyrieRewritableElement {
    private val _identifier by lazy { ValkyrieIdentifierNode.find(this)!! }

    override fun getName(): String {
        return _identifier.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return _identifier
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.UNION
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(_identifier, this.baseIcon)
    }

    override fun highlight(info: HighlightInfoHolder) {
        info.register(nameIdentifier, ValkyrieHighlightColor.SYM_CLASS)
    }

    override fun rewrite(w: ValkyrieRewriter) {
        w.fixDelimiter(this, w.settings.union_trailing)
//        for (field in union_fields) {
//            w.fixDelimiter(field, w.settings.union_item_field_trailing)
//        }
    }
}


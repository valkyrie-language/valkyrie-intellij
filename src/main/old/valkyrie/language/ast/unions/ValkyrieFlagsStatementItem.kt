package valkyrie.language.ast.unions

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.formatting.Alignment
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import valkyrie.ide.formatter.ValkyrieRewriter
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieAlignmentElement
import valkyrie.language.psi.ValkyrieHighlightElement
import valkyrie.language.psi.ValkyrieRewritableElement
import javax.swing.Icon

class ValkyrieFlagsStatementItem(node: CompositeElement, type: IElementType) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner,
    ValkyrieHighlightElement, ValkyrieAlignmentElement, ValkyrieRewritableElement {
    private val _identifier = findChildByClass(ValkyrieIdentifierNode::class.java)!!;


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
        return ValkyrieIconProvider.Instance.Field
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(_identifier, this.baseIcon)
    }

    override fun on_highlight(e: NodeHighlighter) {
        e.register(nameIdentifier, ValkyrieHighlightColor.SYM_FIELD)
    }

    override fun on_alignment(child: ASTNode): Alignment? {
        if (child.text == "=") {
            return Alignment.createAlignment()
        }
        return null
    }

    override fun on_rewrite(e: ValkyrieRewriter) {
        e.fixDelimiter(this, e.settings.flags_trailing)
    }
}
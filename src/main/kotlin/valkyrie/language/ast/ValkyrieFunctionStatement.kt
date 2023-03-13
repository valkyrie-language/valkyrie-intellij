package valkyrie.language.ast

//import valkyrie.language.psi.ValkyrieGenericDefine
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieHighlightElement
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieFunctionStatement : ValkyrieScopeNode, PsiNameIdentifierOwner, ValkyrieHighlightElement {
    constructor(node: CompositeElement) : super(node)

    val namepath by lazy { ValkyrieModifiedNode.findIdentifier(this) }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };
    override fun getName(): String {
        return namepath?.name ?: "[Unknown Function]"
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return namepath
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Function
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(namepath, this.baseIcon)
    }


    override fun on_highlight(e: NodeHighlighter) {
        e.register(nameIdentifier, ValkyrieHighlightColor.SYM_FUNCTION_FREE)
        e.register_modifiers(modifiers)
    }
}


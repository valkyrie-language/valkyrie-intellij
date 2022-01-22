package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.impl.source.tree.CompositeElement
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.recursiveSearch
import javax.swing.Icon

class ValkyrieClassStatement(node: CompositeElement) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner, ScopeNode {
    private val _identifier by lazy { ValkyrieIdentifierNode.find(this)!! }

    override fun getName(): String {
        return _identifier.text
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return _identifier;
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.CLASS
    }

    override fun getContainingFile(): ValkyrieFileNode {
        return super.getContainingFile() as ValkyrieFileNode
    }

    override fun getContext(): ScopeNode? {
        return parentScope
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(_identifier, this.getIcon(0))
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(this, ValkyrieLanguage, element, "/script/class/ID");
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
}


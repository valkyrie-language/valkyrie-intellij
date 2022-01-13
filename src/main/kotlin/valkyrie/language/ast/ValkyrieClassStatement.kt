package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.ide.view.NamepathPresentation
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.recursiveSearch
import javax.swing.Icon

class ValkyrieClassStatement(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ScopeNode {
    private val _identifier: ValkyrieNamepathNode = findChildByClass(ValkyrieNamepathNode::class.java)!!;

    override fun getName(): String {
        return _identifier.text
    }

    override fun getContainingFile(): ValkyrieFileNode {
        return super.getContainingFile() as ValkyrieFileNode
    }

    override fun getNameIdentifier(): ValkyrieNamepathNode {
        return _identifier;
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.CLASS
    }

    override fun getPresentation(): ItemPresentation {
        return NamepathPresentation(_identifier, this.getIcon(0))
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


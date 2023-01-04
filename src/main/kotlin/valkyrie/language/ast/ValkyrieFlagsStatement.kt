package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import valkyrie.ide.view.NamepathPresentation
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieFlagsStatement(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ValkyrieScopeNode {
    private val _identifier: ValkyrieNamepathNode = findChildByClass(ValkyrieNamepathNode::class.java)!!;

    override fun getName(): String {
        return _identifier.name
    }

    override fun getNameIdentifier(): ValkyrieNamepathNode {
        return _identifier
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.CLASS
    }

    override fun getPresentation(): ItemPresentation {
        return NamepathPresentation(_identifier, this.getIcon(0))
    }


}


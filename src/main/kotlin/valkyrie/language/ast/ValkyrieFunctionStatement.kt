package valkyrie.language.ast

//import valkyrie.language.psi.ValkyrieGenericDefine
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieFunctionStatement(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ScopeNode {
    val namepath by lazy { ValkyrieNamepathNode.find(this)!! }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };
    override fun getName(): String {
        return namepath.nameIdentifier.name
    }
    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return namepath.nameIdentifier
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.FUNCTION
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(namepath.nameIdentifier, this.getIcon(0))
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(this, ValkyrieLanguage, element, "/script/function/ID");
    }
}


package valkyrie.language.ast

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieIconProvider
//import valkyrie.language.psi.ValkyrieGenericDefine
import javax.swing.Icon

class ValkyrieFunctionDeclaration(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ScopeNode {
    override fun getName(): String {
        return "function B"
    }
    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.FUNCTION
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData(name, name, this.getIcon(0), null)
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(this, ValkyrieLanguage, element, "/script/function/ID");
    }
}
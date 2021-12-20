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
import valkyrie.language.psi.ValkyrieGenericDefine
import javax.swing.Icon

class ValkyrieTraitDeclaration(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ScopeNode {
    private val _identifier: ValkyrieNamepathNode = findChildByClass(ValkyrieNamepathNode::class.java)!!;

    override fun getName(): String {
        return _identifier.text
    }
    override fun getNameIdentifier(): ValkyrieNamepathNode {
        return _identifier
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.TRAIT
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData(_identifier.name, _identifier.namespace, this.getIcon(0), null)
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(this, ValkyrieLanguage, element, "/script/trait/ID");
    }
}


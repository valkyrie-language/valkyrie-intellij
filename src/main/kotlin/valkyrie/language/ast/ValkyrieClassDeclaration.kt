package valkyrie.language.ast

import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieGenericDefine
import javax.swing.Icon

class ValkyrieClassDeclaration(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ScopeNode {
    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieGenericDefine::class.java)
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.CLASS
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(this, ValkyrieLanguage, element, "/script/class/ID");
    }

    override fun getPresentation(): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String {
               return "class getPresentableText"
            }

            override fun getLocationString(): String {
                return "class getLocationString"
            }

            override fun getIcon(unused: Boolean): Icon {
                return getIcon(0)
            }
        }
    }
}

class ValkyrieProgramNode(node: ASTNode, type: IElementType) : ANTLRPsiNode(node) {

}


class ValkyrieKeywordNode(type: IElementType?, text: CharSequence?) : ANTLRPsiLeafNode(type, text) {

}
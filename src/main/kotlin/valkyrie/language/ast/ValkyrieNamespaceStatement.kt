package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieNamespaceStatement(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ValkyrieScopeNode {
    val namepath by lazy { ValkyrieNamepathNode.find(this)!! }

    override fun getName(): String {
        return namepath.identifiers.joinToString(".") { it.text }
    }

    val namespace: Array<String>
        get() {
            return arrayOf()
        }


    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return namepath.nameIdentifier
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.TRAIT
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        return SymtabUtils.resolve(this, ValkyrieLanguage, element, "/script/trait/ID");
    }

    fun isTestFile(): Boolean {
        return false;
    }
}
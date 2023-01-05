package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieNamespaceStatement(node: CompositeElement, type: IElementType) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner {
    val namepath by lazy { ValkyrieNamepathNode.find(this)!! }

    override fun getName(): String {
        return namepath.identifiers.joinToString(".") { it.text }
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
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

//    override fun resolve(element: PsiNamedElement?): PsiElement? {
//        return SymtabUtils.resolve(this, ValkyrieLanguage, element, "/script/trait/ID");
//    }

    fun isTestFile(): Boolean {
        return false;
    }
}
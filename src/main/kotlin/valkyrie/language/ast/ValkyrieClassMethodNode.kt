package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieClassMethodNode(node: ASTNode) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner, ScopeNode {
    val method by lazy { ModifiedNamepath.findIdentifier(this) }
    val modifiers by lazy { ModifiedNamepath.findModifiers(this) };
    override fun getName(): String {
        return method.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.FUNCTION
    }


    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(method, this.getIcon(0))
    }

    override fun getNameIdentifier(): PsiElement {
        return method
    }


    override fun getContext(): ScopeNode? {
        return parentScope
    }


    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }


}
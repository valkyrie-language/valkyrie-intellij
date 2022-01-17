package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon


class ValkyrieClassFieldNode(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ScopeNode {
    val field by lazy { ModifiedIdentifier.findIdentifier(this) }
    val modifiers by lazy { ModifiedIdentifier.findModifiers(this) };

    override fun getName(): String {
        return field.name
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return field
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.FIELD
    }


    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(field, this.getIcon(0))
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }
}


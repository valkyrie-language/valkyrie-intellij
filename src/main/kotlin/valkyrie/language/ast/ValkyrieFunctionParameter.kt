package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.ScopeNode

class ValkyrieFunctionParameter(node: ASTNode, type: IElementType) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner {
    val parameter by lazy { ModifiedIdentifier.findIdentifier(this) }
    val modifiers by lazy { ModifiedIdentifier.findModifiers(this) };

    override fun getName(): String {
        return this.parameter.text
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return this.parameter
    }

    override fun getContext(): ScopeNode? {
        return parentScope
    }
}



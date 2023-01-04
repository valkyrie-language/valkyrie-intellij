package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.language.antlr.parentScope
import valkyrie.language.psi.ValkyrieScopeNode

class ValkyrieLetStatement(node: ASTNode) : ASTWrapperPsiElement(node), ValkyrieScopeNode {

    override fun getContext(): ScopeNode? {
        return parentScope
    }


}



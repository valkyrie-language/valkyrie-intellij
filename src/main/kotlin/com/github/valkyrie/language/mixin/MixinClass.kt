package com.github.valkyrie.language.mixin

import com.github.valkyrie.ValkyrieLanguage
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi.ValkyrieElementType
import com.github.valkyrie.language.psi.ValkyrieStub
import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.StubBasedPsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.util.ArrayFactory
import javax.swing.Icon

// PsiReference
open class MixinClass(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieClassStatementNode {
        return this as ValkyrieClassStatementNode
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return originalElement.identifier as ValkyrieIdentifierNode
    }
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Class

    override fun setName(name: String): PsiElement {
        return this.nameIdentifier
    }

    override fun getResolveScope(): GlobalSearchScope {
        return super.getResolveScope()
    }

    override fun getUseScope(): SearchScope {
        return super.getUseScope()
    }
}


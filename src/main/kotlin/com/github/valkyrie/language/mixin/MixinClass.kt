package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.reference.ValkyrieReference
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.ast.addChildrenView
import com.github.valkyrie.language.psi_node.ValkyrieClassDefineNode
import com.github.valkyrie.language.psi_node.ValkyrieClassItemNode
import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.github.valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiTreeUtil
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
    override fun getChildrenSymbol(name: List<String>): ValkyrieASTBase? {
        if (name.isEmpty()) return this
        return PsiTreeUtil
            .getChildrenOfAnyType(
                this,
                ValkyrieClassItemNode::class.java,
                ValkyrieClassDefineNode::class.java,
            )
            .filter { it.name == name.first() }
            .firstNotNullOfOrNull { it.getChildrenSymbol(name.drop(1)) }
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val childrenView: MutableList<ValkyrieViewElement> = mutableListOf()
        originalElement.addAnnotationView(childrenView)
        originalElement.modified.addChildrenView(childrenView)
        originalElement.classTuple?.addChildrenView(childrenView)
        originalElement.classBlock?.addChildrenView(childrenView)
        return childrenView.toTypedArray()
    }
}


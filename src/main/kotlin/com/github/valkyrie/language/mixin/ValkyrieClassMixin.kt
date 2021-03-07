package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieStructureViewElement
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.github.valkyrie.language.psi.ValkyrieTaggedItem
import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolDeclarationProvider
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.util.TextRange
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.containers.map2Array
import javax.swing.Icon

// PsiReference
abstract class ValkyrieClassMixin(node: ASTNode) : ViewableNode(node),
    PsiNameIdentifierOwner,
    PsiSymbolDeclarationProvider,
    ValkyrieClassStatement {
    override fun getName(): String = this.nameIdentifier.text
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement = this.modifiers.lastChild
    override fun getNavigationElement(): PsiElement = this.nameIdentifier

    override val viewName: String = this.nameIdentifier.text;
    override val viewIcon: Icon = AllIcons.Nodes.Class;
    override fun addChildrenView() {
        PsiTreeUtil.getChildrenOfTypeAsList(
            this.classTuple,
            NavigatablePsiElement::class.java
        ).forEach {
            if (it is ValkyrieTaggedItem) {
                val kind = ValkyriePresentationItem(it.symbol.text, AllIcons.Nodes.Variable)
                this.childrenView.add(ValkyrieStructureViewElement(it, kind))
            }
        }
        PsiTreeUtil.getChildrenOfTypeAsList(
            this.classBrace,
            NavigatablePsiElement::class.java
        ).forEach {
            if (it is ValkyrieTaggedItem) {
                val kind = ValkyriePresentationItem(it.symbol.text, AllIcons.Nodes.Variable)
                this.childrenView.add(ValkyrieStructureViewElement(it, kind))
            }
        }
    }

    override fun getDeclarations(element: PsiElement, offsetInElement: Int):
            MutableCollection<out PsiSymbolDeclaration> = mutableSetOf(ClassDeclaration(this.nameIdentifier))

    class ClassDeclaration(var e: PsiElement) : PsiSymbolDeclaration {
        override fun getDeclaringElement(): PsiElement {
            return e
        }

        override fun getRangeInDeclaringElement(): TextRange {
            return e.textRange
        }

        override fun getSymbol(): Symbol {
            TODO("Not yet implemented")
        }
    }


}


package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieStructureViewElement
import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
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

// PsiReference
abstract class ValkyrieClassMixin(node: ASTNode) : ValkyrieElement(node),
    PsiNameIdentifierOwner,
    PsiSymbolDeclarationProvider,
    NavigatablePsiElement,
    ValkyrieClassStatement {
    override fun getName(): String = this.nameIdentifier.text
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement = this.modifiers.lastChild
    override fun getNavigationElement(): PsiElement = this.nameIdentifier



    override fun getPresentation(): ItemPresentation = ValkyriePresentationItem(
        this.modifiers.lastChild.text,
        AllIcons.Nodes.Class
    )

    fun getChildrenView(): Array<TreeElement> {
        if (this.classBrace == null) {
            val properties: List<NavigatablePsiElement> = PsiTreeUtil.getChildrenOfTypeAsList(
                this.classBrace, NavigatablePsiElement::class.java
            )
            return properties.map2Array {
                ValkyrieStructureViewElement(it)
            }
        }
        else {
            val properties: List<NavigatablePsiElement> = PsiTreeUtil.getChildrenOfTypeAsList(
                this.classTuple, NavigatablePsiElement::class.java
            )
            return properties.map2Array {
                ValkyrieStructureViewElement(it)
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


package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieStructureViewElement
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.*
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolDeclarationProvider
import com.intellij.openapi.util.TextRange
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
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
        when {
            this.classBrace != null -> this.addChildrenViewBrace()
            else -> this.addChildrenViewTuple()
        }
    }

    private fun addChildrenViewTuple() {
        for (item in PsiTreeUtil.getChildrenOfTypeAsList(this.classTuple, NavigatablePsiElement::class.java)) {
            if (item is ValkyrieClassTupleItem) {
//                val index = item.classNumericKey;
//                if (index != null) {
//                    val kind = ValkyriePresentationItem(index.text, AllIcons.Nodes.Variable)
//                    this.childrenView.add(ValkyrieStructureViewElement(item, kind))
//                    continue
//                }
//                val mods = item.modifiers;
//                if (mods != null) {
//                    val kind = ValkyriePresentationItem(mods.lastChild.text, AllIcons.Nodes.Variable)
//                    this.childrenView.add(ValkyrieStructureViewElement(item, kind))
//                    continue
//                }
            }
        }
    }

    private fun addChildrenViewBrace() {
        for (item in PsiTreeUtil.getChildrenOfTypeAsList(this.classBrace, NavigatablePsiElement::class.java)) {
            if (item is ValkyrieClassBraceItem) {
                val index = item.classNumericKey;
                if (index != null) {
                    val kind = ValkyriePresentationItem(index.text, AllIcons.Nodes.Variable)
                    this.childrenView.add(ValkyrieStructureViewElement(item, kind))
                    continue
                }
                val mods = item.modifiers;
                if (mods != null) {
                    val kind = ValkyriePresentationItem(mods.lastChild.text, AllIcons.Nodes.Variable)
                    this.childrenView.add(ValkyrieStructureViewElement(item, kind))
                    continue
                }
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


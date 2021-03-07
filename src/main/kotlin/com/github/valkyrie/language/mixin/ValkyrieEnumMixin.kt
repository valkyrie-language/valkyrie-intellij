package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieStructureViewElement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.github.valkyrie.language.psi.ValkyrieTaggedStatement
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyrieTaggedItem
import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.containers.map2Array
import javax.swing.Icon

abstract class ValkyrieEnumMixin(node: ASTNode) : ViewableNode(node),
    ValkyrieTaggedStatement {
    override val viewName: String = this.navigationElement.text;
    override val viewIcon: Icon = AllIcons.Nodes.Enum;
    override fun getNavigationElement(): PsiElement = this.modifiers.lastChild

    override fun addChildrenView() {
        PsiTreeUtil.getChildrenOfTypeAsList(
            this.taggedBlock,
            NavigatablePsiElement::class.java
        ).forEach {
            if (it is ValkyrieTaggedItem) {
                val kind = ValkyriePresentationItem(it.symbol.text, AllIcons.Nodes.Variable)
                this.childrenView.add(ValkyrieStructureViewElement(it, kind))
            }
//            else {
//                val kind = ValkyriePresentationItem("variant", AllIcons.Nodes.EntryPoints)
//                this.childrenView.add(ValkyrieStructureViewElement(it, kind))
//            }
        }
    }
}


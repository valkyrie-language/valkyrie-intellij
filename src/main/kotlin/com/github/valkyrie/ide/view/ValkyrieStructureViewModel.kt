package com.github.valkyrie.ide.view


import com.github.valkyrie.language.psi.ValkyrieBitflagStatement
import com.intellij.ide.structureView.StructureViewModel.ElementInfoProvider
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.psi.PsiFile


class ValkyrieStructureViewModel(psiFile: PsiFile?) :
    StructureViewModelBase(psiFile!!, ValkyrieStructureViewElement(psiFile)),
    ElementInfoProvider {
    override fun getSorters(): Array<Sorter> {
        return arrayOf(Sorter.ALPHA_SORTER)
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        return element.value is ValkyrieBitflagStatement
    }
}


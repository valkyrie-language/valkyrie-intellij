package com.github.valkyrie.ide.view


import com.github.valkyrie.ide.view.filter.PublicElementsFilter
import com.intellij.ide.structureView.StructureViewModel.ElementInfoProvider
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.Grouper
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.psi.PsiFile


class ValkyrieStructureViewModel(psiFile: PsiFile?) :
    StructureViewModelBase(psiFile!!, ValkyrieStructureViewElement(psiFile)),
    ElementInfoProvider {
    override fun getSorters(): Array<Sorter> {
        return arrayOf(Sorter.ALPHA_SORTER)
    }
    override fun getFilters(): Array<Filter> {
        return arrayOf(PublicElementsFilter)
    }

    override fun getGroupers(): Array<Grouper> {
        return Grouper.EMPTY_ARRAY
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        // return element.value is ValkyrieBitflagStatement
        return false
    }


}


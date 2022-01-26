package valkyrie.ide.view

import com.intellij.ide.structureView.*
import com.intellij.ide.structureView.StructureViewModel.ElementInfoProvider
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import valkyrie.ide.view.filter.MainInfoFilter
import valkyrie.ide.view.filter.PublicElementsFilter
import valkyrie.ide.view.grouper.PropertiesGrouper

class StructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile): Builder {
        return Builder(psiFile)
    }

    class Builder : TreeBasedStructureViewBuilder {
        private val psiFile: PsiFile

        constructor(psiFile: PsiFile) : super() {
            this.psiFile = psiFile
        }

        override fun createStructureViewModel(editor: Editor?): StructureViewModel {
            return Model(psiFile)
        }

        override fun createStructureView(fileEditor: FileEditor?, project: Project): StructureView {
            return super.createStructureView(fileEditor, project)
        }

        override fun isRootNodeShown(): Boolean {
            return true;
        }
    }

    class Model : StructureViewModelBase, ElementInfoProvider {
        private var mySorters = Sorter.EMPTY_ARRAY
        constructor(psiFile: PsiFile?) : super(psiFile!!, ValkyrieViewElement(psiFile))

        override fun getSorters() = arrayOf(Sorter.ALPHA_SORTER)

        override fun withSorters(vararg sorters: Sorter?): StructureViewModelBase {
            return super.withSorters(*sorters)
        }

        override fun getFilters() = arrayOf(PublicElementsFilter, MainInfoFilter)

        override fun getGroupers() = arrayOf(PropertiesGrouper)

        override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean {
            return false
        }

        override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
            // return element.value is ValkyrieBitflagStatement
            return false
        }

        override fun getCurrentEditorElement(): Any? {
            return super.getCurrentEditorElement()
        }


    }

}


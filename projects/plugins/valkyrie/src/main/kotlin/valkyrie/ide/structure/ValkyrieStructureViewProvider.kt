package valkyrie.ide.structure

import com.intellij.ide.structureView.*
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import valkyrie.psi.nodes.ValkyrieFileNode

/**
 * Valkyrie 结构视图提供器
 * 为 Valkyrie 文件提供结构化的代码大纲视图
 */
class ValkyrieStructureViewProvider : PsiStructureViewFactory {
    
    override fun getStructureViewBuilder(psiFile: PsiFile): StructureViewBuilder? {
        if (psiFile !is ValkyrieFileNode) return null
        
        return object : TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?): StructureViewModel {
                return ValkyrieStructureViewModel(psiFile, editor)
            }
        }
    }
}

/**
 * Valkyrie 结构视图模型
 */
class ValkyrieStructureViewModel(
    psiFile: PsiFile,
    editor: Editor?
) : StructureViewModelBase(psiFile, editor, ValkyrieStructureViewElement(psiFile)),
    StructureViewModel.ElementInfoProvider {
    
    override fun getSorters(): Array<Sorter> {
        return arrayOf(Sorter.ALPHA_SORTER)
    }
    
    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean {
        return false
    }
    
    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        return element is ValkyrieStructureViewElement && element.isLeaf()
    }
    
    override fun getFilters(): Array<Filter> {
        return arrayOf(
            ValkyrieStructureViewFilters.SHOW_FIELDS,
            ValkyrieStructureViewFilters.SHOW_METHODS,
            ValkyrieStructureViewFilters.SHOW_PRIVATE
        )
    }
}


package valkyrie.ide.view.hierarchy

import com.intellij.ide.hierarchy.*
import com.intellij.ide.util.treeView.NodeDescriptor
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.ui.dsl.builder.panel
import java.util.*
import javax.swing.JPanel
import javax.swing.JTree


class TypeHierarchyProvider : HierarchyProvider {
    override fun getTarget(dataContext: DataContext): PsiElement? {
        // no need jump to the class declaration
        return LangDataKeys.PSI_ELEMENT.getData(dataContext)
    }

    override fun createHierarchyBrowser(target: PsiElement): HierarchyBrowser {
        return TypeHierarchyBrowser(target)
    }

    override fun browserActivated(hierarchyBrowser: HierarchyBrowser) {

    }
}

private class TypeHierarchyBrowser(element: PsiElement) : TypeHierarchyBrowserBase(element.project, element) {
    private var myDescriptor: HierarchyNodeDescriptor? = null;
    override fun getElementFromDescriptor(descriptor: HierarchyNodeDescriptor): PsiElement? {
        myDescriptor = descriptor;
        return myDescriptor?.psiElement;
    }

    override fun createTrees(trees: MutableMap<in String, in JTree>) {
        println("createTrees($trees)")
    }

    override fun createLegendPanel(): JPanel? {
        return panel {
            row {
                label("Panel below")
            }
        }
    }

    override fun isApplicableElement(element: PsiElement): Boolean {
        return true
    }

    override fun createHierarchyTreeStructure(type: String, psiElement: PsiElement): HierarchyTreeStructure {
        return TypeHierarchyTree(psiElement.project, myDescriptor)
    }

    override fun getComparator(): Comparator<NodeDescriptor<*>>? {
        return null
    }

    override fun isInterface(psiElement: PsiElement): Boolean {
        return Random().nextBoolean()
    }

    override fun canBeDeleted(psiElement: PsiElement?): Boolean {
        return Random().nextBoolean()
    }

    override fun getQualifiedName(psiElement: PsiElement?): String {
        if (psiElement != null) {
            return psiElement.text
        }
        return "getQualifiedName"
    }
}

private class TypeHierarchyTree(project: Project, baseDescriptor: HierarchyNodeDescriptor?) :
    HierarchyTreeStructure(project, baseDescriptor) {
    override fun buildChildren(descriptor: HierarchyNodeDescriptor): Array<Any> {
        println("buildChildren($descriptor)")
        return arrayOf()
    }

    override fun isAlwaysShowPlus(): Boolean {
        return true
    }

    override fun isAlwaysLeaf(element: Any): Boolean {
        println("isAlwaysLeaf($element)")
        return false
    }

    override fun formatBaseElementText(): String {
        return super.formatBaseElementText()
    }

}
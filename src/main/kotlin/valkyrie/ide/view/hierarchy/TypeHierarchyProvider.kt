package valkyrie.ide.view.hierarchy

import com.intellij.ide.hierarchy.*
import com.intellij.ide.util.treeView.NodeDescriptor
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.psi.PsiElement
import com.intellij.psi.util.parents
import valkyrie.language.ast.ValkyrieClassStatement
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

private class TypeHierarchyBrowser : TypeHierarchyBrowserBase {
    private var _descriptor: HierarchyNodeDescriptor? = null;
    private val _element: PsiElement

    constructor(element: PsiElement) : super(element.project, element) {
        this._element = element
    }

    override fun createLegendPanel(): JPanel? {
        return null;
    }

    override fun getAvailableElements(): Array<PsiElement> {
        println("getAvailableElements")
        return super.getAvailableElements()
    }

    override fun createTrees(trees: MutableMap<in String, in JTree>) {
        trees["Class {0}"] = createTree(true)
        trees["Supertypes of {0}"] = createTree(false)
        trees["Subtypes of {0}"] = com.intellij.ui.treeStructure.Tree()
    }

    override fun changeView(typeName: String, requestFocus: Boolean) {
        println("changeView:$typeName")
        super.changeView(typeName, requestFocus)
    }

    override fun isApplicableElement(element: PsiElement): Boolean {
        return true
    }

    override fun getElementFromDescriptor(descriptor: HierarchyNodeDescriptor): PsiElement? {
        _descriptor = descriptor;
        return _descriptor?.psiElement;
    }

    override fun createHierarchyTreeStructure(type: String, psiElement: PsiElement): HierarchyTreeStructure? {
        println("createHierarchyTreeStructure ${_element.text}|${psiElement.text}")

        for (node in psiElement.parents(true)) {
            if (node is ValkyrieClassStatement) {
                val descriptor = HierarchyNode(myProject, node);
                return TypeHierarchyTree(psiElement.project, descriptor)
            }
        }
        return null
    }

    override fun getComparator(): Comparator<NodeDescriptor<*>>? {
        return null
    }

    override fun isInterface(psiElement: PsiElement): Boolean {
        return Random().nextBoolean()
    }

    override fun canBeDeleted(psiElement: PsiElement?): Boolean {
        return false;
    }

    override fun getQualifiedName(psiElement: PsiElement?): String {
        if (psiElement != null) {
            return psiElement.text
        }
        return "getQualifiedName"
    }
}


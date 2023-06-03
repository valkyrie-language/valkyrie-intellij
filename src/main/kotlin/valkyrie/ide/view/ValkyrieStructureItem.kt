package valkyrie.ide.view

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.SearchableTextProvider
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiFile
import valkyrie.psi.node.*


open class ValkyrieStructureItem<T : NavigatablePsiElement> : SearchableTextProvider, SortableTreeElement {
    protected val psi: T
    var visibility: ValkyrieVisibility = ValkyrieVisibility.Public

    constructor(psi: T) {
        this.psi = psi
    }


    override fun getValue(): NavigatablePsiElement = psi

    override fun getSearchableText(): String? {
        return psi.name
    }

    override fun navigate(requestFocus: Boolean) = psi.navigate(requestFocus)

    override fun canNavigate(): Boolean = psi.canNavigate()

    override fun canNavigateToSource(): Boolean = psi.canNavigateToSource()

    override fun getAlphaSortKey(): String = psi.name ?: ""
    override fun getPresentation(): ItemPresentation {
        return psi.presentation ?: PresentationData()
    }

    override fun getChildren(): Array<TreeElement> {
        val visitor = ValkyrieStructure()
        psi.accept(visitor)
        return visitor.items.toTypedArray()
    }
}


class ValkyrieStructure : ValkyrieVisitor() {
    val items: MutableList<TreeElement> = mutableListOf()
    override fun visitFile(file: PsiFile) {
        for (child in file.children) {
            when (child) {
                is ValkyrieDeclareNamespaceNode -> items.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareClassNode -> items.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareUnionNode -> items.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareTraitNode -> items.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareFlagsNode -> items.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareEnumerateNode -> items.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareUniteNode -> items.add(ValkyrieStructureItem(child))
                is ValkyrieNewObjectNode -> items.add(ValkyrieStructureItem(child))
                is ValkyrieNewValueNode -> items.add(ValkyrieStructureItem(child))
            }
        }
    }

    override fun visitDeclareNamespace(o: ValkyrieDeclareNamespace) {
        addAnnotations(o.annotations)
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        addAnnotations(o.annotations)
        for (child in o.enumerateBody?.enumerateItemList ?: listOf()) {
            when (child) {
                is ValkyrieDeclareSemanticNode -> o.add(ValkyrieStructureItem(child))
            }
        }
    }

    override fun visitDeclareEnumerate(o: ValkyrieDeclareEnumerate) {
        addAnnotations(o.annotations)
        for (child in o.enumerateBody?.enumerateItemList ?: listOf()) {
            when (child) {
                is ValkyrieDeclareSemanticNode -> o.add(ValkyrieStructureItem(child))
            }
        }
    }


//
//    constructor(self: ValkyrieDeclareClassNode) {
//        this.psi = self
//        addAnnotations(self.annotations)
//        addClassBody(self.classBody)
//    }
//
//    constructor(self: ValkyrieDeclareUnionNode) {
//        this.psi = self
//        addAnnotations(self.annotations)
//        addClassBody(self.classBody)
//    }
//
//    constructor(self: ValkyrieDeclareUniteNode) {
//        this.psi = self
//        addAnnotations(self.annotations)
//        for (child in self.uniteItems) {
//            when (child) {
//                is ValkyrieDeclareVariantNode -> children.add(ValkyrieStructureItem(child))
//                is ValkyrieDeclareMethodNode -> children.add(ValkyrieStructureItem(child))
//            }
//        }
//    }
//
//    constructor(self: ValkyrieDeclareTraitNode) {
//        this.psi = self
//        addAnnotations(self.annotations)
//        addClassBody(self.classBody)
//    }
//
//    constructor(self: ValkyrieDeclareSemanticNode) {
//        this.psi = self
//        addAnnotations(self.annotations)
//    }
//
//    constructor(self: ValkyrieDeclareVariantNode) {
//        this.psi = self
//        addAnnotations(self.annotations)
//        addClassBody(self.classBody)
//    }
//

    //
//    constructor(self: ValkyrieAttributeItem) {
//        self as ValkyrieAttributeItemNode
//        this.psi = self
//    }
//
//    constructor(self: ValkyrieModifier) {
//        self as ValkyrieModifierNode
//        this.psi = self
//    }
//
//    private fun addClassBody(body: ValkyrieClassBody?) {
//        body ?: return
//        for (item in body.declareFieldList) {
//            children.add(ValkyrieStructureItem(item))
//        }
//        for (item in body.declareMethodList) {
//            children.add(ValkyrieStructureItem(item))
//        }
//        for (item in body.declareDomainList) {
//            children.add(ValkyrieStructureItem(item))
//        }
//    }
//
//    constructor(self: ValkyrieDeclareField) {
//        self as ValkyrieDeclareFieldNode
//        this.psi = self
//        addAnnotations(self.annotations)
//    }
//
//    constructor(self: ValkyrieDeclareMethod) {
//        self as ValkyrieDeclareMethodNode
//        this.psi = self
//        addAnnotations(self.annotations)
//    }
//
//    constructor(self: ValkyrieDeclareDomain) {
//        self as ValkyrieDeclareDomainNode
//        this.psi = self
//        addAnnotations(self.annotations)
//    }
//
//    constructor(self: ValkyrieNewObjectNode) {
//        this.psi = self
//    }
//
//    constructor(self: ValkyrieNewValueNode) {
//        this.psi = self
//    }
    private fun addAnnotations(annotations: ValkyrieAnnotations) {
        for (attribute in annotations.attributeBelowList) {
            items.add(ValkyrieStructureItem(attribute.attributeItem))
        }
        for (child in annotations.modifierList) {
            items.add(ValkyrieStructureItem(child))
        }
    }
}

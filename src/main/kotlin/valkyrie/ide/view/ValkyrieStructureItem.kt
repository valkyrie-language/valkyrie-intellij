package valkyrie.ide.view

import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.node.*


class ValkyrieStructureItem : StructureViewTreeElement, SortableTreeElement {
    val node: NavigatablePsiElement
    val view: ItemPresentation;
    private var children: MutableList<ValkyrieStructureItem> = mutableListOf();
    var visibility: ValkyrieVisibility = ValkyrieVisibility.Public

    constructor(self: ValkyrieFileNode) {
        this.node = self
        this.view = self.presentation
        // TODO: use visitor pattern
        for (child in self.children) {
            when (child) {
                is ValkyrieDeclareNamespaceNode -> children.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareClassNode -> children.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareUnionNode -> children.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareTraitNode -> children.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareFlagsNode -> children.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareEnumerateNode -> children.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareUniteNode -> children.add(ValkyrieStructureItem(child))
                is ValkyrieNewObjectNode -> children.add(ValkyrieStructureItem(child))
                is ValkyrieNewValueNode -> children.add(ValkyrieStructureItem(child))
            }
        }
    }

    constructor(self: ValkyrieDeclareNamespaceNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
    }


    constructor(self: ValkyrieDeclareFlagsNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
        for (child in self.flagItems) {
            when (child) {
                is ValkyrieDeclareSemanticNode -> children.add(ValkyrieStructureItem(child))
            }
        }
    }

    constructor(self: ValkyrieDeclareEnumerateNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
        for (child in self.enumerateItems) {
            when (child) {
                is ValkyrieDeclareSemanticNode -> children.add(ValkyrieStructureItem(child))
            }
        }
    }


    constructor(self: ValkyrieDeclareClassNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
        addClassBody(self.classBody)
    }

    constructor(self: ValkyrieDeclareUnionNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
        addClassBody(self.classBody)
    }

    constructor(self: ValkyrieDeclareUniteNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
        for (child in self.uniteItems) {
            when (child) {
                is ValkyrieDeclareVariantNode -> children.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareMethodNode -> children.add(ValkyrieStructureItem(child))
            }
        }
    }

    constructor(self: ValkyrieDeclareTraitNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
        addClassBody(self.classBody)
    }

    constructor(self: ValkyrieDeclareSemanticNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
    }

    constructor(self: ValkyrieDeclareVariantNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
        addClassBody(self.classBody)
    }

    private fun addAnnotations(annotations: ValkyrieAnnotations) {
        for (child in annotations.attributeList) {
            children.add(ValkyrieStructureItem(child))
        }
        for (child in annotations.modifierList) {
            children.add(ValkyrieStructureItem(child))
        }
    }

    constructor(self: ValkyrieAttribute) {
        self as ValkyrieAttributeNode
        this.node = self
        this.view = self.presentation
    }

    constructor(self: ValkyrieModifier) {
        self as ValkyrieModifierNode
        this.node = self
        this.view = self.presentation
    }

    private fun addClassBody(body: ValkyrieClassBody?) {
        body ?: return
        for (valkyrieClassItem in body.classItemList) {
            when (val child = valkyrieClassItem.firstChild) {
                is ValkyrieDeclareFieldNode -> children.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareMethodNode -> children.add(ValkyrieStructureItem(child))
            }
        }
    }

    constructor(self: ValkyrieDeclareFieldNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
    }

    constructor(self: ValkyrieDeclareMethodNode) {
        this.node = self
        this.view = self.presentation
        addAnnotations(self.annotations)
    }

    constructor(self: ValkyrieNewObjectNode) {
        this.node = self
        this.view = self.presentation
//        addAnnotations(self.annotations)
    }

    constructor(self: ValkyrieNewValueNode) {
        this.node = self
        this.view = self.presentation
//        addAnnotations(self.annotations)
    }

    override fun getValue(): Any = node

    override fun navigate(requestFocus: Boolean) = node.navigate(requestFocus)

    override fun canNavigate(): Boolean = node.canNavigate()

    override fun canNavigateToSource(): Boolean = node.canNavigateToSource()

    override fun getAlphaSortKey(): String = node.name ?: ""

    override fun getPresentation(): ItemPresentation = view

    override fun getChildren(): Array<out ValkyrieStructureItem> {
        return children.toTypedArray()
    }


}
//
//class ValkyrieFoldVisitor : ValkyrieVisitor() {
//    val items: MutableList<ValkyrieStructureItem> = mutableListOf()
//    override fun visitDeclareNamespace(o: ValkyrieDeclareNamespace) {
//        items.add(ValkyrieStructureItem(o as ValkyrieDeclareNamespaceNode))
//    }
//
//    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
//        items.add(ValkyrieStructureItem(o as ValkyrieDeclareClassNode))
//    }
//
//    override fun visitDeclareField(o: ValkyrieDeclareField) {
//        items.add(ValkyrieStructureItem(o as ValkyrieDeclareFieldNode))
//    }
//}

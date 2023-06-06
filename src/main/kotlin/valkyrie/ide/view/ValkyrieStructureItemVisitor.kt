package valkyrie.ide.view

import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.psi.PsiFile
import valkyrie.psi.node.*


class ValkyrieStructureItemVisitor : ValkyrieVisitor() {
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
        o.annotations.pushChildrenTo(this)
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        o.annotations.pushChildrenTo(this)
//        for (child in o.enumerateBody?.declareSemanticList ?: listOf()) {
//            items.add(ValkyrieStructureItem(child))
//        }
    }

    override fun visitDeclareEnumerate(o: ValkyrieDeclareEnumerate) {
        o.annotations.pushChildrenTo(this)
//        for (child in o.enumerateBody?.declareSemanticList ?: listOf()) {
//            items.add(ValkyrieStructureItem(child))
//        }
    }


    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        o.annotations.pushChildrenTo(this)
        o.classBody?.pushChildrenTo(this)
    }

    override fun visitClassBody(o: ValkyrieClassBody) {
        for (item in o.declareFieldList) {
            visitDeclareField(item)
        }
        for (item in o.declareMethodList) {
            visitDeclareMethod(item)
        }
        for (item in o.declareDomainList) {
            visitDeclareDomain(item)
        }
    }

    override fun visitDeclareUnion(o: ValkyrieDeclareUnion) {
        o.annotations.pushChildrenTo(this)
        o.classBody?.pushChildrenTo(this)
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        o.annotations.pushChildrenTo(this)
        o.classBody?.pushChildrenTo(this)
    }

    override fun visitDeclareSemantic(o: ValkyrieDeclareSemantic) {
        o.annotations.pushChildrenTo(this)
    }

    override fun visitDeclareUnite(o: ValkyrieDeclareUnite) {
        o.annotations.pushChildrenTo(this)
        o.uniteBody?.pushChildrenTo(this)
    }

    override fun visitDeclareVariant(o: ValkyrieDeclareVariant) {
        o.annotations.pushChildrenTo(this)
        o.classBody?.pushChildrenTo(this)
    }

    override fun visitModifier(o: ValkyrieModifier) {
        items.add(ValkyrieStructureItem(o as ValkyrieModifierNode))
    }

    override fun visitAttributeItem(o: ValkyrieAttributeItem) {
        items.add(ValkyrieStructureItem(o as ValkyrieAttributeItemNode))
    }


    override fun visitDeclareField(o: ValkyrieDeclareField) {
        o.annotations.pushChildrenTo(this)
        items.add(ValkyrieStructureItem(o as ValkyrieDeclareMethodNode))
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        o.annotations.pushChildrenTo(this)
        items.add(ValkyrieStructureItem(o as ValkyrieDeclareMethodNode))
    }

    override fun visitDeclareDomain(o: ValkyrieDeclareDomain) {
        o.annotations.pushChildrenTo(this)
        items.add(ValkyrieStructureItem(o as ValkyrieDeclareDomainNode))
    }


    override fun visitNewValue(o: ValkyrieNewValue) {
        super.visitNewValue(o)
    }

    override fun visitNewObject(o: ValkyrieNewObject) {
        super.visitNewObject(o)
    }
}

private fun ValkyrieAnnotations.pushChildrenTo(visitor: ValkyrieStructureItemVisitor) {
    for (attribute in this.attributeBelowList) {
        visitor.visitAttributeItem(attribute.attributeItem)
    }
    for (child in this.modifierList) {
        visitor.visitModifier(child)
    }
}

private fun ValkyrieEnumerateBody.pushChildrenTo(visitor: ValkyrieStructureItemVisitor) {
//    for (item in this.declareFieldList) {
//        visitor.visitDeclareField(item)
//    }
//    for (item in this.declareMethodList) {
//        visitor.visitDeclareMethod(item)
//    }
//    for (item in this.declareDomainList) {
//        visitor.visitDeclareDomain(item)
//    }
}

private fun ValkyrieClassBody.pushChildrenTo(visitor: ValkyrieStructureItemVisitor) {
    for (item in this.declareFieldList) {
        visitor.visitDeclareField(item)
    }
    for (item in this.declareMethodList) {
        visitor.visitDeclareMethod(item)
    }
    for (item in this.declareDomainList) {
        visitor.visitDeclareDomain(item)
    }
}

private fun ValkyrieUniteBody.pushChildrenTo(visitor: ValkyrieStructureItemVisitor) {
//    for (attribute in this.attributeBelowList) {
//        visitor.visitAttributeItem(attribute.attributeItem)
//    }
//    for (child in this.modifierList) {
//        visitor.visitModifier(child)
//    }
}


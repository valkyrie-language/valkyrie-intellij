package valkyrie.ide.view

import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.psi.PsiFile
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.*


class ValkyrieStructureItemVisitor : ValkyrieVisitor() {
    val items: MutableList<TreeElement> = mutableListOf()
    override fun visitFile(file: PsiFile) {
        for (child in file.children) {
            when (child) {
                is ValkyrieDeclaration -> items.add(ValkyrieStructureItem(child))
                is ValkyrieDeclareImplyNode -> items.add(ValkyrieStructureItem(child))
            }
        }
    }

    override fun visitDeclareNamespace(o: ValkyrieDeclareNamespace) {
        o.annotations.pushChildrenTo(this)
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        o.annotations.pushChildrenTo(this)
        o.enumerateBody?.pushChildrenTo(this)
    }

    override fun visitDeclareEnumerate(o: ValkyrieDeclareEnumerate) {
        o.annotations.pushChildrenTo(this)
        o.enumerateBody?.pushChildrenTo(this)
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        o.annotations.pushChildrenTo(this)
        o.classBody?.pushChildrenTo(this)
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

    override fun visitDeclareField(o: ValkyrieDeclareField) {
        o.annotations.pushChildrenTo(this)
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        o.annotations.pushChildrenTo(this)
    }

    override fun visitDeclareDomain(o: ValkyrieDeclareDomain) {
        o.annotations.pushChildrenTo(this)
    }
}


private fun ValkyrieAnnotations.pushChildrenTo(visitor: ValkyrieStructureItemVisitor) {
    for (attribute in this.attributeBelowList) {
        visitor.items.add(ValkyrieStructureItem(attribute.attributeItem as ValkyrieAttributeItemNode))
    }
    for (child in this.modifierList) {
        visitor.items.add(ValkyrieStructureItem(child as ValkyrieModifierNode))
    }
}

private fun ValkyrieEnumerateBody.pushChildrenTo(visitor: ValkyrieStructureItemVisitor) {
    for (item in this.declareSemanticList) {
        visitor.items.add(ValkyrieStructureItem(item as ValkyrieDeclareSemanticNode))
    }
    for (item in this.declareMethodList) {
        visitor.items.add(ValkyrieStructureItem(item as ValkyrieDeclareMethodNode))
    }
    for (item in this.declareDomainList) {
        visitor.items.add(ValkyrieStructureItem(item as ValkyrieDeclareDomainNode))
    }
}

private fun ValkyrieClassBody.pushChildrenTo(visitor: ValkyrieStructureItemVisitor) {
    for (item in this.declareFieldList) {
        visitor.items.add(ValkyrieStructureItem(item as ValkyrieDeclareFieldNode))
    }
    for (item in this.declareMethodList) {
        visitor.items.add(ValkyrieStructureItem(item as ValkyrieDeclareMethodNode))
    }
    for (item in this.declareDomainList) {
        visitor.items.add(ValkyrieStructureItem(item as ValkyrieDeclareDomainNode))
    }
}

private fun ValkyrieUniteBody.pushChildrenTo(visitor: ValkyrieStructureItemVisitor) {
    for (item in this.declareVariantList) {
        visitor.items.add(ValkyrieStructureItem(item as ValkyrieDeclareVariantNode))
    }
    for (item in this.declareMethodList) {
        visitor.items.add(ValkyrieStructureItem(item as ValkyrieDeclareMethodNode))
    }
}

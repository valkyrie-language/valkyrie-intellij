package valkyrie.ide.codegen

import com.intellij.codeInsight.generation.ClassMemberWithElement
import com.intellij.codeInsight.generation.MemberChooserObject
import com.intellij.ui.SimpleColoredComponent
import com.intellij.ui.SimpleTextAttributes
import com.intellij.ui.speedSearch.SpeedSearchUtil
import valkyrie.psi.node.ValkyrieDeclareClassNode
import valkyrie.psi.node.ValkyrieDeclareFieldNode
import javax.swing.JTree

class GenerateClassFieldMember(val field: ValkyrieDeclareFieldNode, val parent: ValkyrieDeclareClassNode) :
    ClassMemberWithElement {
    override fun renderTreeNode(component: SimpleColoredComponent, tree: JTree) {
        SpeedSearchUtil.appendFragmentsForSpeedSearch(
            tree,
            this.text,
            SimpleTextAttributes.SIMPLE_CELL_ATTRIBUTES,
            false,
            component
        )
        component.icon = field.getIcon(0)
    }

    override fun getText(): String {
        return field.text
    }

    override fun getParentNodeDelegate(): MemberChooserObject {
        return GenerateClassMember(parent)
    }

    override fun getElement(): ValkyrieDeclareClassNode {
        return parent
    }
}
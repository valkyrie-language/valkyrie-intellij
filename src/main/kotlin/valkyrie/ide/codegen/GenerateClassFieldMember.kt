package valkyrie.ide.codegen

import com.intellij.codeInsight.generation.ClassMemberWithElement
import com.intellij.codeInsight.generation.MemberChooserObject
import com.intellij.ui.SimpleColoredComponent
import com.intellij.ui.SimpleTextAttributes
import com.intellij.ui.speedSearch.SpeedSearchUtil
import valkyrie.ast.node.ValkyrieClassDeclarationNode
import valkyrie.ast.node.ValkyrieObjectFieldNode
import javax.swing.JTree

class GenerateClassFieldMember(val field: ValkyrieObjectFieldNode, val parent: ValkyrieClassDeclarationNode) :
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

    override fun getElement(): ValkyrieClassDeclarationNode {
        return parent
    }
}
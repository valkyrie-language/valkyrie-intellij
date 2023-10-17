package valkyrie.ide.codegen

import com.intellij.codeInsight.generation.MemberChooserObject
import com.intellij.ui.SimpleColoredComponent
import com.intellij.ui.SimpleTextAttributes
import com.intellij.ui.speedSearch.SpeedSearchUtil
import valkyrie.ast.node.ValkyrieClassDeclarationNode
import javax.swing.JTree

class GenerateClassMember(val parent: ValkyrieClassDeclarationNode) : MemberChooserObject {
    override fun renderTreeNode(component: SimpleColoredComponent, tree: JTree) {
        SpeedSearchUtil.appendFragmentsForSpeedSearch(
            tree,
            this.text,
            SimpleTextAttributes.SIMPLE_CELL_ATTRIBUTES,
            false,
            component
        )
        component.icon = parent.getIcon(0)
    }

    override fun getText(): String {
        return parent.name ?: "class"
    }
}
package valkyrie.ide.codegen

import com.intellij.codeInsight.generation.ClassMemberWithElement
import com.intellij.codeInsight.generation.MemberChooserObject
import com.intellij.ui.SimpleColoredComponent
import com.intellij.ui.SimpleTextAttributes
import com.intellij.ui.speedSearch.SpeedSearchUtil
import valkyrie.language.ast.classes.ValkyrieClassFieldNode
import valkyrie.language.ast.classes.ValkyrieClassStatement
import javax.swing.JTree

class GenerateClassFieldMember(val field: ValkyrieClassFieldNode, val parent: ValkyrieClassStatement) :
    ClassMemberWithElement {
    override fun renderTreeNode(component: SimpleColoredComponent, tree: JTree) {
        SpeedSearchUtil.appendFragmentsForSpeedSearch(
            tree,
            this.text,
            SimpleTextAttributes.SIMPLE_CELL_ATTRIBUTES,
            false,
            component
        )
        component.icon = field.baseIcon
    }

    override fun getText(): String {
        return field.text
    }

    override fun getParentNodeDelegate(): MemberChooserObject {
        return GenerateClassMember(parent)
    }

    override fun getElement(): ValkyrieClassStatement {
        return parent
    }
}
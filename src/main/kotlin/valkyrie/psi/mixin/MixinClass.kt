package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclareElement
import valkyrie.psi.node.ValkyrieDeclareClass
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon


abstract class MixinClass(node: ASTNode) : ValkyrieDeclareElement(node), ValkyrieDeclareClass {
    val superClasses = this.classInheritBody?.classInheritList ?: listOf()
    val classItems = classBody?.classItemList?.map { it.firstChild } ?: listOf();

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Class
    }


}

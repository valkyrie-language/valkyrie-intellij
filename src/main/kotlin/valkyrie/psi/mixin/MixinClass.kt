package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareClass
import valkyrie.psi.node.ValkyrieDeclareClassNode
import valkyrie.psi.node.ValkyrieIdentifierNode
import valkyrie.psi.node.ValkyrieInheritItemNode
import javax.swing.Icon


abstract class MixinClass(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareClass {
    override val color: HighlightColor
        get() = HighlightColor.SYM_CLASS

    override fun getOriginalElement(): ValkyrieDeclareClassNode {
        return this as ValkyrieDeclareClassNode
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Class
    }
}

val ValkyrieDeclareClass.superClasses: List<ValkyrieInheritItemNode>
    get() {
        return this.classInherit?.inheritItemList?.map { it as ValkyrieInheritItemNode } ?: listOf()
    }

val ValkyrieDeclareClass.classItems: List<PsiElement>
    get() {
        return this.classBody?.classItemList?.map { it.firstChild } ?: listOf()
    }


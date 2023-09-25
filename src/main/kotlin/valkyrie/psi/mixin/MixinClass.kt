package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes.KW_CLASS
import valkyrie.psi.findKeyword
import valkyrie.psi.node.*
import javax.swing.Icon


abstract class MixinClass(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareClass {

    var fields: MutableList<ValkyrieDeclareFieldNode> = mutableListOf()

    override val color: HighlightColor
        get() = HighlightColor.SYM_CLASS

    override fun getOriginalElement(): ValkyrieDeclareClassNode {
        return this as ValkyrieDeclareClassNode
    }

    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Class
    }


    override fun subtreeChanged() {
        fields.clear()
    }
}

val ValkyrieDeclareClass.superClasses: List<ValkyrieInheritItemNode>
    get() {
        return this.classInherit?.inheritItemList?.map { it as ValkyrieInheritItemNode } ?: listOf()
    }
val ValkyrieDeclareClass.keyword: PsiElement
    get() {
        return findKeyword(KW_CLASS)
    }
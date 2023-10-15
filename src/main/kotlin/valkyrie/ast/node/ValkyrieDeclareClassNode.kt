package valkyrie.ast.node

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parseClass
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareClass
import valkyrie.psi.node.ValkyrieDeclareFieldNode
import valkyrie.psi.node.ValkyrieInheritItemNode
import javax.swing.Icon

class ValkyrieClassDeclarationNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val keyword = findChildByClass(ValkyrieKeywordNode::class.java)!!
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)

    override val color: HighlightColor?
        get() = HighlightColor.SYM_CLASS

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Class
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return identifier
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareClass(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "ClassDeclaration"
    }

    companion object : ParserMonad {
        // 解析类定义
        override fun parse(builder: PsiBuilder): Boolean {
            return parseClass(builder = builder, anonymous = false)
        }
    }
}

abstract class MixinClass(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareClass {
    override fun getKeyword(): PsiElement {
        return findKeyword(ValkyrieTypes.KW_CLASS)
    }

    override fun getSuperClasses(): List<ValkyrieInheritItemNode> {
        return this.classInherit?.inheritItemList?.map { it as ValkyrieInheritItemNode } ?: listOf()
    }

    override fun getFields(): List<ValkyrieDeclareFieldNode> {
        return mutableListOf()
    }

    override val color: HighlightColor
        get() = HighlightColor.SYM_CLASS

}
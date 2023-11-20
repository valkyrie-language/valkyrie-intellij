package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareTrait
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_TRAIT
import valkyrie.ide.highlight.HighlightColor
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import javax.swing.Icon


class ValkyrieTraitNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val keyword = findChildByClass(ValkyrieKeywordNode::class.java)!!
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)
    val superTraits = findChildByClass(ValkyrieInheritListNode::class.java)?.items ?: arrayOf()
    val body = findChildByClass(ValkyrieObjectBodyNode::class.java)

    override val color: HighlightColor?
        get() = HighlightColor.SYM_TRAIT

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Trait
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return identifier
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareTrait(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "TraitDeclaration"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseClass(builder, ParseKeywords(KW_TRAIT), DeclareTrait, false)
        }
    }
}

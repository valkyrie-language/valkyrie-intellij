package valkyrie.ast.node

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareClass
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_CLASS
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import javax.swing.Icon

open class ValkyrieClassDeclarationNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val keyword = findChildByClass(ValkyrieKeywordNode::class.java)!!
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)
    val superClasses = findChildByClass(ValkyrieInheritListNode::class.java)?.items ?: arrayOf()

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
            return parseClass(builder, ValkyrieKeyword(KW_CLASS), DeclareClass, false)
        }
    }
}

fun parseClass(builder: PsiBuilder, cst: ValkyrieKeyword, ast: ValkyrieAST, anonymous: Boolean): Boolean {
    val marker = builder.mark()
    // 解析注解, 匿名对象不能使用注解
    if (!anonymous) {
        ValkyrieAnnotationAreaNode.parse(builder)
    }
    // 检查是否有 class 关键字
    if (!cst.parse(builder)) {
        marker.drop()
        return false
    }
    // 解析类名
    if (!ValkyrieIdentifierNode.parse(builder)) {
        builder.error("Expected class name")
        marker.drop()
        return false
    }
    // 解析继承列表
    ValkyrieInheritListNode.parse(builder)
    // 解析类体
    if (!ValkyrieObjectNode.parse(builder)) {
        marker.drop()
        return false
    }
    marker.done(ast)
    return true
}


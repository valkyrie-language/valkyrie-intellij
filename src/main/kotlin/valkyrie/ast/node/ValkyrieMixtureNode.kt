package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.ValkyrieVisitor
import valkyrie.psi.ValkyrieDeclaration

open class ValkyrieMixtureNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val keyword = findChildByClass(ValkyrieKeywordNode::class.java)!!
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareMixture(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return identifier
    }
}

fun parseMixture(builder: PsiBuilder, cst: ParseKeywords, ast: ValkyrieAST, anonymous: Boolean): Boolean {
    val marker = builder.mark()
    // 解析注解, 匿名对象不能使用注解
    if (!anonymous) {
        ValkyrieAnnotationAreaNode.parse(builder)
    }
    // 检查是否有 class 关键字
    if (!cst.parse(builder)) {
        marker.rollbackTo()
        return false
    }
    // 解析类名
    if (!ValkyrieIdentifierNode.parse(builder)) {
        builder.error("Expected ValkyrieIdentifierNode name")
        marker.done(ast)
        return true
    }
    // 解析继承列表
    ValkyrieInheritListNode.parse(builder)
    // 解析类体
    if (!ValkyrieMixtureBodyNode.parse(builder)) {
        builder.error("Expected ValkyrieMixtureBodyNode name")
        marker.done(ast)
        return true
    }
    marker.done(ast)
    return true
}


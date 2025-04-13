package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.ValkyrieVisitor
import valkyrie.psi.ValkyrieDeclaration

// 命名函数定义节点
// 语法: @.annotations modifiers function name(args): returnType { functionBody }
// 或者: @.annotations modifiers function name(args) -> returnType { functionBody }
// 函数体是可选的
open class ValkyrieFunctionDeclareNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val keyword = findChildByClass(ValkyrieKeywordNode::class.java)!!
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)
    val parameterBody by lazy {
        return@lazy findChildByClass(ValkyrieParameterListNode::class.java)
    }
    val parameters = parameterBody?.items ?: arrayOf()
    val returnType = findChildByClass(ValkyrieTypeExpressionNode::class.java)
    val effectType = findChildByClass(ValkyrieTypeExpressionNode::class.java)

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return identifier
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareFunction(this)
            else -> visitor.visitElement(this)
        }
    }
}

fun parseFunction(builder: PsiBuilder, cst: ParseKeywords, ast: ValkyrieAST, anonymous: Boolean): Boolean {
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
    if (!ValkyrieParameterListNode.parse(builder)) {
        builder.error("Expected ValkyrieParameterListNode body")
        marker.done(ast)
        return true
    }
    // 解析类体
    if (!ValkyrieFunctionBodyNode.parse(builder)) {
        builder.error("Expected ValkyrieFunctionBodyNode body")
        marker.done(ast)
        return true
    }
    marker.done(ast)
    return true
}


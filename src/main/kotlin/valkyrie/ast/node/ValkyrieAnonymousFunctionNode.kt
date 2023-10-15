package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

class ValkyrieAnonymousFunctionNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    // Lambda 函数定义节点
    // 语法: @.annotations modifiers function(args): returnType { functionBody }
    // 或者: @.annotations modifiers function(args) -> returnType { functionBody }
    // 函数体是必须的
}
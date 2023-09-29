package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.extapi.psi.ASTWrapperPsiElement

class ValkyrieAnonymousMicroNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    // Lambda 函数定义节点
    // 语法: @.annotations modifiers function(args): returnType { functionBody }
    // 或者: @.annotations modifiers function(args) -> returnType { functionBody }
    // 函数体是必须的
}
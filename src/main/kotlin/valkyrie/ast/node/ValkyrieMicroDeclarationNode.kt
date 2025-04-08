package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.extapi.psi.ASTWrapperPsiElement

class ValkyrieMicroDeclarationNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    // 命名函数定义节点
    // 语法: @.annotations modifiers function name(args): returnType { functionBody }
    // 或者: @.annotations modifiers function name(args) -> returnType { functionBody }
    // 函数体是可选的
}
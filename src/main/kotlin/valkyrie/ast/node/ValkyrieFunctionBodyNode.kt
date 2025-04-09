package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

class ValkyrieFunctionBodyNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    // 函数体节点，包含函数的具体实现代码
    // 可以被 MethodNode 和 LambdaNode 复用
}
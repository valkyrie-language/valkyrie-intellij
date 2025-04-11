package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.FunctionBody
import valkyrie.ast.ParserMonad
import valkyrie.ast.advanceChoice
import valkyrie.ast.advanceIgnore
import valkyrie.cst.BRACE_L
import valkyrie.cst.BRACE_R
import valkyrie.cst.SEMICOLON

class ValkyrieFunctionBodyNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    // 函数体节点，包含函数的具体实现代码
    // 可以被 MethodNode 和 LambdaNode 复用

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            // 检查左括号
            if (builder.tokenType == BRACE_L) {
                builder.advanceLexer()
                builder.advanceIgnore()
            } else {
                marker.drop()
                return false
            }
            // 解析大括号内的内容
            while (builder.tokenType !== BRACE_R && !builder.eof()) {
                val inner = builder.mark()
                val success = builder.advanceChoice(
                    ValkyrieTermExpressionNode,
                    SkipSeparator(SEMICOLON)
                )
//                val success = ValkyrieFieldNode.parse(builder)
                if (success) {
                    builder.advanceIgnore()
                    inner.drop()
//                    builder.advanceIgnore()
                } else {
                    inner.drop()
                    // 跳过无法解析的token
                    builder.advanceLexer()
                }
            }

            // 消费右大括号
            if (builder.tokenType === BRACE_R) {
                builder.advanceLexer()
                marker.done(FunctionBody)
                return true
            } else {
                builder.error("Expected '}'")
                marker.drop()
                return false
            }
        }
    }
}
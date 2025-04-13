package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.MacroCall
import valkyrie.ast.advanceIgnore
import valkyrie.cst.OP_MACRO
import valkyrie.cst.SYMBOL


class ValkyrieMacroCallNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        // 解析宏调用
        fun parse(builder: PsiBuilder): Boolean {
            // 检查是否是@符号
            if (builder.tokenType !== OP_MACRO) {
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer() // 消费@符号
            

            // 检查是否是macro关键字
            if (builder.tokenType !== SYMBOL || builder.tokenText != "macro") {
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费macro关键字
            

            // 解析宏名称
            if (builder.tokenType !== SYMBOL) {
                builder.error("Expected macro name")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费宏名称

            marker.done(MacroCall)
            return true
        }
    }
}

package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.TokenSet
import valkyrie.cst.*

class ValkyrieModifierListNode {
    companion object {
        // 解析修饰符列表
        fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            // 吃掉所有的 id
            while (true) {
                val stop = TokenSet.create(
                    COMMA,
                    COLON,
                    BRACE_L, BRACE_R,
                    BRACKET_L, BRACKET_R,
                    PARENTHESIS_L, PARENTHESIS_R
                )
                if (builder.lookAhead(1) in stop) {
                    break
                }
                if (!ValkyrieModifierNode.parse(builder)) {
                    break
                }
            }
            marker.drop()

            return true
        }
    }
}
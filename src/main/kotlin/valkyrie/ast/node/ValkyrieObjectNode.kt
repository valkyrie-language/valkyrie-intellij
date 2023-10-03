package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParseMonad
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.advanceIgnore
import valkyrie.cst.ValkyrieCST

class ValkyrieObjectNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "ValkyrieObjectBody"
    }

    companion object: ParseMonad {
       override fun parse(builder: PsiBuilder): Boolean {
            // 检查是否有左大括号
            if (builder.tokenType !== ValkyrieCST.Companion.LBRACE) {
                builder.error("Expected '{'") 
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer() // 消费左大括号

            // 解析大括号内的内容
            while (builder.tokenType !== ValkyrieCST.Companion.RBRACE && !builder.eof()) {
                builder.advanceIgnore()
                
                // 尝试解析成员
                val success = when (builder.tokenType) {
                    ValkyrieCST.Companion.OP_MACRO, ValkyrieCST.Companion.SYMBOL -> {
                        // 先标记当前位置
                        val memberMarker = builder.mark()
                        
                        // 尝试解析field、method或domain
                        val result = ValkyrieFieldNode.parse(builder) ||
                                    ValkyrieMethodNode.parse(builder) ||
                                    ValkyrieDomainNode.parse(builder)
                        
                        if (!result) {
                            memberMarker.drop()
                        }
                        result
                    }
                    else -> false
                }
                
                if (!success) {
                    builder.error("Expected field, method or domain declaration")
                    builder.advanceLexer() // 跳过无法解析的token
                }
                
                // 处理可选的分隔符
                builder.advanceIgnore()
                if (builder.tokenType === ValkyrieCST.Companion.SEMICOLON || 
                    builder.tokenType === ValkyrieCST.Companion.COMMA) {
                    builder.advanceLexer() // 消费分隔符
                }
            }

            // 检查是否有右大括号
            if (builder.tokenType !== ValkyrieCST.Companion.RBRACE) {
                builder.error("Expected '}'") 
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费右大括号

            marker.done(ValkyrieAST.ObjectBody)
            return true
        }
    }
}
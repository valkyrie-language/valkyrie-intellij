package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.DefineMethod
import valkyrie.ast.advanceIgnore
import valkyrie.cst.LBRACE
import valkyrie.cst.PARENTHESIS_L
import valkyrie.cst.PARENTHESIS_R
import valkyrie.cst.ValkyrieCST

class ValkyrieMethodNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "ValkyrieMethod"
    }

    companion object {
        fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            // 解析注解和修饰符
            while (builder.tokenType === ValkyrieCST.Companion.OP_MACRO || builder.tokenType === ValkyrieCST.Companion.SYMBOL) {
                if (builder.tokenType === ValkyrieCST.Companion.OP_MACRO) {
                    // TODO: 解析注解
                    builder.advanceLexer()
                } else {
                    // TODO: 解析修饰符
                    builder.advanceLexer()
                }
                builder.advanceIgnore()
            }

            // 解析方法名
            if (builder.tokenType !== ValkyrieCST.Companion.SYMBOL) {
                builder.error("Expected method name")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费方法名
            builder.advanceIgnore()

            // 解析参数列表
            if (builder.tokenType !== PARENTHESIS_L) {
                builder.error("Expected '('")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费左括号
            builder.advanceIgnore()

            // 解析参数
            var first = true
            while (builder.tokenType !== PARENTHESIS_R && !builder.eof()) {
                if (!first) {
                    if (builder.tokenType !== ValkyrieCST.Companion.COMMA) {
                        builder.error("Expected ','")
                        break
                    }
                    builder.advanceLexer() // 消费逗号
                    builder.advanceIgnore()
                }

                // 解析参数名
                if (builder.tokenType !== ValkyrieCST.Companion.SYMBOL) {
                    builder.error("Expected parameter name")
                    break
                }
                builder.advanceLexer() // 消费参数名
                builder.advanceIgnore()

                // 解析参数类型
                if (builder.tokenType !== ValkyrieCST.Companion.COLON) {
                    builder.error("Expected ':'")
                    break
                }
                builder.advanceLexer() // 消费冒号
                builder.advanceIgnore()

                // TODO: 解析类型表达式
                if (builder.tokenType !== ValkyrieCST.Companion.SYMBOL) {
                    builder.error("Expected type expression")
                    break
                }
                builder.advanceLexer() // 消费类型
                builder.advanceIgnore()

                first = false
            }

            if (builder.tokenType !== PARENTHESIS_R) {
                builder.error("Expected ')'")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费右括号
            builder.advanceIgnore()

            // 解析返回类型
            if (builder.tokenType === ValkyrieCST.Companion.COLON) {
                builder.advanceLexer() // 消费冒号
                builder.advanceIgnore()
                // TODO: 解析类型表达式
                if (builder.tokenType !== ValkyrieCST.Companion.SYMBOL) {
                    builder.error("Expected return type")
                    marker.drop()
                    return false
                }
                builder.advanceLexer() // 消费返回类型
                builder.advanceIgnore()
            }

            // 解析方法体或分号
            if (builder.tokenType === ValkyrieCST.Companion.SEMICOLON) {
                builder.advanceLexer() // 消费分号
            } else if (builder.tokenType === LBRACE) {
                // TODO: 解析方法体
                ValkyrieObjectNode.parse(builder)
            } else {
                builder.error("Expected ';' or '{'")
                marker.drop()
                return false
            }

            marker.done(DefineMethod)
            return true
        }
    }
}
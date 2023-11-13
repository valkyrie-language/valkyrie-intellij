package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ObjectBody
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.advanceChoice
import valkyrie.ast.advanceIgnore
import valkyrie.cst.BRACE_L
import valkyrie.cst.BRACE_R
import valkyrie.cst.COMMA
import valkyrie.cst.SEMICOLON
import valkyrie.psi.ValkyrieElement

class ValkyrieObjectNode(node: ASTNode) : ValkyrieElement(node) {
    val fields get() = findChildrenByClass(ValkyrieObjectFieldNode::class.java)
    val methods get() = findChildrenByClass(ValkyrieObjectMethodNode::class.java)
    val domains get() = findChildrenByClass(ValkyrieObjectDomainNode::class.java)


    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitClassBody(this)
            else -> visitor.visitElement(this)
        }
    }


    override fun toString(): String {
        return "ObjectBody"
    }

    companion object : ParserMonad {
        //
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
                    ValkyrieObjectDomainNode,
                    ValkyrieObjectMethodNode,
                    ValkyrieObjectFieldNode,
                    SkipSeparator(COMMA, SEMICOLON)
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
                marker.done(ObjectBody)
                return true
            } else {
                builder.error("Expected '}'")
                marker.drop()
                return false
            }
        }
    }
}

class ValkyrieUniteBodyNode(node: ASTNode) : ValkyrieElement(node) {
    val fields get() = findChildrenByClass(ValkyrieObjectFieldNode::class.java)
    val methods get() = findChildrenByClass(ValkyrieObjectMethodNode::class.java)
    val domains get() = findChildrenByClass(ValkyrieObjectDomainNode::class.java)


    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitUniteBody(this)
            else -> visitor.visitElement(this)
        }
    }


    override fun toString(): String {
        return "ObjectBody"
    }

    companion object : ParserMonad {
        //
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
                    ValkyrieObjectDomainNode,
                    ValkyrieObjectMethodNode,
                    ValkyrieObjectFieldNode,
                    SkipSeparator(COMMA, SEMICOLON)
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
                marker.done(ObjectBody)
                return true
            } else {
                builder.error("Expected '}'")
                marker.drop()
                return false
            }
        }
    }
}


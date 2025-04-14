package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.LetStatement
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.BIND
import valkyrie.cst.KW_LET
import valkyrie.cst.PARENTHESIS_L
import valkyrie.psi.ValkyrieElement

class ValkyrieLetStatementNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitLetStatement(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        /** ```vk
        let var;
        let var1, var2 = ...;
        let (mut var1, mut var2) = ...;
        let namepath::Type(mut var1, mut var2) = ...;
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType != KW_LET) {
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer()

            marker.done(LetStatement)
            return true
        }
    }
}


open class ValkyrieTermPatternNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTermPattern(this)
            else -> visitor.visitElement(this)
        }
    }
}

class ValkyrieLetTuplePatternNode(node: ASTNode) : ValkyrieTermPatternNode(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
//            is ValkyrieVisitor -> visitor.visitTermTuplePattern(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        /**
        ```vk
        x <- namepath::Type(var1, mut var2: Tuple(var3), ..many)
        ```
         */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieNamePathNode.parse(builder)
            if (builder.tokenType != KW_LET) {
                return false
            }

            builder.advanceLexer()


            // 解析模式
            if (!ValkyrieLetPatternNode.parse(builder)) {
                builder.error("Expected pattern")
                marker.drop()
                return false
            }

            // 解析等号
            if (builder.tokenType != BIND) {
                builder.error("Expected '='")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费等号


            // 解析表达式
            if (!ValkyrieValueNode.parse(builder)) {
                builder.error("Expected expression")
                marker.drop()
                return false
            }

            marker.done(LetStatement)
            return true
        }
    }
}


class ValkyrieTermTuplePatternNode(node: ASTNode) : ValkyrieTermPatternNode(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTermTuplePattern(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        /**
        ```vk
        namepath::Type(var1, var2: x, var3: Tuple(var3), ..many)
        ```
         */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieNamePathNode.parse(builder)
            // 匹配左括号
            if (builder.tokenType == PARENTHESIS_L) {
                builder.advanceLexer()
            } else {
                marker.rollbackTo()
            }


            // 解析表达式
            if (!ValkyrieValueNode.parse(builder)) {
                builder.error("Expected expression")
                marker.drop()
                return false
            }

            marker.done(LetStatement)
            return true
        }
    }
}

class ValkyrieTermBarePatternNode(node: ASTNode) : ValkyrieTermPatternNode(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTermBarePattern(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        /**
        ```vk
        mut var1, mut var2
        ```
         */
        override fun parse(builder: PsiBuilder): Boolean {
            TODO("Not yet implemented")
        }
    }
}


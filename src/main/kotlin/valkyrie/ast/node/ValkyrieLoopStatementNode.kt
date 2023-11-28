package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.LoopInfinity
import valkyrie.ast.TemplateEnd
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.*
import valkyrie.psi.ValkyrieElement

class ValkyrieLoopStatementNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitLoopStatement(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        /** ```vk
        loop { ... } else { ... }
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType != KW_LOOP) {
                return false
            }
            val marker = builder.mark();
            builder.advanceLexer()

            if (!ValkyrieFunctionBodyNode.parse(builder)) {
                builder.error("Missing block")
            }
            ValkyrieElseNode.parse(builder)
            marker.done(LoopInfinity)
            return true
        }
    }
}


class ValkyrieLoopTemplateNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitLoopTemplate(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        /** ```vk
        <$ loop $>

        <$ else $>

        <$ loop end $>

        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark();
            ValkyrieTemplateElseNode.parse(builder)
            if (ValkyrieTemplateEndNode.parse(builder)) {
                marker.done(LoopInfinity)
                return true
            } else {
                marker.rollbackTo()
                return false
            }
        }
    }
}


class ValkyrieTemplateElseNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitElseTemplate(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        /** ```vk
        <$ end $>
        <$ loop end $>
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark();
            if (builder.tokenType == TEMPLATE_L) {
                builder.advanceLexer()
            } else {
                marker.drop()
                return false
            }
            ParseKeywords(KW_ELSE)
            if (builder.tokenType != TEMPLATE_R) {
                builder.error("Missing `$>`")
            }
            while (!builder.eof() && builder.tokenType != TEMPLATE_L) {
                ValkyrieSemanticNode.parse(builder)
            }
            marker.done(TemplateEnd)
            return true
        }
    }
}

class ValkyrieTemplateEndNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTemplateEnd(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        /** ```vk
        <$ end $>
        <$ loop end $>
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark();
            if (builder.tokenType == TEMPLATE_L) {
                builder.advanceLexer()
            } else {
                marker.drop()
                return false
            }
            ParseKeywords(KW_LOOP, KW_IF)
            if (builder.tokenType == KW_END) {
                builder.advanceLexer()
            }
            if (builder.tokenType != TEMPLATE_R) {
                builder.error("Missing `$>`")
            }
            marker.done(TemplateEnd)
            return true
        }
    }
}
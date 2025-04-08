package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParseMonad
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.advanceIgnore
import valkyrie.cst.ValkyrieCST

class ValkyrieClassDeclareNode(node: ASTNode) : ASTWrapperPsiElement(node) {

    override fun toString(): String {
        return "ClassDeclaration"
    }

    companion object : ParseMonad {
        // 解析类定义
        override fun parse(builder: PsiBuilder): Boolean {
            return parse(builder = builder, anonymous = false)
        }

        fun parse(builder: PsiBuilder, anonymous: Boolean): Boolean {
            val marker = builder.mark()
            // 解析注解, 匿名对象不能使用注解
            when {
                anonymous -> {}
                else -> {
                    ValkyrieAnnotationAreaNode.parse(builder)
                    builder.advanceIgnore();
                }
            }
            // 检查是否有 class 关键字
            if (builder.tokenType === ValkyrieCST.KW_CLASS) {
                builder.advanceLexer()
                builder.advanceIgnore()
            } else {
                marker.drop()
                return false
            }
            // 解析类名
            if (ValkyrieIdentifierNode.parse(builder)) {
                builder.advanceIgnore()
            } else {
                builder.error("Expected class name")
                marker.drop()
                return false
            }
            // 解析继承列表
            ValkyrieClassInheritListNode.parse(builder)
            builder.advanceIgnore()
            // 解析类体
            if (!ValkyrieObjectNode.parse(builder)) {
                marker.drop()
                return false
            }
            if (anonymous) {
                marker.done(ValkyrieAST.AnonymousClass)
            } else {
                marker.done(ValkyrieAST.DeclareClass)
            }

            return true
        }
    }
}


class ValkyrieClassInheritListNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object : ParseMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return false
        }
    }
}

class ValkyrieClassInheritItemNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object : ParseMonad {
        /** `class A(named: BaseClass)` */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            // 解析可选的注解列表
            ValkyrieAnnotationAreaNode.parse(builder)
            builder.advanceIgnore()

            // 解析类名标识符
            if (builder.tokenType !== ValkyrieCST.Companion.SYMBOL) {
                builder.error("Expected class name")
                marker.drop()
                return false
            }
            builder.advanceLexer()

            marker.done(ValkyrieAST.ClassInheritItem)
            return true
        }
    }
}
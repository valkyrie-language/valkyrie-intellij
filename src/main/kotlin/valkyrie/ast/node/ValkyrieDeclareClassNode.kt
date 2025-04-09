package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.AnonymousClass
import valkyrie.ast.DeclareClass
import valkyrie.ast.ParserMonad
import valkyrie.ast.advanceIgnore
import valkyrie.cst.KW_CLASS

class ValkyrieClassDeclarationNode(node: ASTNode) : ASTWrapperPsiElement(node) {

    override fun toString(): String {
        return "ClassDeclaration"
    }

    companion object : ParserMonad {
        // 解析类定义
        override fun parse(builder: PsiBuilder): Boolean {
            return parseClass(builder = builder, anonymous = false)
        }
    }
}
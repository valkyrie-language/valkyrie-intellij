package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DefineMacro
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_MACRO

class ValkyrieMacroDeclareNode(node: ASTNode) : ValkyrieFunctionDeclareNode(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareMacro(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        // 解析修饰符列表
        override fun parse(builder: PsiBuilder): Boolean {
            return parseFunction(builder, ParseKeywords(KW_MACRO), DefineMacro, false)
        }
    }
}
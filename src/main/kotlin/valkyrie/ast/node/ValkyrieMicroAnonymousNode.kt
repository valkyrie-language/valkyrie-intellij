package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareMicro
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_MICRO

class ValkyrieMicroAnonymousNode(node: ASTNode) : ValkyrieFunctionDeclareNode(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitNewLambda(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        // 解析修饰符列表
        override fun parse(builder: PsiBuilder): Boolean {
            return parseFunction(builder, ParseKeywords(KW_MICRO), DeclareMicro, true)
        }
    }
}
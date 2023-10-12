package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParserMonad
import valkyrie.ast.parseClass
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.mixin.MixinIdentifier

class ValkyrieClassDeclarationNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return identifier
    }

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
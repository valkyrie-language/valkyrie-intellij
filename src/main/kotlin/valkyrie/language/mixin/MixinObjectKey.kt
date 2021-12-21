package valkyrie.language.mixin

import valkyrie.ide.reference.ValkyrieReference
import valkyrie.language.ast.ValkyrieASTBase
//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.controlflow.ControlFlowProvider
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import org.apache.velocity.util.ContextAware

open class MixinObjectKey(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }
}

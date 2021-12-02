package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.reference.ValkyrieReference
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi.ValkyrieContext
import valkyrie.language.psi.ancestors
import valkyrie.language.psi_node.*

open class MixinIdentifier(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }
}

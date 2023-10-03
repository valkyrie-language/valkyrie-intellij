package valkyrie.ide.formatter

import com.intellij.formatting.Wrap
import com.intellij.lang.ASTNode
import valkyrie.psi.node.ValkyrieVisitor

class ValkyrieWrapVisitor(val child: ASTNode) : ValkyrieVisitor() {
    var wrap: Wrap? = null
}
package valkyrie.ide.formatter

import com.intellij.formatting.Wrap
import com.intellij.lang.ASTNode
import valkyrie.psi.node.ValkyrieVisitor2

class ValkyrieWrapVisitor(val child: ASTNode) : ValkyrieVisitor2() {
    var wrap: Wrap? = null
}
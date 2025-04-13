package valkyrie.ide.reference.declaration


//import nexus.language.psi_node.ValkyrieClassStatementNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.util.endOffset
import com.intellij.psi.util.startOffset
import valkyrie.ast.node.ValkyrieClassNode

class ClassDeclarationHandler {
    fun getDeclarationRange(container: ValkyrieClassNode): TextRange {
        val startOffset = container.startOffset
        val endOffset = container.endOffset
        return TextRange(startOffset, endOffset)
    }
}



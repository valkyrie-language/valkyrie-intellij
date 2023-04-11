package valkyrie.ide.reference.declaration


//import nexus.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.hint.DeclarationRangeHandler
import com.intellij.openapi.util.TextRange
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import valkyrie.psi.node.ValkyrieDeclareClass

class ClassDeclarationHandler : DeclarationRangeHandler<ValkyrieDeclareClass> {
    override fun getDeclarationRange(container: ValkyrieDeclareClass): TextRange {
        val startOffset = container.startOffset
        val endOffset = container.endOffset
        return TextRange(startOffset, endOffset)
    }
}



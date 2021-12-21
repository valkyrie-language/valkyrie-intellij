package valkyrie.ide.reference.declaration


//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.hint.DeclarationRangeHandler
import com.intellij.openapi.util.TextRange
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import valkyrie.language.ast.ValkyrieClassDeclaration

@Suppress("UnstableApiUsage")
class ClassDeclarationHandler : DeclarationRangeHandler<ValkyrieClassDeclaration> {
    override fun getDeclarationRange(container: ValkyrieClassDeclaration): TextRange {
        val startOffset = container.startOffset
        val endOffset = container.endOffset
        return TextRange(startOffset, endOffset)
    }
}



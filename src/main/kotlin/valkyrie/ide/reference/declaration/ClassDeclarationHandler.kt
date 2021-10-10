package valkyrie.ide.reference.declaration


import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.hint.DeclarationRangeHandler
import com.intellij.openapi.util.TextRange
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset

@Suppress("UnstableApiUsage")
class ClassDeclarationHandler : DeclarationRangeHandler<ValkyrieClassStatementNode> {
    override fun getDeclarationRange(container: ValkyrieClassStatementNode): TextRange {
        val startOffset = container.startOffset
        val endOffset = container.endOffset
        return TextRange(startOffset, endOffset)
    }
}



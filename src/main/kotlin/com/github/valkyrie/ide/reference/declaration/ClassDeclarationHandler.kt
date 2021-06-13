package com.github.valkyrie.ide.reference.declaration

import com.github.valkyrie.language.psi.endOffset
import com.github.valkyrie.language.psi.startOffset
import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.hint.DeclarationRangeHandler
import com.intellij.openapi.util.TextRange

@Suppress("UnstableApiUsage")
class ClassDeclarationHandler : DeclarationRangeHandler<ValkyrieClassStatementNode> {
    override fun getDeclarationRange(container: ValkyrieClassStatementNode): TextRange {
        val startOffset = container.startOffset
        val endOffset = container.endOffset
        return TextRange(startOffset, endOffset)
    }
}



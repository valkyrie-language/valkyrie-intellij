package valkyrie.language.psi

import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.formatting.Indent
import com.intellij.lang.ASTNode

interface ValkyrieHighlightElement {
    @Suppress("FunctionName")
    fun on_highlight(e: HighlightInfoHolder);
}

interface ValkyrieIndentElement {
    @Suppress("FunctionName")
    fun on_indent(child: ASTNode): Indent;
}
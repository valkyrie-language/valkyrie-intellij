package valkyrie.language.psi

import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder

interface ValkyrieHighlightElement {
    @Suppress("FunctionName")
    fun on_highlight(e: HighlightInfoHolder);
}
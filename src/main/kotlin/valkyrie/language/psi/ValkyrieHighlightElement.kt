package valkyrie.language.psi

import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder

interface ValkyrieHighlightElement {
    fun highlight(info: HighlightInfoHolder);
}
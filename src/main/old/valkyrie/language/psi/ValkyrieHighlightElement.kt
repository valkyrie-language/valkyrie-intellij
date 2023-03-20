package valkyrie.language.psi

import valkyrie.ide.highlight.NodeHighlighter

interface ValkyrieHighlightElement {
    @Suppress("FunctionName")
    fun on_highlight(e: NodeHighlighter);
}


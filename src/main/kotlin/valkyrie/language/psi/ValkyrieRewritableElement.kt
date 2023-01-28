package valkyrie.language.psi

import valkyrie.ide.formatter.ValkyrieRewriter

interface ValkyrieRewritableElement {
    fun rewrite(w: ValkyrieRewriter);
}
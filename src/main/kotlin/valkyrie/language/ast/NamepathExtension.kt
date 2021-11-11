package valkyrie.language.ast

import valkyrie.language.psi.ValkyrieNamespaceStatement


fun ValkyrieNamespaceStatement?.isTestFile(): Boolean {
    if (this == null) return false
    return this.firstChild.text == "namespace*"
}
@file:Suppress("ConvertSecondaryConstructorToPrimary", "MemberVisibilityCanBePrivate", "UnstableApiUsage")

package valkyrie.language.symbol

import valkyrie.language.psi_node.ValkyrieNamespaceStatementNode


class ValkyrieNamespaceSymbol(val nav: ValkyrieNamespaceStatementNode) : ValkyrieDeclaration(nav) {


}
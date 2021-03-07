package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.ValkyrieNamespace
import com.intellij.lang.ASTNode

abstract class ValkyrieNamespaceMixin(node: ASTNode) : ValkyrieElement(node),
    ValkyrieNamespace {

}


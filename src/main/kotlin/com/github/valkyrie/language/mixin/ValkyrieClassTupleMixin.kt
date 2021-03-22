package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieElement
import com.github.valkyrie.language.psi.ValkyrieClassTupleItem
import com.intellij.lang.ASTNode

abstract class ValkyrieClassTupleMixin(node: ASTNode) : ValkyrieElement(node),
    ValkyrieClassTupleItem {
}


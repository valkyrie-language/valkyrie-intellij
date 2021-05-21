package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.reference.ValkyrieReference
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.github.valkyrie.language.psi_node.ValkyrieTermNode
import com.intellij.lang.ASTNode

open class MixinTerm(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getOriginalElement(): ValkyrieTermNode {
        return this as ValkyrieTermNode
    }

    override fun getReference(): ValkyrieReference? {
        val namepath = originalElement.namepath
        return when (namepath.count()) {
            1 -> ValkyrieReference(namepath.first())
            else -> null
        }
    }

    val namepath: List<ValkyrieIdentifier>
        get() {
            val namepath = originalElement.atom.namepath ?: return listOf();
            return namepath.identifierList
        }
}




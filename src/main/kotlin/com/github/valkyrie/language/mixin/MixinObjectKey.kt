package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.reference.ValkyrieReference
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

open class MixinObjectKey(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }

    override fun getReferences(): Array<ValkyrieReference> {
        return when (this.parent) {
            is ValkyrieClassStatementNode -> {
                emptyArray()
            }
            else -> {
                arrayOf(ValkyrieReference(this))
            }
        }
    }
}

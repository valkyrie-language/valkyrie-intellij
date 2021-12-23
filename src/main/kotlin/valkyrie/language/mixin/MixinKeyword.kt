package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import valkyrie.language.ast.ValkyrieASTBase

// PsiReference
open class MixinKeyword(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getName(): String? {
        return this.text
    }

//    override fun setName(name: String): PsiElement {
//        return this
//    }
}


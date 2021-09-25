package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi.ValkyrieTypes
import java.math.BigDecimal
import java.math.BigInteger

// PsiReference
open class MixinNumber(node: ASTNode) : ValkyrieASTBase(node) {
    val number: PsiElement
        get() {
            return this.firstChild
        }

    val integer: BigInteger?
        get() = when (number.elementType) {
            ValkyrieTypes.INTEGER -> BigInteger(number.text)
            else -> null
        }

    val decimal: BigDecimal?
        get() = when (number.elementType) {
            ValkyrieTypes.DECIMAL -> BigDecimal(number.text)
            else -> null
        }

    val byte: String?
        get() = when (number.elementType) {
            ValkyrieTypes.BYTE -> number.text
            else -> null
        }

    val unit: PsiElement?
        get() {
            val last = this.lastChild;
            return when (last.elementType) {
                ValkyrieTypes.NUMBER_SUFFIX -> last
                else -> null
            }
        }

}


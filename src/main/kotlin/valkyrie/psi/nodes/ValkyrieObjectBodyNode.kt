package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * 块语句实现
 *
 * ```valkyrie
 * {
 *     mezzo Item;
 *     mod1 field: ValueType = default_value;
 *     mod2 method(): ReturnType {
 *         return 0
 *     }
 *     mod3 domain { }
 * }
 * ```
 */
class ValkyrieObjectBodyNode(node: ASTNode) : ValkyrieElementNode(node) {
    fun getFields(): Array<out ValkyrieFieldDeclaration?> {
        return findChildrenByClass(ValkyrieFieldDeclaration::class.java)
    }

    fun getMethods(): Array<out ValkyrieMethodDeclaration?> {
        return findChildrenByClass(ValkyrieMethodDeclaration::class.java)
    }

    fun getDomains(): Array<out ValkyrieDomainDeclaration?> {
        return findChildrenByClass(ValkyrieDomainDeclaration::class.java)
    }

//    fun getMezzos(): Array<out ValkyrieMezzoDeclaration?> {
//        return findChildrenByClass(ValkyrieMezzoDeclaration::class.java)
//    }

}



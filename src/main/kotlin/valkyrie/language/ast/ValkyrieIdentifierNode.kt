package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import valkyrie.ide.reference.declaration.ValkyrieClassReference
import valkyrie.ide.reference.declaration.ValkyrieTraitReference

class ValkyrieIdentifierNode(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type) {
    override fun getName(): String {
        return text
    }


    /** Create and return a PsiReference object associated with this ID
     * node. The reference object will be asked to resolve this ref
     * by using the text of this node to identify the appropriate definition
     * site. The definition site is typically a subtree for a function
     * or variable definition whereas this reference is just to this ID
     * leaf node.
     *
     * As the AST factory has no context and cannot create different kinds
     * of PsiNamedElement nodes according to context, every ID node
     * in the tree will be of this type. So, we distinguish references
     * from definitions or other uses by looking at context in this method
     * as we have parent (context) information.
     */
    override fun getReference(): PsiReference? {
        var parent = parent
        while (parent != null) {
            when (parent) {
                is ValkyrieTraitStatement -> {
                    return ValkyrieTraitReference(parent, this)
                }
                is ValkyrieClassStatement -> {
                    return ValkyrieClassReference(parent, this)
                }
                else -> {
                    parent = parent.parent
                }
            }
        }
        return null;
    }
}

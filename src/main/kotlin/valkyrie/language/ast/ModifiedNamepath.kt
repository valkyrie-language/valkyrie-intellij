package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.antlr.childrenWithLeaves

/// public static path::name
/// ^^^^^^^^^^^^^ ^^^^^^^^^^
/// | modifiers   | namepath
class ModifiedNamepath(node: CompositeElement) : ASTWrapperPsiElement(node) {
    companion object {
        // Need to be lazy, otherwise it will be an infinite loop
        fun findModifiers(node: PsiElement): Array<ValkyrieIdentifierNode> {
            val proxy = PsiTreeUtil.findChildOfType(node, ModifiedNamepath::class.java) ?: return arrayOf();
            val items = mutableListOf<ValkyrieIdentifierNode>();
            println("start modified namepath: ${proxy.text}")
            for (child in proxy.childrenWithLeaves) {
                println("- ${child::class.java.name}")
                if (child is PsiWhiteSpace) {
                    continue;
                }
                else if (child is ValkyrieIdentifierNode) {
                    items.add(child)
                }
                else {
                    break;
                }
            }
            println("finish modified namepath")
            return items.toTypedArray()
        }
        fun findNamepath(node: PsiElement): Array<ValkyrieIdentifierNode> {
            val items = mutableListOf<ValkyrieIdentifierNode>();
            return items.toTypedArray()
        }
        // Need to be lazy, otherwise it will be an infinite loop
        fun findIdentifier(node: PsiElement): ValkyrieIdentifierNode? {
            val proxy = PsiTreeUtil.getChildOfType(node, ModifiedNamepath::class.java)
            val all = PsiTreeUtil.getChildrenOfTypeAsList(proxy, ValkyrieIdentifierNode::class.java);
            return all.lastOrNull()
        }
    }
}
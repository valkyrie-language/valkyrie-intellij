package valkyrie.language.ast


import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil
import org.jetbrains.annotations.Unmodifiable
import valkyrie.language.antlr.childrenWithLeaves

enum class ValkyrieModifiedKind {
    Pure,
    ModifiedIdentifier,
    ModifiedNamepath,
}

class ValkyrieModifiedNode(node: CompositeElement, val kind: ValkyrieModifiedKind) : ASTWrapperPsiElement(node) {
    private fun filterAll(): @Unmodifiable MutableList<ValkyrieIdentifierNode> {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIdentifierNode::class.java)
    }
    fun findModifiers(): List<ValkyrieIdentifierNode> {
        return when (kind) {
            ValkyrieModifiedKind.Pure -> {
                filterAll()
            }

            ValkyrieModifiedKind.ModifiedIdentifier -> {
                filterAll().dropLast(1)
            }

            ValkyrieModifiedKind.ModifiedNamepath -> {
                val items = mutableListOf<ValkyrieIdentifierNode>();
                for (child in this.childrenWithLeaves) {
                    if (child is PsiWhiteSpace) {
                        continue;
                    } else if (child is ValkyrieIdentifierNode) {
                        items.add(child)
                    } else {
                        break;
                    }
                }
                return items.dropLast(1)
            }
        }
    }

    fun findIdentifier(): ValkyrieIdentifierNode? {
        return if (kind == ValkyrieModifiedKind.Pure) {
            null
        } else {
            filterAll().lastOrNull()
        }
    }

    fun findNamepath(): List<ValkyrieIdentifierNode> {
        return emptyList()
    }



    companion object {
        // Need to be lazy, otherwise it will be an infinite loop
        fun findModifiers(node: PsiElement): List<ValkyrieIdentifierNode> {
            val proxy = PsiTreeUtil.getChildOfType(node, ValkyrieModifiedNode::class.java)
            return proxy?.findModifiers() ?: listOf()
        }

        fun findNamepath(node: PsiElement): List<ValkyrieIdentifierNode> {
            val proxy = PsiTreeUtil.getChildOfType(node, ValkyrieModifiedNode::class.java)
            return proxy?.findNamepath() ?: listOf()
        }

        // Need to be lazy, otherwise it will be an infinite loop
        fun findIdentifier(node: PsiElement): ValkyrieIdentifierNode? {
            val proxy = PsiTreeUtil.getChildOfType(node, ValkyrieModifiedNode::class.java)
            return proxy?.findIdentifier()
        }

    }
}


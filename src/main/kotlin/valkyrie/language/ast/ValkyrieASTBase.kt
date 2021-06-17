package valkyrie.language.ast

import valkyrie.ide.reference.ValkyrieReference
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.psi.ancestors
import valkyrie.language.psi_node.ValkyrieMacroCallNode
import valkyrie.language.psi_node.ValkyrieMacroListNode
import valkyrie.language.symbol.ValkyrieSymbol
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.siblings

@Suppress("UnstableApiUsage")
open class ValkyrieASTBase(node: ASTNode) : ASTWrapperPsiElement(node) {
    fun collectDocuments(list: MutableList<PsiComment>) {
        for (node in this.siblings(forward = false, withSelf = false)) {
            when (node) {
                is PsiComment -> list.add(node)
                is PsiWhiteSpace -> continue
                else -> break
            }
        }
    }

    open fun addAnnotationView(list: MutableList<ValkyrieViewElement>) {
        for (node in this.siblings(forward = false, withSelf = false)) {
            when (node) {
                is ValkyrieMacroListNode -> node.addAnnotationView(list)
                is ValkyrieMacroCallNode -> node.addAnnotationView(list)
                is PsiWhiteSpace, is PsiComment -> continue
                else -> break
            }
        }
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData("[UNDEFINED]", this.text, getIcon(0), null)
    }

    open fun getChildrenView(): Array<ValkyrieViewElement> {
        val childrenView: MutableList<ValkyrieViewElement> = mutableListOf()
        for (item in PsiTreeUtil.getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)) {
            when (val view = item.presentation) {
                null -> continue
                else -> childrenView.add(ValkyrieViewElement(item, view))
            }
        }
        return childrenView.toTypedArray()
    }

    open fun resolveNamespace(name: List<String>): ValkyrieASTBase? {
        return when (name.count()) {
            0 -> this
            else -> null
        }
    }

    override fun getContext(): PsiElement? {
//        for (node in ancestors) {
//            when (node) {
//                is ValkyrieASTBase -> return node
//                else -> continue
//            }
//        }
        return null
    }

    override fun getOwnDeclarations(): MutableCollection<out ValkyrieSymbol> {
        return mutableListOf()
    }

    override fun getReference(): ValkyrieReference? = this.references.firstOrNull()
    override fun getReferences(): Array<ValkyrieReference> = emptyArray()
}
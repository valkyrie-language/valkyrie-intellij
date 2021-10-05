package valkyrie.language.mixin

import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi.ValkyrieTypes
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.psi_node.ValkyrieMacroCallNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType

open class MixinMacroCall(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getOriginalElement(): ValkyrieMacroCallNode {
        return this as ValkyrieMacroCallNode
    }

    override fun getNavigationElement(): ValkyrieIdentifierNode {
        return originalElement.namepathFree.identifierList.last() as ValkyrieIdentifierNode
    }

    override fun getName(): String {
        return navigationElement.name
    }

    fun isAnnotation(): Boolean {
        val block = originalElement.macroBlock ?: return true
        return block.firstChild.elementType == ValkyrieTypes.PARENTHESIS_L
    }

    override fun getPresentation(): ItemPresentation? {
        if (isAnnotation()) return null
        return PresentationData(this.name, "", ValkyrieIconProvider.MACRO, null)
    }

    override fun addAnnotationView(list: MutableList<ValkyrieViewElement>) {
        if (isAnnotation()) {
            val view = PresentationData(this.name, "", ValkyrieIconProvider.ANNOTATION, null)
            list.add(ValkyrieViewElement(this, view))
        }
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val childrenView: MutableList<ValkyrieViewElement> = mutableListOf()
        for (item in PsiTreeUtil.getChildrenOfTypeAsList(originalElement.macroBlock, NavigatablePsiElement::class.java)) {
            childrenView.add(ValkyrieViewElement(item))
        }
        return childrenView.toTypedArray()
    }
}




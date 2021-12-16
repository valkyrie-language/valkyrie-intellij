package valkyrie.language.ast

import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.psi.*
import valkyrie.language.psi_node.ValkyrieImportItemNode
import valkyrie.language.psi_node.ValkyrieImportStatementNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil


fun ValkyrieDefineTuple?.addChildrenView(list: MutableList<ValkyrieViewElement>) {
    if (this == null) return
    PsiTreeUtil
        .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
        .forEach {
            // PresentationData(it.text, "std::modifiers", this.getIcon(0), null)
            // val view = PresentationData(it.text, "", this.getIcon(0), null)
            list.add(ValkyrieViewElement(it))
        }
}

fun ValkyrieDefineBlock?.addChildrenView(list: MutableList<ValkyrieViewElement>) {
    if (this == null) return
    PsiTreeUtil
        .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
        .forEach {
            list.add(ValkyrieViewElement(it))
        }
}
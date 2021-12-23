package valkyrie.language.ast

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.psi.ValkyrieDefineBlock
import valkyrie.language.psi.ValkyrieDefineTuple


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
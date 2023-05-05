package valkyrie.ide.goto_related

import com.intellij.navigation.GotoRelatedItem
import com.intellij.navigation.GotoRelatedProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareMethod
import valkyrie.psi.node.ValkyrieVisitor

/** Ctrl + Alt + Home */
class GotoRelatedSymbol : GotoRelatedProvider() {
    override fun getItems(context: DataContext): MutableList<out GotoRelatedItem> {
        return mutableListOf()
    }

    override fun getItems(psiElement: PsiElement): MutableList<out GotoRelatedItem> {
        val visitor = GotoRelatedVisitor()
        psiElement.accept(visitor)
        return visitor.targets
    }
}

private class GotoRelatedVisitor : ValkyrieVisitor() {
    val targets: MutableList<GotoRelatedItem> = mutableListOf()
    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        targets.add(GotoRelatedItem(o, "a"))
        targets.add(GotoRelatedItem(o.parent, "a"))
        targets.add(GotoRelatedItem(o.parent.parent, "b"))
    }
}
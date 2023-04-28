package valkyrie.ide.reference.declaration

import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.psi.PsiElement
import valkyrie.psi.node.*

/** Ctrl + Shift + B */
class ValkyrieDeclarationProvider : TypeDeclarationProvider {
    override fun getSymbolTypeDeclarations(element: PsiElement): Array<PsiElement> {
        println("getSymbolTypeDeclarations: ${element}")
        val visitor = ValkyrieDeclarationVisitor()
        element.accept(visitor)
        return visitor.declarations.toTypedArray()
    }

    override fun getActionText(context: DataContext): String {
        return "ValkyrieTypeDeclarationProvider.GetActionText"
    }
}


private class ValkyrieDeclarationVisitor : ValkyrieVisitor() {
    var declarations: MutableList<PsiElement> = mutableListOf()

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        o as ValkyrieDeclareClassNode
        o.nameIdentifier?.let {
            declarations.add(o)
        }
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        o as ValkyrieDeclareTraitNode
        o.nameIdentifier?.let {
            declarations.add(o)
        }
    }

    override fun visitTraitAlias(o: ValkyrieTraitAlias) {
        o as ValkyrieTraitAliasNode
        o.nameIdentifier?.let {
            declarations.add(o)
        }
    }

}
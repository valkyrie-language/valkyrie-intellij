package valkyrie.ide.reference.declaration

import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolDeclarationProvider
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareClass
import valkyrie.psi.node.ValkyrieDeclareClassNode
import valkyrie.psi.node.ValkyrieDeclareImply
import valkyrie.psi.node.ValkyrieVisitor


class SymbolDeclarationProvider : PsiSymbolDeclarationProvider {
    override fun getDeclarations(element: PsiElement, offsetInElement: Int): MutableCollection<out PsiSymbolDeclaration> {
        val visitor = SymbolDeclarationProviderVisitor()
        element.accept(visitor)
        return visitor.list
    }
}


class SymbolDeclarationProviderVisitor : ValkyrieVisitor() {
    val list: MutableList<PsiSymbolDeclaration> = mutableListOf()

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
//        list.add(ValkyriePsiSymbolDeclaration(o))
    }

    override fun visitDeclareImply(o: ValkyrieDeclareImply) {

    }
}


class ValkyriePsiSymbolDeclaration : PsiSymbolDeclaration {
    val source: ValkyrieDeclareClassNode

    constructor(source: ValkyrieDeclareClass) {
        this.source = source as ValkyrieDeclareClassNode
    }

    override fun getDeclaringElement(): PsiElement {
        return source
    }

    override fun getRangeInDeclaringElement(): TextRange {
        return source.textRange
    }

    override fun getSymbol(): Symbol {
        TODO("Not yet implemented")
//        return PsiSymbolService.getInstance().asSymbol(source)
    }
}

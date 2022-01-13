package valkyrie.ide.reference.declaration

import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolDeclarationProvider
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class SymbolDeclarationProvider : PsiSymbolDeclarationProvider {
    override fun getDeclarations(element: PsiElement, offsetInElement: Int): MutableCollection<out PsiSymbolDeclaration> {
        return mutableListOf()
    }
}

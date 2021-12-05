package valkyrie.ide.reference.declaration

import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolDeclarationProvider
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.psi_node.ValkyrieDefineStatementNode

@Suppress("UnstableApiUsage")
object SymbolDeclarationProvider : PsiSymbolDeclarationProvider {
    override fun getDeclarations(element: PsiElement, offsetInElement: Int): MutableCollection<out PsiSymbolDeclaration> {
        return mutableListOf()
    }
}

package valkyrie.ide.usages

import valkyrie.language.psi_node.*
import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ValkyrieClassDeclaration

class ValkyrieUsagesFactory : FindUsagesHandlerFactory() {
    override fun canFindUsages(element: PsiElement): Boolean {
        return when (element) {
            is ValkyrieTraitStatementNode,
            is ValkyrieClassDeclaration,
            -> true
            else -> false
        }
    }

    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler? {
        return when (element) {
            is ValkyrieClassDeclaration -> ValkyrieUsagesHandler(element)
            else -> null
        }
    }
}
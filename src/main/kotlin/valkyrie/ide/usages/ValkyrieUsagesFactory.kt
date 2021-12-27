package valkyrie.ide.usages

import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ValkyrieClassStatement
import valkyrie.language.ast.ValkyrieTraitStatement

class ValkyrieUsagesFactory : FindUsagesHandlerFactory() {
    override fun canFindUsages(element: PsiElement): Boolean {
        return when (element) {
            is ValkyrieTraitStatement,
            is ValkyrieClassStatement,
            -> true
            else -> false
        }
    }

    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler? {
        return when (element) {
            is ValkyrieClassStatement -> ValkyrieUsagesHandler(element)
            else -> null
        }
    }
}
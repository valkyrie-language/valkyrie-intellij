package valkyrie.ide.usages

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import valkyrie.ast.ValkyrieParserDefinition
import valkyrie.cst.SYMBOL
import valkyrie.cst.SYMBOL_RAW
import valkyrie.cst.ValkyrieLexer


class ValkyrieUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner {
        val def = ValkyrieParserDefinition()
        return DefaultWordsScanner(
            ValkyrieLexer(),
            TokenSet.create(
                SYMBOL, SYMBOL_RAW
            ),
            def.commentTokens,
            TokenSet.create(),
            TokenSet.EMPTY
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        // return psiElement is PsiNamedElement
        return true
    }

    override fun getHelpId(psiElement: PsiElement): String {
        return "getHelpId"
    }

    override fun getType(element: PsiElement): String {
        return "getType"
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return "getDescriptiveName23"
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        return "getNodeText"
    }
}

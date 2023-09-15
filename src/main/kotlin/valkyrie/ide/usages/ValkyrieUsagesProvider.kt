package valkyrie.ide.usages


import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import valkyrie.psi.ParserDefinition
import valkyrie.psi.ValkyrieLexer
import valkyrie.psi.ValkyrieTypes


class ValkyrieUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner {

        return DefaultWordsScanner(
            ValkyrieLexer(),
            TokenSet.create(ValkyrieTypes.SYMBOL, ValkyrieTypes.SYMBOL_RAW),
            TokenSet.create(ValkyrieTypes.COMMENT_LINE, ValkyrieTypes.COMMENT_BLOCK),
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
package valkyrie.ide.usages


import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import valkyrie.language.lexer.ValkyrieProgramLexer

class ValkyrieUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner {

        return DefaultWordsScanner(
            ValkyrieProgramLexer(),
            ValkyrieProgramLexer.Id,
            ValkyrieProgramLexer.Id,
            TokenSet.create(ValkyrieProgramLexer.CommentLine, ValkyrieProgramLexer.CommentBlock),
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
        return "getDescriptiveName"
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        return "getNodeText"
    }
}
package valkyrie.ide.usages


import valkyrie.language.psi.ValkyrieTypes
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieLexer

class ValkyrieUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner {
        val lexer = ValkyrieLexer(null)
        return DefaultWordsScanner(
            ANTLRLexerAdaptor(ValkyrieLanguage, lexer),
            TokenSet.create(ValkyrieTypes.SYMBOL_XID),
            TokenSet.create(ValkyrieTypes.SYMBOL_RAW),
            TokenSet.create(ValkyrieTypes.COMMENT_LINE),
            TokenSet.create(ValkyrieTypes.COMMENT_BLOCK),
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
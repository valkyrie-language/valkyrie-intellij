package valkyrie.reference

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet
import valkyrie.language.ValkyrieLanguageConfig
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.psi.lexers.ValkyrieLexer
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Valkyrie 查找使用处提供者
 */
class ValkyrieFindUsagesProvider : FindUsagesProvider {

    override fun getWordsScanner(): WordsScanner? {
        return DefaultWordsScanner(
            ValkyrieLexer(ValkyrieLanguageConfig()),
            TokenSet.create(ValkyrieTypes.SYMBOL_XID, ValkyrieTypes.SYMBOL_RAW),
            TokenSet.create(ValkyrieTypes.COMMENT_LINE, ValkyrieTypes.COMMENT_RANGE),
            TokenSet.create(ValkyrieTypes.STRING_DQ)
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is ValkyrieIdentifierNode
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return null
    }

    override fun getType(element: PsiElement): String {
        return when (element) {
            is ValkyrieIdentifierNode -> "variable"
            else -> ""
        }
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return when (element) {
            is PsiNamedElement -> element.name ?: "<unnamed>"
            else -> ""
        }
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        return when (element) {
            is PsiNamedElement -> element.name ?: "<unnamed>"
            else -> ""
        }
    }
}
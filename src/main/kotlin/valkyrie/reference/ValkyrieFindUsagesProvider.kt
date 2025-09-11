package valkyrie.reference

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet
import valkyrie.psi.ValkyrieLexer
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.nodes.ValkyrieIdentifierPatternNode

/**
 * Valkyrie 查找使用处提供者
 */
class ValkyrieFindUsagesProvider : FindUsagesProvider {
    
    override fun getWordsScanner(): WordsScanner? {
        return DefaultWordsScanner(
            ValkyrieLexer(),
            TokenSet.create(ValkyrieTokenTypes.IDENTIFIER),
            TokenSet.create(ValkyrieTokenTypes.LINE_COMMENT, ValkyrieTokenTypes.BLOCK_COMMENT),
            TokenSet.create(ValkyrieTokenTypes.STRING)
        )
    }
    
    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is ValkyrieIdentifierPatternNode
    }
    
    override fun getHelpId(psiElement: PsiElement): String? {
        return null
    }
    
    override fun getType(element: PsiElement): String {
        return when (element) {
            is ValkyrieIdentifierPatternNode -> "variable"
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
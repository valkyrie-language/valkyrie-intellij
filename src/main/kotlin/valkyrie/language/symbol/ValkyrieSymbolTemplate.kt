package valkyrie.language.symbol

import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
open class ValkyrieSymbolTemplate(open val target: PsiElement) : PsiSymbolDeclaration {
    override fun getSymbol(): ValkyrieSymbol = ValkyrieSymbol()
    override fun getDeclaringElement(): PsiElement = target
    override fun getRangeInDeclaringElement(): TextRange = target.textRange
}


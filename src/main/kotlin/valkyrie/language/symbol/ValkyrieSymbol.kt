package valkyrie.language.symbol

import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
open class ValkyrieSymbol(open val target: PsiElement) : Pointer<ValkyrieSymbol>, Symbol, PsiSymbolDeclaration {
    override fun createPointer(): Pointer<out ValkyrieSymbol> = this
    override fun dereference(): ValkyrieSymbol = this
    override fun getSymbol(): ValkyrieSymbol = this
    override fun getDeclaringElement(): PsiElement = target
    override fun getRangeInDeclaringElement(): TextRange = target.textRange
}

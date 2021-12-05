package valkyrie.language.symbol

import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
open class ValkyrieDeclaration(open val target: PsiElement) : Pointer<ValkyrieDeclaration>, Symbol, PsiSymbolDeclaration {
    override fun createPointer(): Pointer<out ValkyrieDeclaration> = this
    override fun dereference(): ValkyrieDeclaration = this
    override fun getSymbol(): ValkyrieDeclaration = this
    override fun getDeclaringElement(): PsiElement = target
    override fun getRangeInDeclaringElement(): TextRange = target.textRange
}

package valkyrie.ide.hint

import com.intellij.codeInsight.daemon.QuickFixActionRegistrar
import com.intellij.codeInsight.quickfix.UnresolvedReferenceQuickFixProvider
import valkyrie.language.symbol.ValkyrieDeclared

class unresolvedReferenceQuickFixProvider : UnresolvedReferenceQuickFixProvider<ValkyrieDeclared>() {
    override fun registerFixes(ref: ValkyrieDeclared, registrar: QuickFixActionRegistrar) {

    }

    override fun getReferenceClass(): Class<ValkyrieDeclared> {
        return ValkyrieDeclared::class.java
    }
}

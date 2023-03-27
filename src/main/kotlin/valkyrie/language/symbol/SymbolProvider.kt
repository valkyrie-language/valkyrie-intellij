package yggdrasil.language.symbol

import com.intellij.model.presentation.SymbolDeclarationPresentation
import com.intellij.model.presentation.SymbolDeclarationPresentationProvider
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

object SymbolProvider : SymbolDeclarationPresentationProvider<ValkyrieDeclared> {
    override fun getPresentation(symbolDeclaration: ValkyrieDeclared): SymbolDeclarationPresentation? {
        return object : SymbolDeclarationPresentation {
            override fun getPresentableText(): String? {
                return "SymbolDeclarationPresentation.getPresentableText"
            }

            override fun getIcon(unused: Boolean): Icon? {
                return ValkyrieIconProvider.Instance.File
            }
        }
    }
}

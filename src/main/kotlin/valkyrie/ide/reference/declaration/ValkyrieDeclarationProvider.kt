package valkyrie.ide.reference.declaration

import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieFileNode.Companion.definitions
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.*

/** Ctrl + Shift + B */
class ValkyrieDeclarationProvider : TypeDeclarationProvider {
    override fun getSymbolTypeDeclarations(element: PsiElement): Array<PsiElement> {
        val visitor = ValkyrieDeclarationVisitor()
        element.accept(visitor)
        return visitor.declarations.toTypedArray()
    }

    override fun getActionText(context: DataContext): String {
        return ValkyrieBundle.message("action.goto.declaration")
    }
}


private class ValkyrieDeclarationVisitor : ValkyrieVisitor() {
    var declarations: MutableList<PsiElement> = mutableListOf()

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        // jump to symbol start
        o.identifier?.let { declarations.add(o) }
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        // jump to symbol start
//        o.identifier?.let { declarations.add(o) }
    }

    override fun visitTraitAlias(o: ValkyrieTraitAlias) {
        // jump to symbol start
        o.identifier.let { declarations.add(o) }
    }

    override fun visitNamepath(o: ValkyrieNamepath) {
        o as ValkyrieNamepathNode


        for (element in o.containingFile?.children ?: arrayOf()) {
            if (element is ValkyrieDeclaration) {
                if (element.name == o.name) {
                    declarations.add(element)
                }
            }
        }
    }

    override fun visitModifier(o: ValkyrieModifier) {
        o as ValkyrieModifierNode
        for (item in o.containingFile.definitions) {
            if (item.name == o.name) {
                declarations.add(item)
            }
        }
    }
}

package valkyrie.ide.reference.declaration

import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.psi.PsiElement
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.node.ValkyrieClassNode
import valkyrie.ast.node.ValkyrieModifierNode
import valkyrie.ast.node.ValkyrieNamePathNode
import valkyrie.ast.node.ValkyrieTraitNode
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieFileNode.Companion.definitions
import valkyrie.psi.ValkyrieDeclaration

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

    override fun visitDeclareClass(o: ValkyrieClassNode) {
        // jump to symbol start
        o.identifier?.let { declarations.add(o) }
    }

    override fun visitDeclareTrait(o: ValkyrieTraitNode) {
        o.identifier?.let { declarations.add(o) }
    }

    override fun visitNamePath(o: ValkyrieNamePathNode) {

        for (element in o.containingFile?.children ?: arrayOf()) {
            if (element is ValkyrieDeclaration) {
                if (element.name == o.name) {
                    declarations.add(element)
                }
            }
        }
    }

    override fun visitModifier(o: ValkyrieModifierNode) {
        for (item in o.containingFile.definitions) {
            if (item.name == o.name) {
                declarations.add(item)
            }
        }
    }
}

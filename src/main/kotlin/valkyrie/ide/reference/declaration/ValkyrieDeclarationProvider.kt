package valkyrie.ide.reference.declaration

import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.usages.UsageTarget
import com.intellij.usages.UsageTargetProvider
import valkyrie.language.ValkyrieBundle
import valkyrie.psi.ValkyrieDeclareElement
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
        o.identifier?.let { declarations.add(o) }
    }

    override fun visitTraitAlias(o: ValkyrieTraitAlias) {
        // jump to symbol start
        o.identifier.let { declarations.add(o) }
    }

    override fun visitNamepath(o: ValkyrieNamepath) {
        o as ValkyrieNamepathNode
        for (element in o.containingFile.children) {
            if (element is ValkyrieDeclareElement) {
                if (element.name == o.name) {
                    declarations.add(element)
                }
            }
        }
    }

    override fun visitModifier(o: ValkyrieModifier) {
        o as ValkyrieModifierNode
        for ((key, value) in o.containingFile.definitions.getCache()) {
            if (key == o.name) {
                declarations.add(value)
            }
        }
    }
}

class ValkyrieUsageTargetProvider : UsageTargetProvider {
    override fun getTargets(psiElement: PsiElement): Array<UsageTarget> {
        println("getTargets1: $psiElement")
        return arrayOf()
    }

    override fun getTargets(editor: Editor, file: PsiFile): Array<UsageTarget> {
        println("getTargets2: $file")
        return arrayOf()
    }
}

class ValkyrieUsageTargetVisitor : ValkyrieVisitor() {
    val targets: MutableList<UsageTarget> = mutableListOf()


}


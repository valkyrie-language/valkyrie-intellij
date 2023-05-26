package valkyrie.ide.goto_super

import com.intellij.codeInsight.navigation.GotoTargetHandler
import com.intellij.codeInsight.navigation.GotoTargetHandler.GotoData
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.mixin.superClasses
import valkyrie.psi.node.*

class GotoSuperSymbol : GotoTargetHandler() {
    override fun getFeatureUsedKey() = "valkyrie.goto.super";
    override fun getSourceAndTargetElements(editor: Editor, file: PsiFile): GotoData? {
        val element = ValkyrieDeclaration.getCaretDeclaration(editor, file)
        val visitor = GotoSuperVisitor()
        element?.accept(visitor)
        return visitor.target
    }


    override fun getChooserTitle(sourceElement: PsiElement, name: String?, length: Int, finished: Boolean): String {
        val sb = if (finished) {
            StringBuilder("Found ")
        } else {
            StringBuilder("Finding ")
        }

        when (sourceElement) {
            is ValkyrieDeclareClassNode -> {
                sb.append("super classes")
            }

            is ValkyrieDeclareTraitNode -> {
                sb.append("trait bounds")
            }

            is ValkyrieTraitAliasNode -> {
                sb.append("trait aliases")
            }

            else -> {
                sb.append("super $sourceElement")
            }
        }
        return sb.toString()
    }

    override fun getAdText(source: PsiElement?, length: Int): String {
        return "Found $length items"
    }

    override fun getNotFoundMessage(project: Project, editor: Editor, file: PsiFile): String {
        return when (val element = ValkyrieDeclaration.getCaretDeclaration(editor, file)) {
            is ValkyrieDeclareClassNode -> {
                "`${element.name}` has no super class"
            }

            is ValkyrieDeclareTraitNode -> {
                "`${element.name}` has no trait bounds"
            }

            else -> {
                "Can't find super symbol for `${element?.name}`"
            }
        }
    }
}


private class GotoSuperVisitor : ValkyrieVisitor() {
    var target: GotoData? = null

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {

        target = GotoData(o, o.superClasses.toTypedArray(), listOf())
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        target = GotoData(o, arrayOf(o.typeHint), listOf())
    }

    override fun visitTraitAlias(o: ValkyrieTraitAlias) {
        target = GotoData(o, arrayOf(o.typeExpression, o.typeExpression), listOf())
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        o as ValkyrieDeclareMethodNode;
        target = GotoData(o, arrayOf(o, o.parent), listOf())
    }
}
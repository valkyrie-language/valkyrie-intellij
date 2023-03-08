package valkyrie.ide.hint

import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering
import com.intellij.codeInsight.hints.codeVision.InheritorsCodeVisionProvider
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.ast.ValkyrieTraitStatement
import valkyrie.language.ast.classes.ValkyrieClassStatement
import valkyrie.language.file.ValkyrieFileNode
import java.awt.event.MouseEvent

class VisionInheritors : InheritorsCodeVisionProvider() {
    override val defaultAnchor: CodeVisionAnchorKind
        get() = CodeVisionAnchorKind.Top
    override val id: String
        get() = "InheritorsVision"
    override val relativeOrderings: List<CodeVisionRelativeOrdering>
        get() = emptyList()

    override fun acceptsElement(element: PsiElement): Boolean {
        if (element is ValkyrieClassStatement) {
            return true
        } else if (element is ValkyrieTraitStatement) {
            return true
        }
        return false
    }

    override fun acceptsFile(file: PsiFile): Boolean {
        return file is ValkyrieFileNode
    }

    override fun getVisionInfo(element: PsiElement, file: PsiFile): CodeVisionInfo? {
        val hint = "\"InheritorsVision getHint\"" ?: return null
        return CodeVisionInfo(hint, 5, false)
    }

    override fun getHint(element: PsiElement, file: PsiFile): String? {
        return "Inheritors ${0}"
    }

    override fun handleClick(editor: Editor, element: PsiElement, event: MouseEvent?) {

    }
}
package valkyrie.ide.hint

//import valkyrie.language.psi_node.ValkyrieDefineStatementNode
//import valkyrie.language.psi_node.ValkyrieExtendsStatementNode
//import valkyrie.language.psi_node.ValkyrieUnionStatementNode
import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.CodeVisionHost
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering
import com.intellij.codeInsight.codeVision.ui.model.ClickableTextCodeVisionEntry
import com.intellij.codeInsight.hints.InlayHintsUtils
import com.intellij.codeInsight.hints.codeVision.DaemonBoundCodeVisionProvider
import com.intellij.codeInsight.hints.codeVision.ReferencesCodeVisionProvider
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.SyntaxTraverser
import valkyrie.language.ast.ValkyrieTraitStatement
import valkyrie.language.ast.classes.ValkyrieClassMethodNode
import valkyrie.language.ast.classes.ValkyrieClassStatement
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.file.ValkyrieIconProvider
import java.awt.event.MouseEvent


class VisionReferences : ReferencesCodeVisionProvider() {
    override val defaultAnchor: CodeVisionAnchorKind
        get() = CodeVisionAnchorKind.Top
    override val id: String
        get() = "VisionReferences"
    override val relativeOrderings: List<CodeVisionRelativeOrdering>
        get() = emptyList()

    override fun getVisionInfo(element: PsiElement, file: PsiFile): CodeVisionInfo? {
        val hint = "\"VisionReferences getHint\"" ?: return null
        return CodeVisionInfo(hint, 5, true)
    }

    override fun acceptsElement(element: PsiElement): Boolean {
        return when (element) {
            is ValkyrieClassStatement -> {
                true
            }

            is ValkyrieClassMethodNode -> {
                true
            }

            is ValkyrieTraitStatement -> {
                true
            }

            else -> false
        }
    }

    override fun acceptsFile(file: PsiFile): Boolean {
        return file is ValkyrieFileNode
    }

    override fun getHint(element: PsiElement, file: PsiFile): String? {
        return "References ${5}"
    }
}

abstract class ValkyrieCodeVision : DaemonBoundCodeVisionProvider {
    override val defaultAnchor: CodeVisionAnchorKind = CodeVisionAnchorKind.Top
    override val relativeOrderings: List<CodeVisionRelativeOrdering> = emptyList()


    override fun computeForEditor(editor: Editor, file: PsiFile): List<Pair<TextRange, CodeVisionEntry>> {
        if (file.project.isDefault || file !is ValkyrieFileNode) return emptyList()
        // we want to let this provider work only in tests dedicated for code vision, otherwise they harm performance
        if (ApplicationManager.getApplication().isUnitTestMode && !CodeVisionHost.isCodeLensTest()) return emptyList()

        val virtualFile = file.viewProvider.virtualFile
        if (ProjectFileIndex.getInstance(file.project).isInLibrarySource(virtualFile)) return emptyList()

        val lenses = ArrayList<Pair<TextRange, CodeVisionEntry>>()
        val traverser = SyntaxTraverser.psiTraverser(file)
        for (element in traverser) {
            val hint = getCodeVision(element) ?: continue
            if (!InlayHintsUtils.isFirstInLine(element)) continue
            val range = InlayHintsUtils.getTextRangeWithoutLeadingCommentsAndWhitespaces(element)
            lenses.add(range to hint)
        }
        return lenses
    }

    abstract fun getCodeVision(element: PsiElement): CodeVisionEntry?;
    fun onClick(click: MouseEvent?, editor: Editor) {
    }
}

class VisionMonomorphisms : ValkyrieCodeVision() {
    override val id: String = "VisionMonomorphisms"
    override val name: String = "VisionMonomorphisms"

    override fun getCodeVision(element: PsiElement): ClickableTextCodeVisionEntry? {
        return ClickableTextCodeVisionEntry(
            "Monomorphisms",
            id,
            onClick,
            ValkyrieIconProvider.Instance.Valkyrie,
            "longPresentation",
            "tooltip",
            listOf()
        )
    }

    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {

    }
}

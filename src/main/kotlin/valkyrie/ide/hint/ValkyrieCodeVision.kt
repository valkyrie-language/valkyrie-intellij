package valkyrie.ide.hint

import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.CodeVisionHost
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering
import com.intellij.codeInsight.hints.InlayHintsUtils
import com.intellij.codeInsight.hints.codeVision.DaemonBoundCodeVisionProvider
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.SyntaxTraverser
import valkyrie.language.file.ValkyrieFileNode


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
    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {

    }
}
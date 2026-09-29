package voml.editing.highlight

import voml.surface.file.VomlFile
import voml.surface.psi.VomlTypes
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class VomlHighlightVisitor : HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visit(element: PsiElement) {
        when (element.node.elementType) {
            VomlTypes.PREDEFINED_SYMBOL -> highlight(element, VomlColor.PREDEFINED)
            VomlTypes.SCOPE_SYMBOL -> highlight(element, VomlColor.SCOPE_SYMBOL)
            VomlTypes.KEY_SYMBOL -> highlight(element, VomlColor.KEY_SYMBOL)
            VomlTypes.STRING_PREFIX -> highlight(element, VomlColor.STRING_HINT)
            VomlTypes.NUMBER_SUFFIX -> highlight(element, VomlColor.NUMBER_HINT)
            VomlTypes.TYPE_HINT -> highlight(element, VomlColor.TYPE_HINT)
            VomlTypes.ANNOTATION_MARK -> highlight(element, VomlColor.ANNOTATION)
            VomlTypes.INSERT_DOT, VomlTypes.INSERT_STAR -> highlight(element, VomlColor.INSERT_MARK)
            else -> Unit
        }
    }

    private fun highlight(element: PsiElement, color: VomlColor) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)
        infoHolder?.add(builder.create())
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable,
    ): Boolean {
        infoHolder = holder
        action.run()
        return true
    }

    override fun clone(): HighlightVisitor = VomlHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is VomlFile
}

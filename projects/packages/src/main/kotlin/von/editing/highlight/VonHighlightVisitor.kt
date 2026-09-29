package von.editing.highlight

import von.surface.file.VonFile
import von.surface.psi.VonTypes
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class VonHighlightVisitor : HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visit(element: PsiElement) {
        when (element.node.elementType) {
            VonTypes.PREDEFINED_SYMBOL -> highlight(element, VonColor.PREDEFINED)
            VonTypes.SCOPE_SYMBOL -> highlight(element, VonColor.SCOPE_SYMBOL)
            VonTypes.KEY_SYMBOL -> highlight(element, VonColor.KEY_SYMBOL)
            VonTypes.STRING_PREFIX -> highlight(element, VonColor.STRING_HINT)
            VonTypes.NUMBER_SUFFIX -> highlight(element, VonColor.NUMBER_HINT)
            VonTypes.TYPE_HINT -> highlight(element, VonColor.TYPE_HINT)
            VonTypes.ANNOTATION_MARK -> highlight(element, VonColor.ANNOTATION)
            VonTypes.INSERT_DOT, VonTypes.INSERT_STAR -> highlight(element, VonColor.INSERT_MARK)
            else -> Unit
        }
    }

    private fun highlight(element: PsiElement, color: VonColor) {
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

    override fun clone(): HighlightVisitor = VonHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is VonFile
}

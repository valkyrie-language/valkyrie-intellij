package valkyrie.ide.highlight

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.psi.nodes.ValkyrieFileNode
import valkyrie.psi.nodes.ValkyrieTraitDeclaration
import valkyrie.psi.nodes.ValkyrieVariantDeclaration

class ValkyrieSemanticHighlighter : HighlightVisitor, PsiElementVisitor() {
    private var infoHolder: HighlightInfoHolder? = null

    //
    override fun suitableForFile(file: PsiFile): Boolean = file is ValkyrieFileNode

    override fun visit(element: PsiElement) {
        when (element) {
            is ValkyrieClassDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYMBOL_CLASS)
            }

            is ValkyrieTraitDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYMBOL_TRAIT)
            }

            is ValkyrieVariantDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_VARIANT)
            }
        }
    }

    private fun highlight(element: PsiElement?, color: ValkyrieColor) {
        print("正在为 `${element?.text}` 添加 ${color.name}\n")
        if (element == null) {
            return
        }

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

    override fun clone(): HighlightVisitor = ValkyrieSemanticHighlighter()
}
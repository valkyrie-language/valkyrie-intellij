package valkyrie.ide.highlight

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import valkyrie.psi.nodes.*

class ValkyrieSemanticHighlighter : HighlightVisitor, PsiElementVisitor() {
    private var infoHolder: HighlightInfoHolder? = null

    //
    override fun suitableForFile(file: PsiFile): Boolean = file is ValkyrieFileNode

    override fun visit(element: PsiElement) {
        when (element) {
            is ValkyrieClassDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_CLASS)
            }

            is ValkyrieTraitDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_TRAIT)
            }

            is ValkyrieUnionDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_VARIANT)
            }

            is ValkyrieVariantDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_VARIANT)
            }

            is ValkyrieFieldDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_FIELD)
            }

            is ValkyrieMethodDeclaration -> {
                if (element.isMutable()) {
                    highlight(element.nameIdentifier, ValkyrieColor.SYM_METHOD_MUT)
                } else if (element.isStatic()) {
                    highlight(element.nameIdentifier, ValkyrieColor.SYM_FUNCTION_SELF)
                } else {
                    highlight(element.nameIdentifier, ValkyrieColor.SYM_FUNCTION_FREE)
                }
            }

            is ValkyrieDomainDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_DOMAIN)
            }

            is ValkyrieModifierNode -> {
                highlight(element, ValkyrieColor.SYM_MODIFIER)
            }
        }
    }

    private fun highlight(element: PsiElement?, color: ValkyrieColor) {
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
package valkyrie.ide.annotator

import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.codeInsight.intention.numeric.AbstractNumberConversionIntention
import com.intellij.codeInsight.intention.numeric.NumberConverter
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.ide.formatter.ValkyrieNumberConverter

class ConvertNumber : AbstractNumberConversionIntention() {
    override fun extract(element: PsiElement): NumberConversionContext? {

        return NumberConversionContext(element, 0, "NumberConversionContext", true)


    }

    override fun getConverters(file: PsiFile): MutableList<NumberConverter> {
        return mutableListOf(ValkyrieNumberConverter())
    }

    override fun replace(sourceElement: PsiElement?, replacement: String?) {
        TODO("Not yet implemented")
    }
}
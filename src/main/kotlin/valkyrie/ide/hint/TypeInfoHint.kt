package valkyrie.ide.hint

import com.intellij.lang.ExpressionTypeProvider
import com.intellij.psi.PsiElement

class TypeInfoHint : ExpressionTypeProvider<PsiElement>() {
    override fun getInformationHint(element: PsiElement): String {
        TODO("Not yet implemented")
    }

    override fun getErrorHint(): String {
        TODO("Not yet implemented")
    }

    override fun getExpressionsAt(elementAt: PsiElement): MutableList<PsiElement> {
        TODO("Not yet implemented")
    }
}


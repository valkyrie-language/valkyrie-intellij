package valkyrie.ide.hint

import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.codeInsight.quickfix.ChangeVariableTypeQuickFixProvider
import com.intellij.psi.PsiType
import com.intellij.psi.PsiVariable

class changeVariableTypeQuickFixProvider : ChangeVariableTypeQuickFixProvider {
    override fun getFixes(variable: PsiVariable, toReturn: PsiType): Array<IntentionAction> {
        return arrayOf()
    }
}

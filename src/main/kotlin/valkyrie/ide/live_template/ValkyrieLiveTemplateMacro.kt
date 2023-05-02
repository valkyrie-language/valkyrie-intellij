package valkyrie.ide.completion

import com.intellij.codeInsight.lookup.LookupFocusDegree
import com.intellij.codeInsight.template.Expression
import com.intellij.codeInsight.template.ExpressionContext
import com.intellij.codeInsight.template.Macro
import com.intellij.codeInsight.template.Result

class ValkyrieLiveTemplateMacro : Macro() {
    override fun getName(): String {
        return "ValkyrieLiveTemplateMacro"
    }

    override fun calculateResult(params: Array<out Expression>, context: ExpressionContext?): Result? {
        return null
    }

    override fun getDefaultValue(): String {
        return super.getDefaultValue()
    }

    override fun getLookupFocusDegree(): LookupFocusDegree {
        return super.getLookupFocusDegree()
    }

    override fun getPresentableName(): String {
        return super.getPresentableName()
    }
}
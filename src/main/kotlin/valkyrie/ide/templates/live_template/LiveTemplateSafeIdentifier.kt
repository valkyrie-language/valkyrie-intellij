package valkyrie.ide.live_template

import com.intellij.codeInsight.lookup.LookupFocusDegree
import com.intellij.codeInsight.template.Expression
import com.intellij.codeInsight.template.ExpressionContext
import com.intellij.codeInsight.template.Macro
import com.intellij.codeInsight.template.Result


class LiveTemplateSafeIdentifier : Macro() {
    override fun getName(): String {
        return "safe-identifier"
    }

    override fun getPresentableName(): String {
        return "@safe-identifier(id: String)"
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


}


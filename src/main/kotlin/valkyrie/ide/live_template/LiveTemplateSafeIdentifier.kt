package valkyrie.ide.live_template

import com.intellij.codeInsight.lookup.LookupFocusDegree
import com.intellij.codeInsight.template.*
import com.intellij.codeInsight.template.macro.MacroBase
import com.intellij.openapi.util.text.StringUtil


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

class LiveTemplateSafeExpression : MacroBase {
    constructor() : super("safe-identifier", "titleCase(String)")

    /**
     * Strictly to uphold contract for constructors in base class.
     */
    private constructor(name: String, description: String) : super(name, description)

    override fun calculateResult(params: Array<out Expression>, context: ExpressionContext?, quick: Boolean): Result? {
        // Retrieve the text from the macro or selection, if any is available.
        var text = getTextResult(params, context, true) ?: return null
        if (text.isNotEmpty()) {
            // Capitalize the start of every word
            text = StringUtil.toTitleCase(text)
        }
        return TextResult(text)
    }

    override fun isAcceptableInContext(context: TemplateContextType): Boolean {
        // Might want to be less restrictive in future
//        return (context is MarkdownContext)
        return true
    }
}
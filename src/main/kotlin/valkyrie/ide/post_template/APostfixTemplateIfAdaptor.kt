package valkyrie.ide.line_marker

import com.intellij.codeInsight.template.postfix.templates.IfPostfixTemplateBase
import com.intellij.json.surroundWith.JsonWithQuotesSurrounder
import com.intellij.lang.surroundWith.Surrounder

class APostfixTemplateIfAdaptor : IfPostfixTemplateBase(APostfixTemplateInfoProvider(), APostfixTemplateSelector()) {
    override fun getSurrounder(): Surrounder {
        return JsonWithQuotesSurrounder()
    }

    override fun getDescription(): String {
        return "GetDescription"
    }
}
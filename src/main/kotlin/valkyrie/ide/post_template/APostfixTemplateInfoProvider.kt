package valkyrie.ide.line_marker

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplatePsiInfo
import com.intellij.psi.PsiElement

class APostfixTemplateInfoProvider : PostfixTemplatePsiInfo() {
    override fun createExpression(context: PsiElement, prefix: String, suffix: String): PsiElement {
        return context
    }

    override fun getNegatedExpression(element: PsiElement): PsiElement {
        return element
    }
}
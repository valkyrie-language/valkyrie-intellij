package valkyrie.ide.line_marker

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateExpressionSelector
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement

class APostfixTemplateSelector : PostfixTemplateExpressionSelector {
    override fun hasExpression(context: PsiElement, copyDocument: Document, newOffset: Int): Boolean {
        return true
    }

    override fun getExpressions(context: PsiElement, document: Document, offset: Int): MutableList<PsiElement> {
        return mutableListOf(context)
    }

    override fun getRenderer(): com.intellij.util.Function<PsiElement, String> {
        return com.intellij.util.Function<PsiElement, String> { it.text }
    }
}
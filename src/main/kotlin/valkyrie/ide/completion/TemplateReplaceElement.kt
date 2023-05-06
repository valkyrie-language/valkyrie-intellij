package valkyrie.ide.completion

import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement


class TemplateReplaceElement(val element: PsiElement, val id: String, val text: String, val discard: Map<String, String>) :
    InsertHandler<LookupElement> {
    override fun handleInsert(context: InsertionContext, item: LookupElement) {
        context.document.replaceString(context.startOffset, context.tailOffset, "")
        TemplateBuilder(element, context.editor).runFromText(id, text, discard)
    }

}



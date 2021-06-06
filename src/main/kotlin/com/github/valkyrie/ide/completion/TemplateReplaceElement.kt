package com.github.valkyrie.ide.completion

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement


class TemplateReplaceElement(val element: PsiElement, val id: String, val text: String) : InsertHandler<LookupElement> {
    var multipleLines = true;
    override fun handleInsert(context: InsertionContext, item: LookupElement) {
        context.document.replaceString(context.startOffset, context.tailOffset, "")
        TemplateBuilder(element, context.editor).runFromText(id, text)
        if (multipleLines) {
            context.document.insertString(context.tailOffset, "\n")
        }
    }

    companion object {
        fun snippetFromPath(
            element: PsiElement,
            id: String,
            file: String,
            lookup: Set<String> = setOf(),
            multipleLines: Boolean = true
        ): LookupElementBuilder {
            val path = "/templates/liveTemplate/$file";
            val text = object {}.javaClass.getResourceAsStream(path)?.use { it.reader(Charsets.UTF_8).readText() } ?: path
            val insert = TemplateReplaceElement(element, id, text);
            insert.multipleLines = multipleLines;
            return LookupElementBuilder.create(id).bold()
                .withLookupStrings(lookup)
                .withIcon(ValkyrieIconProvider.SNIPPET)
                .withInsertHandler(insert)
        }
    }
}



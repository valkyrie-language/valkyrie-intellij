package valkyrie.ide.completion

import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.TemplateManager


class ValkyrieLiveCompletionTemplate : ValkyrieLookupElement {
    var template: Template;

    constructor(live: Template) {
        this.template = live
    }

    override fun handleInsert(context: InsertionContext) {
        val manager = TemplateManager.getInstance(context.project);
        context.document.deleteString(context.startOffset, context.tailOffset)
        context.setAddCompletionChar(false)
        manager.startTemplate(context.editor, template)
    }
}




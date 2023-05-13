package valkyrie.ide.completion

import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.lookup.LookupElementPresentation
import com.intellij.codeInsight.template.CustomTemplateCallback
import com.intellij.codeInsight.template.postfix.templates.PostfixLiveTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.icons.ExpUiIcons
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import valkyrie.ide.templates.post_template.ValkyriePostfixTemplateProvider

open class ValkyriePostCompletionTemplate : ValkyrieLookupElement {
    private val postfixTemplate: PostfixTemplate

    constructor(postTemplate: PostfixTemplate) : super() {
        this.postfixTemplate = postTemplate
        this.setLookup(postfixTemplate.key)
    }

    override fun renderElement(presentation: LookupElementPresentation) {
        super.renderElement(presentation)
        presentation.icon = ExpUiIcons.Nodes.Template
    }


    override fun handleInsert(context: InsertionContext) {
        context.setAddCompletionChar(false)
        expandTemplate(context.editor, context.file)
    }

    private fun expandTemplate(editor: Editor, file: PsiFile) {
        val provider = ValkyriePostfixTemplateProvider();
        PostfixLiveTemplate.expandTemplate(
            postfixTemplate.key,
            CustomTemplateCallback(editor, file),
            editor,
            provider,
            postfixTemplate
        )
    }
}
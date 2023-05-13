package valkyrie.ide.completion

import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.lookup.LookupElementPresentation
import com.intellij.codeInsight.template.CustomTemplateCallback
import com.intellij.codeInsight.template.impl.CustomLiveTemplateLookupElement
import com.intellij.codeInsight.template.postfix.templates.PostfixLiveTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiFile
import valkyrie.ide.templates.post_template.ValkyriePostfixTemplateProvider

open class ValkyriePostCompletionTemplate : CustomLiveTemplateLookupElement {
    private val postfixTemplate: PostfixTemplate
    private val myTemplateKey: String

    constructor(
        liveTemplate: PostfixLiveTemplate,
        postfixTemplate: PostfixTemplate,
        myTemplateKey: String,
        sudden: Boolean,
    ) : super(
        liveTemplate,
        myTemplateKey, StringUtil.trimStart(myTemplateKey, "."), postfixTemplate.description, sudden, true
    ) {
        this.postfixTemplate = postfixTemplate
        this.myTemplateKey = myTemplateKey

    }

    override fun renderElement(presentation: LookupElementPresentation) {
        super.renderElement(presentation)
        presentation.typeText = postfixTemplate.example
        presentation.isTypeGrayed = true
    }

    override fun handleInsert(context: InsertionContext) {
        context.setAddCompletionChar(false)
        expandTemplate(context.editor, context.file)
    }

    override fun expandTemplate(editor: Editor, file: PsiFile) {
        val provider = ValkyriePostfixTemplateProvider();
        PostfixLiveTemplate.expandTemplate(
            myTemplateKey,
            CustomTemplateCallback(editor, file),
            editor,
            provider,
            postfixTemplate
        )
    }
}
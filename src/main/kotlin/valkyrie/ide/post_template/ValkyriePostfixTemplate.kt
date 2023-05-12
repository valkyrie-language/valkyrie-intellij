package valkyrie.ide.post_template

import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.codeInsight.template.impl.TemplateImpl
import com.intellij.codeInsight.template.impl.TextExpression
import com.intellij.codeInsight.template.postfix.templates.PostfixLiveTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplatesUtils
import com.intellij.codeInsight.unwrap.ScopeHighlighter
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.Pass
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement
import com.intellij.refactoring.IntroduceTargetChooser
import com.intellij.util.containers.ContainerUtil
import java.util.*

abstract class ValkyriePostfixTemplate(
    templateId: String,
    templateName: String,
    templateKey: String,
    liveTemplate: TemplateImpl,
    example: String,
    provider: PostfixTemplateProvider,
) :
    PostfixTemplate(templateId, templateName, templateKey, example, provider) {
    val liveTemplate: TemplateImpl

    constructor(
        templateId: String,
        templateName: String,
        liveTemplate: TemplateImpl,
        example: String,
        provider: PostfixTemplateProvider,
    ) : this(templateId, templateName, ".$templateName", liveTemplate, example, provider)

    init {
        assert(StringUtil.isNotEmpty(liveTemplate.key))
        this.liveTemplate = liveTemplate
    }

    override fun expand(context: PsiElement, editor: Editor) {
        val expressions = getExpressions(context, editor.document, editor.caretModel.offset)

        if (expressions.isEmpty()) {
            PostfixTemplatesUtils.showErrorHint(context.project, editor)
            return
        }

        if (expressions.size == 1) {
            prepareAndExpandForChooseExpression(expressions[0], editor)
            return
        }

        if (ApplicationManager.getApplication().isUnitTestMode) {
            val item = checkNotNull(ContainerUtil.getFirstItem(expressions))
            prepareAndExpandForChooseExpression(item, editor)
            return
        }

        IntroduceTargetChooser.showChooser(
            editor, expressions,
            object : Pass<PsiElement>() {
                override fun pass(e: PsiElement) {
                    prepareAndExpandForChooseExpression(e, editor)
                }
            },
            getElementRenderer(),
            CodeInsightBundle.message("dialog.title.expressions"), 0, ScopeHighlighter.NATURAL_RANGER
        )
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is ValkyriePostfixTemplate) return false
        if (!super.equals(o)) return false
        return liveTemplate == o.liveTemplate
    }

    override fun hashCode(): Int {
        return Objects.hash(key, liveTemplate)
    }

    protected abstract fun getExpressions(context: PsiElement, document: Document, offset: Int): List<PsiElement>

    override fun isApplicable(context: PsiElement, copyDocument: Document, newOffset: Int): Boolean {
        return getExpressions(context, copyDocument, newOffset).isNotEmpty()
    }

    protected fun addTemplateVariables(element: PsiElement, template: Template) {
    }

    /**
     * @param element element to which the template was applied
     * @return an element to remove before inserting the template
     */
    protected open fun getElementToRemove(element: PsiElement): PsiElement {
        return element
    }

    /**
     * Default implementation delegates to [.getElementToRemove] and takes the text range of the resulting element.
     * Override it if it's desired to remove only a part of `PsiElement`'s range.
     *
     * @param element element to which the template was applied
     * @return a range to remove before inserting the template
     */
    protected fun getRangeToRemove(element: PsiElement): TextRange {
        return getElementToRemove(element).textRange
    }

    protected open fun getElementRenderer(): com.intellij.util.Function<PsiElement, String> {
        return com.intellij.util.Function { element: PsiElement -> element.text }
    }

    override fun getProvider(): PostfixTemplateProvider {
        val provider = checkNotNull(super.getProvider())
        return provider
    }

    private fun prepareAndExpandForChooseExpression(element: PsiElement, editor: Editor) {
        ApplicationManager.getApplication().runWriteAction {
            CommandProcessor.getInstance().executeCommand(
                element.project,
                { expandForChooseExpression(element, editor) },
                CodeInsightBundle.message("command.expand.postfix.template"),
                PostfixLiveTemplate.POSTFIX_TEMPLATE_ID
            )
        }
    }

    private fun expandForChooseExpression(element: PsiElement, editor: Editor) {
        val project = element.project
        val document = editor.document
        val range = getRangeToRemove(element)
        document.deleteString(range.startOffset, range.endOffset)
        val manager = TemplateManager.getInstance(project)

        val template = liveTemplate.copy()
        template.addVariable("EXPR", TextExpression(element.text), false)
        addTemplateVariables(element, template)
        manager.startTemplate(editor, template)
    }
}
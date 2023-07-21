package valkyrie.ide.templates.post_template

import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.codeInsight.template.impl.TemplateImpl
import com.intellij.codeInsight.template.impl.TextExpression
import com.intellij.codeInsight.template.postfix.templates.PostfixLiveTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplatesUtils
import com.intellij.codeInsight.unwrap.ScopeHighlighter
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.Pass
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.IntroduceTargetChooser
import com.intellij.util.containers.ContainerUtil
import valkyrie.ide.completion.ValkyrieLookupElement
import valkyrie.psi.ancestors
import valkyrie.psi.node.*
import java.util.*

open class PostfixTemplateSlotSelector : PostfixTemplate {
    val liveTemplate: TemplateImpl?

    constructor(templateName: String, templateKey: String) : super(null, templateName, templateKey, "", null) {
        this.liveTemplate = ValkyrieLookupElement.getTemplate(templateName)
    }

    override fun getProvider(): ValkyriePostfixTemplateProvider {
        return ValkyriePostfixTemplateProvider()
    }

    override fun getExample(): String {
        return key
    }

    open fun getExpressions(context: PsiElement, document: Document, offset: Int): List<PsiElement> {
//        println("getExpressions: $context")
        val expressions = mutableMapOf<TextRange, PsiElement>()
        for (ancestor in context.ancestors) {
            when (ancestor) {
                is ValkyrieFunctionCallNode,
                is ValkyrieExpressionNode,
                -> {
                    expressions[ancestor.textRange] = ancestor
                }

                is ValkyrieLoopStatementNode,
                is ValkyrieForStatementNode,
                is ValkyrieIfStatementNode,
                -> {
                    return mutableListOf(ancestor)
                }
            }
        }
        return expressions.values.toMutableList()
    }

    open fun expandExpression(element: PsiElement, editor: Editor) {
        expandExpressionSlot(element, editor, "EXPR")
    }

    override fun expand(context: PsiElement, editor: Editor) {
        val expressions = getExpressions(context, editor.document, editor.caretModel.offset)

        if (expressions.isEmpty()) {
            PostfixTemplatesUtils.showErrorHint(context.project, editor)
            return
        }

        if (expressions.size == 1) {
            expandExpression(expressions[0], editor)
            return
        }

        if (ApplicationManager.getApplication().isUnitTestMode) {
            val item = checkNotNull(ContainerUtil.getFirstItem(expressions))
            expandExpression(item, editor)
            return
        }

        IntroduceTargetChooser.showChooser(
            editor,
            expressions,
            object : Pass<PsiElement>() {
                override fun pass(e: PsiElement) {
                    expandExpression(e, editor)
                }
            },
            getElementRenderer(),
            CodeInsightBundle.message("dialog.title.expressions"),
            0,
            ScopeHighlighter.NATURAL_RANGER
        )
    }

    override fun isApplicable(context: PsiElement, copyDocument: Document, newOffset: Int): Boolean {
        return getExpressions(context, copyDocument, newOffset).isNotEmpty()
    }

    private fun addTemplateVariables(element: PsiElement, template: Template) {
    }

    private fun getElementRenderer(): com.intellij.util.Function<PsiElement, String> {
        return com.intellij.util.Function { element: PsiElement -> element.text }
    }


    protected fun expandExpressionSlot(element: PsiElement, editor: Editor, slot: String) {
        ApplicationManager.getApplication().runWriteAction {
            CommandProcessor.getInstance().executeCommand(
                element.project,
                { expandAction(element, editor, slot) },
                CodeInsightBundle.message("command.expand.postfix.template"),
                PostfixLiveTemplate.POSTFIX_TEMPLATE_ID
            )
        }
    }

    private fun expandAction(element: PsiElement, editor: Editor, slot: String) {
        if (liveTemplate == null) {
            return
        }
        val project = element.project
        val document = editor.document
        val range = element.textRange
        document.deleteString(range.startOffset, range.endOffset)
        val manager = TemplateManager.getInstance(project)
        val template = liveTemplate.copy()
        template.addVariable(slot, TextExpression(element.text), false)
        addTemplateVariables(element, template)
        manager.startTemplate(editor, template)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PostfixTemplateSlotSelector) return false
        if (!super.equals(other)) return false
        return liveTemplate == other.liveTemplate
    }

    override fun hashCode(): Int {
        return Objects.hash(key, liveTemplate)
    }

    companion object {
        fun conditionTemplate(replace: PsiElement): String {
            return when (replace) {
                is ValkyrieIfStatement,
                is ValkyrieForStatement,
                is ValkyrieLoopStatement,
                -> {
                    "slot"
                }

                else -> {
                    "condition"
                }
            }
        }
    }
}
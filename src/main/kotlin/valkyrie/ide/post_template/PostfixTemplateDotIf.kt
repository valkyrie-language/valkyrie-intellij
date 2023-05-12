package valkyrie.ide.post_template

import com.intellij.codeInsight.template.impl.TemplateImpl
import com.intellij.codeInsight.template.postfix.templates.editable.EditablePostfixTemplateWithMultipleExpressions
import com.intellij.codeInsight.template.postfix.templates.editable.PostfixTemplateExpressionCondition
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.util.Function
import valkyrie.ide.live_template.ValkyrieLiveTemplate
import valkyrie.psi.ancestors
import valkyrie.psi.node.ValkyrieExpressionNode
import valkyrie.psi.node.ValkyrieFunctionCallNode

class PostfixTemplateDotIf : EditablePostfixTemplateWithMultipleExpressions<ExpressionCondition> {
    constructor() : super(
        "if",
        "if",
        ".if",
        ValkyrieLiveTemplate.getTemplate(".if")!!,
        "condition.if",
        mutableSetOf(ExpressionCondition()),
        true,
        PostfixTemplateFactory()
    )

    override fun getExpressions(context: PsiElement, document: Document, offset: Int): MutableList<PsiElement> {
//        if (context.elementType != ValkyrieTypes.DOT) {
//            return mutableListOf()
//        }
        println("getExpressions: $context")
        val expressions = mutableMapOf<TextRange, PsiElement>()
        for (ancestor in context.ancestors) {
            if (ancestor is ValkyrieExpressionNode) {
                expressions[ancestor.textRange] = ancestor
            } else if (ancestor is ValkyrieFunctionCallNode) {
                expressions[ancestor.textRange] = ancestor
            }
        }
        return expressions.values.toMutableList()
    }

    override fun getElementToRemove(element: PsiElement): PsiElement {
        println("getElementToRemove: $element")
        return super.getElementToRemove(element)
    }

    override fun getDescription(): String {
        return "super.getDescription()"
    }

    override fun getElementRenderer(): Function<PsiElement, String> {
        return super.getElementRenderer()
    }

    override fun getTopmostExpression(element: PsiElement): PsiElement {
        println("getTopmostExpression: $element")
        for (ancestor in element.ancestors) {
            if (ancestor is ValkyrieExpressionNode) {
                return ancestor
            }
        }
        return element
    }

    override fun getLiveTemplate(): TemplateImpl {
        return super.getLiveTemplate()
    }

    override fun getPresentableName(): String {
        return "super.getPresentableName()"
    }

    override fun getExample(): String {
        return "super.getExample()"
    }
}

class ExpressionCondition : PostfixTemplateExpressionCondition<PsiElement> {
    override fun value(t: PsiElement): Boolean {
        println("value: ${t}")
        return true
    }


    override fun getPresentableName(): String {
        return "getPresentableName"
    }

    override fun getId(): String {
        return "ExpressionCondition"
    }
}

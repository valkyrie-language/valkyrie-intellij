package valkyrie.ide.post_template

import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import valkyrie.ide.live_template.ValkyrieLiveTemplate
import valkyrie.psi.ancestors
import valkyrie.psi.node.ValkyrieExpressionNode
import valkyrie.psi.node.ValkyrieFunctionCallNode

class PostfixTemplateDotWhile : ValkyriePostfixTemplate {
    constructor() : super(
        "while",
        "while",
        ".while",
        ValkyrieLiveTemplate.getTemplate(".while")!!,
        "condition.while",
        PostfixTemplateFactory()
    )

    override fun getExpressions(context: PsiElement, document: Document, offset: Int): MutableList<PsiElement> {
        val expressions = mutableListOf<PsiElement>()
        for (ancestor in context.ancestors) {
            if (ancestor is ValkyrieExpressionNode) {
                expressions.add(ancestor)
            } else if (ancestor is ValkyrieFunctionCallNode) {
                expressions.add(ancestor)
            }

        }
        return expressions
    }


    override fun getDescription(): String {
        return "super.getDescription()"
    }

    override fun isApplicable(context: PsiElement, copyDocument: Document, newOffset: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun expand(context: PsiElement, editor: Editor) {
        TODO("Not yet implemented")
    }


}



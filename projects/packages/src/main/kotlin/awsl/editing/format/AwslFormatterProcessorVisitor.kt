package awsl.editing.format

import awsl.editing.format.codestyle.AwslCodeStyleSettings
import awsl.surface.psi.AwslHtmlStartCode
import awsl.surface.psi.AwslHtmlStartText
import awsl.surface.psi.AwslRecursiveVisitor
import com.intellij.json.JsonElementTypes
import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiWhiteSpace

class AwslFormatterProcessorVisitor constructor(
    private val myDocument: Document,
    private var settings: AwslCodeStyleSettings
) : AwslRecursiveVisitor() {
    private var myOffsetDelta = 0

    override fun visitHtmlStartText(node: awsl.surface.psi.nodes.AwslHtmlStartTextNode) {
        var a = node;

        settings.SPACE_BETWEEN_TEXT_TAG
        super.visitHtmlStartText(node)
    }


    override fun visitHtmlStartCode(node: awsl.surface.psi.nodes.AwslHtmlStartCodeNode) {
        var a = node;
        super.visitHtmlStartCode(node)
    }

    private fun deleteTrailingCommas(lastElementOrOpeningBrace: PsiElement?) {
        var element = lastElementOrOpeningBrace?.nextSibling
        while (element != null) {
            if (element.node.elementType === JsonElementTypes.COMMA ||
                element is PsiErrorElement && "," == element.getText()
            ) {
                deleteNode(element.node)
            } else if (!(element is PsiComment || element is PsiWhiteSpace)) {
                break
            }
            element = element.nextSibling
        }
    }

    private fun deleteNode(node: ASTNode) {
        val length = node.textLength
        myDocument.deleteString(node.startOffset + myOffsetDelta, node.startOffset + length + myOffsetDelta)
        myOffsetDelta -= length
    }
}
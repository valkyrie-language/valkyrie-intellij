package awsl.surface.psi

import awsl.surface.psi.nodes.*
import com.intellij.psi.PsiElementVisitor

/**
 * AWSL PSI 访问者基类
 */
open class AwslVisitor : PsiElementVisitor() {

    open fun visitBraceBlock(node: AwslBraceBlockNode) {
        visitPsiNode(node)
    }

    open fun visitDict(node: AwslDictNode) {
        visitPsiNode(node)
    }

    open fun visitElseStatement(node: AwslElseStatementNode) {
        visitPsiNode(node)
    }

    open fun visitForStatement(node: AwslForStatementNode) {
        visitPsiNode(node)
    }

    open fun visitGeneric(node: AwslGenericNode) {
        visitPsiNode(node)
    }

    open fun visitGenericItem(node: AwslGenericItemNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlCode(node: AwslHtmlCodeNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlEnd(node: AwslHtmlEndNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlEscape(node: AwslHtmlEscapeNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlKey(node: AwslHtmlKeyNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlKv(node: AwslHtmlKvNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlSelfClose(node: AwslHtmlSelfCloseNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlStartCode(node: AwslHtmlStartCodeNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlStartText(node: AwslHtmlStartTextNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlString(node: AwslHtmlStringNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlTag(node: AwslHtmlTagNode) {
        visitPsiNode(node)
    }

    open fun visitHtmlText(node: AwslHtmlTextNode) {
        visitPsiNode(node)
    }

    open fun visitIfStatement(node: AwslIfStatementNode) {
        visitPsiNode(node)
    }

    open fun visitKey(node: AwslKeyNode) {
        visitPsiNode(node)
    }

    open fun visitList(node: AwslListNode) {
        visitPsiNode(node)
    }

    open fun visitNumberLiteral(node: AwslNumberLiteralNode) {
        visitPsiNode(node)
    }

    open fun visitPair(node: AwslPairNode) {
        visitPsiNode(node)
    }

    open fun visitPattern(node: AwslPatternNode) {
        visitPsiNode(node)
    }

    open fun visitStringLiteral(node: AwslStringLiteralNode) {
        visitPsiNode(node)
    }

    open fun visitValue(node: AwslValueNode) {
        visitPsiNode(node)
    }

    open fun visitPsiNode(node: awsl.surface.psi.nodes.AwslPsiNode) {
        visitElement(node)
    }
}

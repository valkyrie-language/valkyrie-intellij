package awsl.editing.highlight

import awsl.surface.file.AwslFile
import awsl.editing.highlight.AwslHighlightColor.*
import awsl.surface.psi.AwslHtmlKey
import awsl.surface.psi.AwslHtmlKv
import awsl.surface.psi.AwslTypes
import awsl.surface.psi.AwslVisitor
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import com.intellij.util.containers.headTail

class AwslHighlightVisitor : awsl.surface.psi.AwslVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    private fun highlight(element: PsiElement, color: AwslHighlightColor) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun visitHtmlKey(node: awsl.surface.psi.nodes.AwslHtmlKeyNode) {
        val sym = node.symbols.headTail();
        val head = sym.first;
        val rest = sym.second;
        when (head.text) {
            "style", "on", "bind", "if", "class" -> {
                highlight(head, KEYWORD)
            }
            // attr = "?"
            else -> highlight(head, SYM_PROP)
        }
        rest.map {
            highlight(it, METADATA)
        }
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable,
    ): Boolean {
        infoHolder = holder
        action.run()

        return true
    }

    override fun clone(): HighlightVisitor = AwslHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is AwslFile

    override fun visit(element: PsiElement) = element.accept(this)
}

val awsl.surface.psi.nodes.AwslHtmlKeyNode.symbols: List<PsiElement>
    get() {
        val head = this.firstChild
        val symbols = mutableListOf(head)
        var e = head.nextSibling
        while (e != null) {
            when (e.elementType) {
                AwslTypes.SYMBOL -> symbols.add(e)
            }
            e = e.nextSibling
        }
        return symbols
    }

fun awsl.surface.psi.nodes.AwslHtmlKvNode.isStyleMode(): Boolean {
    // 查找 HTML_KEY 子元素
    var child = this.firstChild
    while (child != null) {
        if (child is awsl.surface.psi.nodes.AwslHtmlKeyNode) {
            return child.firstChild?.text == "style"
        }
        child = child.nextSibling
    }
    return false
}

fun awsl.surface.psi.nodes.AwslHtmlKvNode.isEventMode(): Boolean {
    // 查找 HTML_KEY 子元素
    var child = this.firstChild
    while (child != null) {
        if (child is awsl.surface.psi.nodes.AwslHtmlKeyNode) {
            return child.firstChild?.text == "on"
        }
        child = child.nextSibling
    }
    return false
}
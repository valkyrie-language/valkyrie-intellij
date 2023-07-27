package valkyrie.ide.hint

import com.intellij.codeInsight.hints.declarative.InlayTreeSink
import com.intellij.codeInsight.hints.declarative.SharedBypassCollector
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.node.ValkyrieDotCall

private class InlayMethodCollector(val file: ValkyrieFileNode, val editor: Editor) : SharedBypassCollector {
    override fun collectFromElement(element: PsiElement, sink: InlayTreeSink) {
        element.accept(ValkyrieCollectorVisitor(sink, editor))
    }
}

private class ValkyrieCollectorVisitor(sink: InlayTreeSink, editor: Editor) : InlayHintVisitor(sink, editor) {
    override fun visitDotCall(o: ValkyrieDotCall) {
        o.hintEndOfLine("⟶Iterator<Item=Any>", "tooltip2")
    }
}

package valkyrie.ide.hint

import com.intellij.codeInsight.hints.declarative.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.refactoring.suggested.endOffset
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.node.ValkyrieDotCall
import valkyrie.psi.node.ValkyrieVisitor

class ValkyrieInlayMethodChain : InlayHintsProvider {
    override fun createCollector(file: PsiFile, editor: Editor): InlayHintsCollector {
        return InlayMethodCollector(file as ValkyrieFileNode, editor)
    }
}

private class InlayMethodCollector(val file: ValkyrieFileNode, val editor: Editor) : SharedBypassCollector {
    override fun collectFromElement(element: PsiElement, sink: InlayTreeSink) {
        element.accept(ValkyrieCollectorVisitor(sink, editor))
    }
}

private class ValkyrieCollectorVisitor(val sink: InlayTreeSink, val editor: Editor) : ValkyrieVisitor() {
    override fun visitDotCall(o: ValkyrieDotCall) {
        // TODO: check if this is the last element of the line
        sink.addPresentation(
            eol(o.endOffset),
            null,
            "tooltip2",
            false
        ) {
            this.list {
                text("⟶")
                text("Iterator<Item=Any>")
            }
        }
    }

    private fun eol(offset: Int): EndOfLinePosition {
        return EndOfLinePosition(editor.document.getLineNumber(offset))
    }
}

package valkyrie.ide.hint.lambda

import com.intellij.codeInsight.hints.declarative.InlayHintsCollector
import com.intellij.codeInsight.hints.declarative.InlayHintsProvider
import com.intellij.codeInsight.hints.declarative.InlayTreeSink
import com.intellij.codeInsight.hints.declarative.SharedBypassCollector
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.ide.hint.InlayHintVisitor
import valkyrie.psi.node.ValkyrieLambdaBlock
import valkyrie.psi.node.ValkyrieLambdaStatement
import valkyrie.psi.node.ValkyrieNewLambda

class LambdaHintProvider : InlayHintsProvider {
    override fun createCollector(file: PsiFile, editor: Editor): InlayHintsCollector {
        return LambdaHintCollector(editor)
    }
}

private class LambdaHintCollector(val editor: Editor) : SharedBypassCollector {
    override fun collectFromElement(element: PsiElement, sink: InlayTreeSink) {
        element.accept(LambdaHintVisitor(sink, editor))
    }

    override fun collectFromElementForActions(element: PsiElement, sink: InlayTreeSink) {
        super.collectFromElementForActions(element, sink)
    }
}

private class LambdaHintVisitor(sink: InlayTreeSink, editor: Editor) : InlayHintVisitor(sink, editor) {
    override fun visitNewLambda(o: ValkyrieNewLambda) {
        super.visitNewLambda(o)
    }
}


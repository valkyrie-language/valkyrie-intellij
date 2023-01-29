package valkyrie.ide.highlight


//import valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.antlr.traversal
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.psi.ValkyrieHighlightElement

class NodeHighlighter : HighlightVisitor {
    private var _info: HighlightInfoHolder? = null
    override fun suitableForFile(file: PsiFile): Boolean {
        return file is ValkyrieFileNode
    }

    override fun visit(element: PsiElement) {
        element.traversal {
            if (it is ValkyrieHighlightElement) {
                _info?.let { info -> it.on_highlight(info) }
            }
            ProgressManager.checkCanceled()
            true
        }
    }

    override fun analyze(file: PsiFile, updateWholeFile: Boolean, holder: HighlightInfoHolder, action: Runnable): Boolean {
        _info = holder
        action.run()
        return true
    }

    override fun clone(): HighlightVisitor = NodeHighlighter()
}



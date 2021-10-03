package valkyrie.ide.runner

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import valkyrie.language.psi.ValkyrieTypes
import valkyrie.language.psi_node.ValkyrieClassMethodNode
import valkyrie.language.psi_node.ValkyrieDefineStatementNode

class ValkyrieRunner : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        if (element.elementType == ValkyrieTypes.KW_NAMESPACE) {
            return Info(
                AllIcons.RunConfigurations.TestState.Run,
                { "Run Test" },
                RunFile(),
                RunNamespace(),
            )
        }
        if (element.elementType == ValkyrieTypes.KW_CLASS) {
            return Info(RunClass())
        }
        // FIXME: performance warning
        if (element is ValkyrieDefineStatementNode) {
            return Info(
                AllIcons.RunConfigurations.TestState.Run,
                { "Run Test" },
                RunFunction(),
            )
        }
        // FIXME: performance warning
        if (element is ValkyrieClassMethodNode) {
            return Info(
                AllIcons.RunConfigurations.TestState.Run,
                { "Run Test" },
                RunFunction(),
            )
        }
        return null
    }


    override fun producesAllPossibleConfigurations(file: PsiFile): Boolean {
        return super.producesAllPossibleConfigurations(file)
    }
}


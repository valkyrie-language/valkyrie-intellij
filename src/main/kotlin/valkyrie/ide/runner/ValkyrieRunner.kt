package valkyrie.ide.runner

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.psi_node.ValkyrieDefineStatementNode

class ValkyrieRunner : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        if (element is ValkyrieDefineStatementNode) {
            return Info(
                AllIcons.RunConfigurations.TestState.Run,
                { "Run Test" },
                RunFunction(),
            )
        }
        if (element is ValkyrieClassStatementNode) {
            return Info(
                AllIcons.RunConfigurations.TestState.Run,
                { "Run Test" },
                RunClass(),
            )
        }
        return null
    }
}


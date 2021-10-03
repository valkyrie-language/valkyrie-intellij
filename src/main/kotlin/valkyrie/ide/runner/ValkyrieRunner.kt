package valkyrie.ide.runner

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import valkyrie.language.psi.ValkyrieTypes
import valkyrie.language.psi_node.ValkyrieClassMethodNode
import valkyrie.language.psi_node.ValkyrieDefineStatementNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode

class ValkyrieRunner : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        // simple resolve
        if (element.elementType == ValkyrieTypes.KW_NAMESPACE) {
            return Info(RunNamespaceGroup(element.parent))
        }
        if (element.elementType == ValkyrieTypes.KW_CLASS) {
            return Info(RunClassGroup(AllIcons.RunConfigurations.TestState.Run_run))
        }
        // complex resolve
        val id = element.parent;
        if (id !is ValkyrieIdentifierNode) {
            return null
        }
        if (id.parent.parent is ValkyrieDefineStatementNode) {
            // TODO: check main function
            return Info(
                AllIcons.RunConfigurations.TestState.Run,
                { "Run Test" },
                RunFunction(),
            )
        }
        if (id.parent is ValkyrieClassMethodNode) {
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


package valkyrie.ide.runner

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType

//import valkyrie.language.psi.ValkyrieTypes
//import valkyrie.language.psi_node.ValkyrieClassMethodNode
//import valkyrie.language.psi_node.ValkyrieDefineStatementNode
//import valkyrie.language.psi_node.ValkyrieIdentifierNode

class ValkyrieRunner : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        val node = element.parent;
        return when (element.elementType) {
//            ValkyrieTypes.KW_NAMESPACE -> Info(RunNamespaceGroup(element.parent))
//            ValkyrieTypes.KW_CLASS -> RunClassGroup.markClass(node)
//            ValkyrieTypes.KW_EXTENDS -> RunClassGroup.markExtends(node)
            else -> null
        }
    }

    override fun getSlowInfo(element: PsiElement): Info? {
        var node = element.parent;
//        if (node !is ValkyrieIdentifierNode) {
//            return null
//        }
//        node = node.parent;
//        when (node) {
//            is ValkyrieClassMethodNode -> {
//                return RunFunction.markTest(node)
//            }
//
//            else -> {}
//        }
//        node = node.parent;
//        when (node) {
//            is ValkyrieDefineStatementNode -> {
//                return RunFunction.markTest(node)
//            }
//
//            else -> {}
//        }
        return null
    }

    override fun producesAllPossibleConfigurations(file: PsiFile): Boolean {
        return super.producesAllPossibleConfigurations(file)
    }
}


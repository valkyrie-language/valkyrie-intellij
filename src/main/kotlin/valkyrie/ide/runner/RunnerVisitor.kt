package valkyrie.ide.runner

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import valkyrie.psi.node.*

class RunnerVisitor : ValkyrieVisitor() {
    var task: RunLineMarkerContributor.Info? = null

    override fun visitDeclareNamespace(o: ValkyrieDeclareNamespace) {
        task = RunLineMarkerContributor.Info(RunNamespaceGroup(o as ValkyrieDeclareNamespaceNode))
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        task = RunLineMarkerContributor.Info(RunClass(listOf("element"), false))
    }

    override fun visitDeclareImply(o: ValkyrieDeclareImply) {
        task = RunLineMarkerContributor.Info(RunClassGroup())
    }

}

private fun ValkyrieAnnotations.hasRunner(): Boolean {
    for (node in attributeList) {
        node as ValkyrieAttributeNode
        return when (node.name) {
            "test" -> true
            "bench" -> true
            else -> continue
        }
    }

    for (node in modifierList) {
        node as ValkyrieModifierNode
        return when (node.name) {
            "test" -> true
            "bench" -> true
            else -> continue
        }
    }
    return false
}
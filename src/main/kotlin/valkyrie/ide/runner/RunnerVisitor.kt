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

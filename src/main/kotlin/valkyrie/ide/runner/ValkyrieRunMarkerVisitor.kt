package valkyrie.ide.runner

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.execution.lineMarker.RunLineMarkerProvider
import com.intellij.openapi.actionSystem.AnAction
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.node.ValkyrieClassNode
import valkyrie.ast.node.ValkyrieDeclareImplyNode
import valkyrie.ast.node.ValkyrieKeywordNode
import valkyrie.ast.node.ValkyrieNamespaceNode

class ValkyrieRunMarkerVisitor : ValkyrieVisitor {
    private val config: ValkyrieRunMarkerProvider
    private val result: MutableCollection<in LineMarkerInfo<*>>

    constructor(config: ValkyrieRunMarkerProvider, result: MutableCollection<in LineMarkerInfo<*>>) : super() {
        this.config = config
        this.result = result
    }

    override fun visitDeclareNamespace(o: ValkyrieNamespaceNode) {
        RunNamespaceGroup(o).registerRunner(o.keyword)
    }

    override fun visitDeclareClass(o: ValkyrieClassNode) {
        RunClass(listOf("element"), true).registerRunner(o.keyword)
    }

    override fun visitDeclareImply(o: ValkyrieDeclareImplyNode) {
        RunClassGroup().registerRunner(o.keyword)
    }

    private fun AnAction.registerRunner(leaf: ValkyrieKeywordNode) {
        val info = RunLineMarkerContributor.Info(this)
        val marker = RunLineMarkerProvider.createLineMarker(leaf.firstChild, info.icon, mutableListOf(info))
        result.add(marker)
    }
}

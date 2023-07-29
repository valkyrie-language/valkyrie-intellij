package valkyrie.ide.runner

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.execution.lineMarker.RunLineMarkerProvider
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.psi.PsiElement
import valkyrie.psi.mixin.keyword
import valkyrie.psi.node.*

class ValkyrieRunMarkerVisitor : ValkyrieVisitor {
    private val config: ValkyrieRunMarkerProvider
    private val result: MutableCollection<in LineMarkerInfo<*>>

    constructor(config: ValkyrieRunMarkerProvider, result: MutableCollection<in LineMarkerInfo<*>>) : super() {
        this.config = config
        this.result = result
    }

    override fun visitDeclareNamespace(o: ValkyrieDeclareNamespace) {
        RunNamespaceGroup(o as ValkyrieDeclareNamespaceNode).registerRunner(o.firstChild.firstChild)
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        RunClass(listOf("element"), true).registerRunner(o.keyword)
    }

    override fun visitDeclareImply(o: ValkyrieDeclareImply) {
        RunClassGroup().registerRunner(o.keyword)
    }

    private fun AnAction.registerRunner(leaf: PsiElement) {
        val info = RunLineMarkerContributor.Info(this)
        val marker = RunLineMarkerProvider.createLineMarker(leaf, info.icon, mutableListOf(info))
        result.add(marker)
    }
}

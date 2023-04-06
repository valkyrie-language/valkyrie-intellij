package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.psi.PsiElement
import yggdrasil.psi.node.ValkyrieDeclareClassNode
import yggdrasil.psi.node.ValkyrieDeclareInterfaceNode
import yggdrasil.psi.node.ValkyrieDeclareUnionNode

class ValkyrieLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        return null
    }

    override fun collectSlowLineMarkers(elements: MutableList<out PsiElement>, result: MutableCollection<in LineMarkerInfo<*>>) {
        for (element in elements) {
            when (element) {
                is ValkyrieDeclareClassNode -> {
                    element.addLineMarkerInfo(result)
                }

                is ValkyrieDeclareUnionNode -> {
                    element.addLineMarkerInfo(result)
                }

                is ValkyrieDeclareInterfaceNode -> {
                    element.addLineMarkerInfo(result)
                }

            }
        }
    }

    private fun ValkyrieDeclareClassNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        AncestorClassMark.ancestor(this)?.let { result.add(it) }
        AncestorClassMark.ancestor(this)?.let { result.add(it) }
        AncestorClassMark.descendant(this)?.let { result.add(it) }
        AncestorClassMark.descendant(this)?.let { result.add(it) }
        AncestorClassMark.descendant(this)?.let { result.add(it) }
    }

    private fun ValkyrieDeclareUnionNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {

    }

    private fun ValkyrieDeclareInterfaceNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {

    }
}


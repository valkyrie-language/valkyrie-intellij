package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment
import com.intellij.psi.PsiElement
import valkyrie.psi.node.*
import java.util.function.Supplier

class ValkyrieMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        return null
    }

    override fun collectSlowLineMarkers(elements: MutableList<out PsiElement>, result: MutableCollection<in LineMarkerInfo<*>>) {
        for (element in elements) {
            when (element) {
                is ValkyrieDeclareClassNode -> element.addLineMarkerInfo(result)
                is ValkyrieDeclareUnionNode -> element.addLineMarkerInfo(result)
                is ValkyrieDeclareTraitNode -> element.addLineMarkerInfo(result)
                is ValkyrieTraitAliasNode -> element.addLineMarkerInfo(result)
                is ValkyrieDeclareEnumerateNode -> element.addLineMarkerInfo(result)
                is ValkyrieDeclareFlagsNode -> element.addLineMarkerInfo(result)
                is ValkyrieNewObjectNode -> element.addLineMarkerInfo(result)
                is ValkyrieDeclareUniteNode -> element.addLineMarkerInfo(result)
                is ValkyrieNewValueNode -> element.addLineMarkerInfo(result)
            }
        }
    }

    private fun ValkyrieDeclareClassNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        if (this.superClasses.isEmpty()) {
            ValkyrieMarkClass.standalone(this)?.let { result.add(it) }
        } else {
            ValkyrieMarkClass.ancestor(this)?.let { result.add(it) }
            ValkyrieMarkClass.ancestor(this)?.let { result.add(it) }
            ValkyrieMarkClass.descendant(this)?.let { result.add(it) }
            ValkyrieMarkClass.descendant(this)?.let { result.add(it) }
            ValkyrieMarkClass.descendant(this)?.let { result.add(it) }
        }


    }



    private fun ValkyrieDeclareTraitNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        if (kotlin.random.Random.nextBoolean()) {
            ValkyrieMarkInterface.standalone(this)?.let { result.add(it) }
        } else {
            ValkyrieMarkInterface.ancestor(this, this)?.let { result.add(it) }
            ValkyrieMarkInterface.ancestor(this, this)?.let { result.add(it) }
            ValkyrieMarkInterface.descendant(this, this)?.let { result.add(it) }
            ValkyrieMarkInterface.descendant(this, this)?.let { result.add(it) }
            ValkyrieMarkInterface.descendant(this, this)?.let { result.add(it) }
        }
    }

    private fun ValkyrieTraitAliasNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        ValkyrieMarkInterface.standalone(this)?.let { result.add(it) }
    }

    private fun ValkyrieDeclareUnionNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        result.add(object : LineMarkerInfo<ValkyrieDeclareUnionNode>(
            this,
            this.textRange,
            this.getIcon(0),
            { "tooltipProvider" },
            null,
            Alignment.CENTER,
            Supplier<String> { "AncestorClassMark" }) {
        })
    }

    private fun ValkyrieDeclareUniteNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        result.add(object : LineMarkerInfo<ValkyrieDeclareUniteNode>(
            this,
            this.textRange,
            this.getIcon(0),
            { "tooltipProvider" },
            null,
            Alignment.CENTER,
            Supplier<String> { "AncestorClassMark" }) {
        })
    }

    private fun ValkyrieDeclareEnumerateNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        result.add(object : LineMarkerInfo<ValkyrieDeclareEnumerateNode>(
            this,
            this.textRange,
            this.getIcon(0),
            { "tooltipProvider" },
            null,
            Alignment.CENTER,
            Supplier<String> { "AncestorClassMark" }) {
        })
    }

    private fun ValkyrieDeclareFlagsNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        result.add(object : LineMarkerInfo<ValkyrieDeclareFlagsNode>(
            this,
            this.textRange,
            this.getIcon(0),
            { "tooltipProvider" },
            null,
            Alignment.CENTER,
            Supplier<String> { "AncestorClassMark" }) {
        })
    }

    private fun ValkyrieNewObjectNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        result.add(object : LineMarkerInfo<ValkyrieNewObjectNode>(
            this,
            this.textRange,
            this.getIcon(0),
            { "tooltipProvider" },
            null,
            Alignment.CENTER,
            Supplier<String> { "AncestorClassMark" }) {
        })
    }

    private fun ValkyrieNewValueNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        result.add(object : LineMarkerInfo<ValkyrieNewValueNode>(
            this,
            this.textRange,
            this.getIcon(0),
            { "tooltipProvider" },
            null,
            Alignment.CENTER,
            Supplier<String> { "AncestorClassMark" }) {
        })
    }

    private fun ValkyrieDeclareFieldNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        result.add(object : LineMarkerInfo<ValkyrieDeclareFieldNode>(
            this,
            this.textRange,
            this.getIcon(0),
            { "tooltipProvider" },
            null,
            Alignment.CENTER,
            Supplier<String> { "AncestorClassMark" }) {
        })
    }

    private fun ValkyrieDeclareMethodNode.addLineMarkerInfo(result: MutableCollection<in LineMarkerInfo<*>>) {
        result.add(object : LineMarkerInfo<ValkyrieDeclareMethodNode>(
            this,
            this.textRange,
            this.getIcon(0),
            { "tooltipProvider" },
            null,
            Alignment.CENTER,
            Supplier<String> { "AncestorClassMark" }) {
        })
    }
}


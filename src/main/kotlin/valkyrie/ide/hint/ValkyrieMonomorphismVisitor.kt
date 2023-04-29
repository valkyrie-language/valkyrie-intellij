package valkyrie.ide.hint

import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry
import com.intellij.icons.AllIcons
import valkyrie.language.ValkyrieBundle
import valkyrie.psi.node.ValkyrieDeclareClass
import valkyrie.psi.node.ValkyrieDeclareMethod
import valkyrie.psi.node.ValkyrieDeclareTrait
import valkyrie.psi.node.ValkyrieVisitor

class ValkyrieMonomorphismVisitor : ValkyrieVisitor {
    private val id: String
    var vision: TextCodeVisionEntry? = null

    constructor(id: String) : super() {
        this.id = id
    }


    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        if (o.declareGeneric != null) {
            vision = TextCodeVisionEntry(
                ValkyrieBundle.message(id, '?'),
                id,
                AllIcons.Nodes.CopyOfFolder,
                "VisionMonomorphism",
                "tooltip",
                listOf()
            )
        }


    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        if (o.declareGeneric != null) {
            vision = TextCodeVisionEntry(
                ValkyrieBundle.message(id, '?'),
                id,
                AllIcons.Nodes.CopyOfFolder,
                "VisionMonomorphism",
                "tooltip",
                listOf()
            )
        }
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        if (o.declareGeneric != null) {
            vision = TextCodeVisionEntry(
                ValkyrieBundle.message(id, '?'),
                id,
                AllIcons.Nodes.CopyOfFolder,
                "VisionMonomorphism",
                "tooltip",
                listOf()
            )
        }
    }
}
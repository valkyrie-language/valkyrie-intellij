package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.impl.source.tree.SharedImplUtil
import valkyrie.ide.highlight.HighlightColor
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.reference.declaration.ValkyrieReference
import valkyrie.language.file.YggdrasilFileNode
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieDeclareClass
import yggdrasil.psi.node.ValkyrieDeclareVariants
import yggdrasil.psi.node.ValkyrieIdentifier
import yggdrasil.psi.node.ValkyrieIdentifierNode

abstract class MixinIdentifier(node: ASTNode) : ValkyrieElement(node),

    ValkyrieIdentifier {

    override fun getContainingFile(): YggdrasilFileNode {
        return SharedImplUtil.getContainingFile(node) as YggdrasilFileNode
    }

    override fun getName(): String? {
        return this.text.trim('`')
    }


    override fun getReference(): ValkyrieReference? {
        if (this.parent is ValkyrieDeclareClass) {
            return null
        }
        if (this.parent is ValkyrieDeclareVariants) {
            return null
        }
        return ValkyrieReference(this as ValkyrieIdentifierNode)
    }


    override fun highlight(highlighter: NodeHighlighter) {
        return when (this.text) {
            "HIDE", "ANY", "INDENT", "DEDENT" -> highlighter.highlight(this, HighlightColor.SYM_MACRO)
            "SOI", "START_OF_INPUT",
            "EOI", "END_OF_INPUT",
            "EOF", "END_OF_FILE",
            "EOL", "END_OF_LINE",
            "ROL", "REST_OF_LINE",
            -> highlighter.highlight(this, HighlightColor.SYM_CONSTANT)

            else -> {
                if (this.reference != null) {
                    this.reference!!.highlight(highlighter)
                } else {

                }


            }
        }
    }


}
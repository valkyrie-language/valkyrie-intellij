package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.HighlightColor
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieIdentifierNode
import yggdrasil.psi.node.ValkyrieTypeExpression
import yggdrasil.psi.node.ValkyrieTypeHint
import javax.swing.Icon

abstract class MixinTypeHint(node: ASTNode) : ValkyrieElement(node), ValkyrieTypeHint {
    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Type
    }
}

abstract class MixinTypeExpression(node: ASTNode) : ValkyrieElement(node), ValkyrieTypeExpression {
    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Type
    }

    override fun highlight_trait(visitor: NodeHighlighter) {
        for (typeTerm in this.typeTermList) {
            visitor.highlight(typeTerm.typeAtomic.namepath?.lastChild, HighlightColor.SYM_TRAIT)
        }
    }

    override fun highlight_class(visitor: NodeHighlighter) {
        for (typeTerm in this.typeTermList) {
            val id = typeTerm.typeAtomic.namepath?.lastChild as ValkyrieIdentifierNode;
            if (id.name == id.name.uppercase()) {
                visitor.highlight(id, HighlightColor.SYM_MACRO)
            } else {
                visitor.highlight(id, HighlightColor.SYM_CLASS)
            }


        }
    }
}
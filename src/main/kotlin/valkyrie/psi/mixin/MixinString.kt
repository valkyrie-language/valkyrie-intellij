package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieString

abstract class MixinString(node: ASTNode) : ValkyrieElement(node),
    ValkyrieString {


//    override fun getPresentation(): ItemPresentation? {
//        return PresentationData("YggdrasilClass", "YggdrasilClass", AllIcons.Nodes.Class, null)
//    }

}


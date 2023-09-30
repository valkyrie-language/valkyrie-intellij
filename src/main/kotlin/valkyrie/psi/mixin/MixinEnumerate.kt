package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.ValkyrieTypes.KW_ENUMERATE
import valkyrie.psi.ValkyrieTypes.KW_SINGLETON
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareEnums

import javax.swing.Icon

abstract class MixinEnumerate(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareEnums {
    override fun getKeyword(): PsiElement {
        return findKeyword(KW_ENUMERATE)
    }

    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Enumeration
    }
}

//
//fun ValkyrieDeclareEnumerate.items(): List<ValkyrieDeclareEnumerate.Item> {
//    sequence {
//        for (child in childrenWithLeaves) {
//            if (child.elementType == ValkyrieTypes.ENUMERATE_ITEM) {
//                yield(child as ValkyrieDeclareEnumerate.Item)
//            }
//        }
//    }
//}
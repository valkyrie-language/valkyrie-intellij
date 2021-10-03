package valkyrie.language.ast


import valkyrie.ide.file.ValkyrieIconProvider
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.mixin.MixinNamepath
import valkyrie.language.psi.*
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.openapi.fileEditor.PsiElementNavigatable
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil

class ASTMethods {
    companion object {
        @JvmStatic
        fun addChildrenView(node: ValkyrieModified?, list: MutableList<ValkyrieViewElement>) {
            if (node == null) return
            node.modifiers?.identifierList?.forEach {
                list.add(ValkyrieViewElement(it as ValkyrieIdentifierNode, it.name, ValkyrieIconProvider.MODIFIER))
            }
        }
        @JvmStatic
        fun addChildrenView(node: ValkyrieClassTuple?, list: MutableList<ValkyrieViewElement>) {
            if (node == null) return
            PsiTreeUtil
                .getChildrenOfTypeAsList(node, NavigatablePsiElement::class.java)
                .forEach {
                    list.add(ValkyrieViewElement(it))
                }
        }
        @JvmStatic
        fun addChildrenView(node: ValkyrieClassBlock?, list: MutableList<ValkyrieViewElement>) {
            if (node == null) return
            PsiTreeUtil
                .getChildrenOfTypeAsList(node, NavigatablePsiElement::class.java)
                .forEach {
                    list.add(ValkyrieViewElement(it))
                }
        }

        @JvmStatic
        fun getIdentifier(node: ValkyrieTraitStatement): ValkyrieIdentifierNode {
            return node.modified.lastChild as ValkyrieIdentifierNode
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieTraitStatement): Array<ValkyrieIdentifierNode> {
            return node.modified.modifiers.getModifiers()
        }

        @JvmStatic
        fun getIdentifier(node: ValkyrieClassStatement): ValkyrieIdentifierNode {
            return node.modified.lastChild as ValkyrieIdentifierNode
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieClassStatement): Array<ValkyrieIdentifierNode> {
            return node.modified.modifiers.getModifiers()
        }

        @JvmStatic
        fun getIdentifier(node: ValkyrieClassDefine): ValkyrieIdentifierNode {
            return node.modified.lastChild as ValkyrieIdentifierNode
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieClassDefine): Array<ValkyrieIdentifierNode> {
            return node.modified.modifiers.getModifiers()
        }
    }
}

private fun ValkyrieModifiers?.getModifiers(): Array<ValkyrieIdentifierNode> {
    this ?: return arrayOf();
    return this.identifierList.map { it as ValkyrieIdentifierNode }.toTypedArray()
}

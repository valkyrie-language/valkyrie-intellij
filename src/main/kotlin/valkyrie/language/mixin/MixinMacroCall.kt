package valkyrie.language.mixin

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.util.elementType
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieTypes
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.psi_node.ValkyrieMacroCallNode

open class MixinMacroCall(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getOriginalElement(): ValkyrieMacroCallNode {
        return this as ValkyrieMacroCallNode
    }

    override fun getNavigationElement(): ValkyrieIdentifierNode {
        return originalElement.namepathFree.identifierList.last() as ValkyrieIdentifierNode
    }

    override fun getName(): String {
        return navigationElement.name
    }

    fun isAnnotation(): Boolean {
        val block = originalElement.macroBlock ?: return true
        return block.firstChild.elementType == ValkyrieTypes.PARENTHESIS_L
    }

    override fun getPresentation(): ItemPresentation? {
        if (isAnnotation()) return null
        return PresentationData(this.name, "", ValkyrieIconProvider.MACRO, null)
    }

}




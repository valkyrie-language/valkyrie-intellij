package valkyrie.ide.reference.declaration

import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareClassNode
import valkyrie.psi.node.ValkyrieDeclareTraitNode
import valkyrie.psi.node.ValkyrieTraitAliasNode

/// 带类型的声明右边的东西
/// a: T
/// def a(): T
class ValkyrieTypeDeclarationProvider : TypeDeclarationProvider {
    override fun getSymbolTypeDeclarations(element: PsiElement): Array<PsiElement>? {
        return when (element) {
            is ValkyrieDeclareClassNode -> element.nameIdentifier?.let { arrayOf(it) }
            is ValkyrieDeclareTraitNode -> element.nameIdentifier?.let { arrayOf(it) }
            is ValkyrieTraitAliasNode -> element.nameIdentifier?.let { arrayOf(it) }
            else -> null
        }
    }

    private fun findDeclarations(element: ValkyrieDeclareClassNode): Array<PsiElement> {
        return arrayOf(element)
    }

    override fun getActionText(context: DataContext): String {
        return "ValkyrieTypeDeclarationProvider.GetActionText"
    }
}
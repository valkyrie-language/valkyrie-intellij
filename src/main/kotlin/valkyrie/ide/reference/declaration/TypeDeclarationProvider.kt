package valkyrie.ide.reference.declaration

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ValkyrieClassDeclaration

/// 带类型的声明右边的东西
/// a: T
/// def a(): T
class TypeDeclarationProvider : TypeDeclarationProvider {
    override fun getSymbolTypeDeclarations(element: PsiElement): Array<PsiElement>? {
        return when (element) {
//            is ValkyrieTypeStatementNode -> arrayOf(element.nameIdentifier)
            is ValkyrieClassDeclaration -> findDeclarations(element)
            else -> null
        }
    }
    private fun findDeclarations(element: ValkyrieClassDeclaration): Array<PsiElement> {
        return arrayOf()
    }
}



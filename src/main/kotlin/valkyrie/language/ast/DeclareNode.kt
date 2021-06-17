package valkyrie.language.ast


import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import javax.swing.Icon

/// 一定是可以 view 的节点
/// PsiSymbolDeclarationProvider,
abstract class DeclareNode(node: ASTNode) : ValkyrieASTBase(node),
    PsiNameIdentifierOwner {
    abstract override fun getOriginalElement(): ValkyrieASTBase
    abstract override fun getNameIdentifier(): ValkyrieASTBase
    abstract override fun getIcon(flags: Int): Icon
    override fun getElementIcon(flags: Int): Icon = this.getIcon(flags)
    override fun getName(): String = this.nameIdentifier.name ?: "[UNKNOWN]"
    override fun getNavigationElement(): PsiElement = this.nameIdentifier
    override fun getTextOffset(): Int = this.nameIdentifier.textOffset
    override fun getPresentation(): ItemPresentation {
        return PresentationData(this.name, "", this.getIcon(0), null)
    }
}


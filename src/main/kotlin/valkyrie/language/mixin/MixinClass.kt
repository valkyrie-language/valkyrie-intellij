package valkyrie.language.mixin

import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.DeclareNode
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi_node.ValkyrieClassDefineNode
import valkyrie.language.psi_node.ValkyrieClassItemNode
import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.symbol.ValkyrieSymbol
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

// PsiReference
@Suppress("UnstableApiUsage")
open class MixinClass(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieClassStatementNode {
        return this as ValkyrieClassStatementNode
    }
    override fun getNameIdentifier() = originalElement.identifier
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Class
    override fun setName(name: String): PsiElement {
        return this.nameIdentifier
    }

    override fun getResolveScope(): GlobalSearchScope {
        return super.getResolveScope()
    }

    override fun getUseScope(): SearchScope {
        return super.getUseScope()
    }

    override fun resolveNamespace(name: List<String>): ValkyrieASTBase? {
        if (name.isEmpty()) return this
        return PsiTreeUtil
            .getChildrenOfAnyType(
                this,
                ValkyrieClassItemNode::class.java,
                ValkyrieClassDefineNode::class.java,
            )
            .filter { it.name == name.first() }
            .firstNotNullOfOrNull { it.resolveNamespace(name.drop(1)) }
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val childrenView: MutableList<ValkyrieViewElement> = mutableListOf()
        originalElement.addAnnotationView(childrenView)
        originalElement.modified.addChildrenView(childrenView)
        originalElement.classTuple?.addChildrenView(childrenView)
        originalElement.classBlock?.addChildrenView(childrenView)
        return childrenView.toTypedArray()
    }

    override fun getOwnDeclarations(): MutableCollection<out ValkyrieSymbol> {
        return super<DeclareNode>.getOwnDeclarations()
    }
}


package valkyrie.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.DeclareNode
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.psi.ValkyrieContext
import valkyrie.language.psi_node.ValkyrieClassFieldNode
import valkyrie.language.psi_node.ValkyrieClassMethodNode
import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.symbol.ValkyrieClassDeclare
import valkyrie.language.symbol.WorkspaceManager
import javax.swing.Icon

// PsiReference
@Suppress("UnstableApiUsage", "PropertyName")
open class MixinClass(node: ASTNode) : DeclareNode(node), ValkyrieContext {
    override fun getOriginalElement(): ValkyrieClassStatementNode {
        return this as ValkyrieClassStatementNode
    }

    override fun getNameIdentifier() = originalElement.modified.lastChild as ValkyrieIdentifierNode
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
                ValkyrieClassFieldNode::class.java,
                ValkyrieClassMethodNode::class.java,
            )
            .filter { it.name == name.first() }
            .firstNotNullOfOrNull { it.resolveNamespace(name.drop(1)) }
    }

    val class_fields: List<ValkyrieClassFieldNode>
        get() {
            if (originalElement.classBlock == null) return listOf()
            return PsiTreeUtil.getChildrenOfTypeAsList(originalElement.classBlock!!, ValkyrieClassFieldNode::class.java)
        }

    override fun getOwnDeclarations(): MutableCollection<out PsiSymbolDeclaration> {
        val file = this.containingFile as ValkyrieFileNode;
        WorkspaceManager.defineClass(originalElement, file.packageName, file.namespace)
        return mutableListOf()
    }
}


package valkyrie.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.DeclareNode
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi_node.ValkyrieClassFieldNode
import valkyrie.language.psi_node.ValkyrieClassMethodNode
import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.symbol.ValkyrieSymbol
import javax.swing.Icon

// PsiReference
@Suppress("UnstableApiUsage")
open class MixinClass(node: ASTNode) : DeclareNode(node) {
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

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val childrenView: MutableList<ValkyrieViewElement> = mutableListOf()
        originalElement.addAnnotationView(childrenView)
        originalElement.modified.addChildrenView(childrenView)
        originalElement.classBlock?.addChildrenView(childrenView)
        return childrenView.toTypedArray()
    }

    override fun getOwnDeclarations(): MutableCollection<out ValkyrieSymbol> {
        return super<DeclareNode>.getOwnDeclarations()
    }

    fun collectSymbols(): MutableMap<String, ValkyrieHighlightColor> {
        val symbols = mutableMapOf<String, ValkyrieHighlightColor>()
        collectGenerics().forEach { symbols[it.text] = ValkyrieHighlightColor.SYM_GENERIC }
        collectFields().forEach { symbols[it] = ValkyrieHighlightColor.SYM_FIELD }
        collectMethods().forEach { symbols[it] = ValkyrieHighlightColor.SYM_FUNCTION_FREE }
        return symbols
    }
    fun collectFields(): List<String> {
        val fields = mutableListOf<String>()
        originalElement.classBlock?.let {

        }
        return fields
    }
    fun collectMethods(): List<String> {
        val methods = mutableListOf<String>()
        originalElement.classBlock?.let {

        }
        return methods
    }

    fun collectGenerics(): List<ValkyrieIdentifierNode> {
        val generic = mutableListOf<ValkyrieIdentifierNode>()
        originalElement.genericDefine?.let {

        }
        return generic
    }


}


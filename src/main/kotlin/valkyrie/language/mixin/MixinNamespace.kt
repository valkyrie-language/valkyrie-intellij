@file:Suppress("UnstableApiUsage")

package valkyrie.language.mixin

import valkyrie.ide.file.ValkyrieIconProvider
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.ViewableNode
import valkyrie.language.ast.addChildrenView
import valkyrie.language.psi_node.ValkyrieImportStatementNode
import valkyrie.language.psi_node.ValkyrieNamespaceStatementNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

open class MixinNamespace(node: ASTNode) : ViewableNode(node), PsiNameIdentifierOwner {
    override fun getOriginalElement(): ValkyrieNamespaceStatementNode {
        return this as ValkyrieNamespaceStatementNode
    }

    override fun getName(): String {
        return originalElement.namepathFree.lastChild.text
    }

    val namespace: Array<String>
        get() {
            return originalElement.namepathFree.identifierList.map { it.text }.toTypedArray()
        }


    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement? {
        return when (originalElement.isDeclaration()) {
            true -> originalElement.namepathFree.lastChild
            else -> null
        }
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.NAMESPACE
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: originalElement.namepathFree.lastChild
    }


    override fun getTextOffset(): Int {
        return navigationElement.textOffset
    }

    override fun getPresentation(): PresentationData {
        val namepath = originalElement.namepathFree as MixinNamepath;
        return PresentationData(namepath.name, "", this.getIcon(0), null)
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val views: MutableList<ValkyrieViewElement> = mutableListOf()
        for (item in PsiTreeUtil.getChildrenOfTypeAsList(containingFile, ValkyrieImportStatementNode::class.java)) {
            item.addChildrenView(views)
        }
        return views.toTypedArray()
    }

    fun isDeclaration(): Boolean {
        return this.firstChild.text.endsWith("!")
    }
}


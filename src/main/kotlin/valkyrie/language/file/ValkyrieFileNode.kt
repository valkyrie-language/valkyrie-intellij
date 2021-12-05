package valkyrie.language.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.psi_node.ValkyrieDefineStatementNode
import valkyrie.language.psi_node.ValkyrieTraitStatementNode

/**
ValkyrieFile 是个 PsiElement
 */
@Suppress("UnstableApiUsage")
class ValkyrieFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage) {
    override fun getFileType(): FileType = ValkyrieFileType
    override fun toString(): String = ValkyrieBundle.message("action.create_file")
    fun getChildrenView(): Array<TreeElement> {
        return PsiTreeUtil
            .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
            .filter { it.presentation != null }
            .map { ValkyrieViewElement(it) }
            .toTypedArray()
    }

    val definitions: MutableMap<String, ValkyrieASTBase>
        get() {
            val map = mutableMapOf<String, ValkyrieASTBase>()
            for (child in this.children) {
                when (child) {
                    is ValkyrieClassStatementNode -> map[child.name] = child
                    is ValkyrieTraitStatementNode -> map[child.name] = child
                    is ValkyrieDefineStatementNode -> map[child.name] = child
                }
            }
            return map
        }

    override fun getOwnDeclarations(): MutableCollection<out PsiSymbolDeclaration> {
        return super.getOwnDeclarations()
    }

    override fun getOwnReferences(): MutableCollection<out PsiSymbolReference> {
        return super.getOwnReferences()
    }

    override fun getResolveScope(): GlobalSearchScope {
        return super.getResolveScope()
    }

    override fun getUseScope(): SearchScope {
        return super.getUseScope()
    }

    fun isIndexFile(): Boolean {
        return this.name == "index.vk"
    }
}


package valkyrie.language.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.ast.ValkyrieClassDeclaration
import valkyrie.language.ast.ValkyrieTraitDeclaration
import valkyrie.language.psi_node.ValkyrieNamespaceStatementNode


/**
ValkyrieFile 是个 PsiElement
 */
@Suppress("UnstableApiUsage")
class ValkyrieFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage) {
    override fun getFileType(): FileType = ValkyrieFileType


    override fun toString(): String = ValkyrieBundle.message("action.create_file")


    val packageName: String
        get() {
            for (child in this.children) {
                if (child is ValkyrieNamespaceStatementNode) {
                    return child.name
                }
            }
            return ""
        }

    val namespace: String
        get() {
            for (child in this.children) {
                if (child is ValkyrieNamespaceStatementNode) {
                    return ""
                }
            }
            return ""
        }

    override fun getOwnDeclarations(): MutableCollection<out PsiSymbolDeclaration> {
//        val output = mutableListOf<PsiSymbolDeclaration>()
//        for (child in this.children) {
//            output.addAll(child.ownDeclarations)
//        }
//        return output
        return mutableListOf()
    }

    override fun getOwnReferences(): MutableCollection<out PsiSymbolReference> {
//        val output = mutableListOf<PsiSymbolReference>()
//        for (child in this.children) {
//            output.addAll(child.ownReferences)
//        }
//        return output
        return mutableListOf()
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


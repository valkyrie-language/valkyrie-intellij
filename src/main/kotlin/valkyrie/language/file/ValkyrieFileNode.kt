package valkyrie.language.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.ide.project.crate.NamespaceMapping
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.traversal
import valkyrie.language.ast.ValkyrieNamespaceNode
import valkyrie.language.ast.classes.ValkyrieClassStatement


/**
ValkyrieFile 是个 PsiElement
 */
@Suppress("UnstableApiUsage")
class ValkyrieFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage), ScopeNode {
    override fun getFileType(): FileType = ValkyrieFileType


    override fun toString(): String = ValkyrieBundle.message("action.create_file")


    val packageName: String
        get() {
            for (child in this.children) {
                if (child is ValkyrieNamespaceNode) {
                    return child.name ?: ""
                }
            }
            return ""
        }
    val namespace: ValkyrieNamespaceNode?
        get() {
            for (child in this.children) {
                if (child is ValkyrieNamespaceNode) {
                    return child
                }
            }
            return null
        }

    val namepath: String = namespace?.name ?: ""

    fun updateCache() {
        this.traversal {
            if (it is ValkyrieClassStatement) {
                NamespaceMapping.Instance.ClassCache.getOrPut(it.name) { mutableSetOf() }.add(namepath)
                false
            } else {
                true
            }
        }
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

    override fun getContext(): ScopeNode? {
        return null
    }

    override fun getResolveScope(): GlobalSearchScope {
        return super.getResolveScope()
    }

    override fun getUseScope(): SearchScope {
        return super.getUseScope()
    }

    override fun resolve(p0: PsiNamedElement?): PsiElement? {
        return null
    }

    fun isIndexFile(): Boolean {
        return this.name == "index.vk" || this.name == "_.vk"
    }
}


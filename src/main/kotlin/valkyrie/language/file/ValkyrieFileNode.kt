package valkyrie.language.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareNamespaceNode
import javax.swing.Icon


/**
ValkyrieFile 是个 PsiElement
 */
class ValkyrieFileNode : PsiFileBase {
    var namespace: ValkyrieDeclareNamespaceNode? = null
    val definitions: MutableList<ValkyrieDeclaration> = mutableListOf()

    constructor(viewProvider: FileViewProvider) : super(viewProvider, ValkyrieLanguage) {

    }


    override fun getName(): String {
        return super.getName()
    }

    override fun getFileType(): FileType = ValkyrieFileType


    override fun getResolveScope(): GlobalSearchScope {
        return super.getResolveScope()
    }

    override fun getUseScope(): SearchScope {
        return super.getUseScope()
    }

    fun isIndexFile(): Boolean {
        val index = setOf("_.vk", "_.valkyrie", "index.vk", "index.valkyrie")
        return index.contains(this.name)
    }

    override fun getBaseIcon(): Icon? {
        return super.getBaseIcon()
    }

    override fun getPresentation(): ItemPresentation {
        val file = viewProvider.virtualFile.parent
        val location = if (file != null && file.isValid && file.isDirectory) {
            file.presentableUrl
        } else {
            null
        }
        return PresentationData(name, location, this.baseIcon, null)
    }

    override fun subtreeChanged() {
        definitions.clear()
        for (child in this.children) {
            if (child is ValkyrieDeclareNamespaceNode) {
                namespace = child
                definitions.add(child)
            } else if (child is ValkyrieDeclaration) {
                definitions.add(child)
            }
        }
    }

    override fun toString(): String = "ValkyrieFileNode"


}


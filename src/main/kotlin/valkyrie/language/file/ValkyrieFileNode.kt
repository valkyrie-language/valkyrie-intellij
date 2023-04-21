package valkyrie.language.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import valkyrie.language.ValkyrieLanguage
import javax.swing.Icon


/**
ValkyrieFile 是个 PsiElement
 */
class ValkyrieFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage) {
    val definitions = YggdrasilFileCache(this)
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
        return this.name == "index.ygg"
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

    override fun toString(): String = "ValkyrieFileNode"
}


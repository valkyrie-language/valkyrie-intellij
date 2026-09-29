package vos.intellij.language.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import vos.intellij.ide.view.ViewElement
import vos.intellij.language.VosLanguage
import vos.intellij.language.ast.DeclareNode
import vos.intellij.language.psi.searchChildrenOfType

class VosFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, VosLanguage) {
    override fun getFileType(): FileType = VosFileType

    override fun toString(): String = MessageBundle.message("filetype.description")
    
    fun getChildrenView(): Array<ViewElement> {
        return this.searchChildrenOfType(DeclareNode::class.java)
            .map { ViewElement(it) }
            .toTypedArray()
    }
}



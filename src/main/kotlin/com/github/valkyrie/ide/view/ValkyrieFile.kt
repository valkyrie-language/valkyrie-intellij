package com.github.valkyrie.ide.view

import com.github.valkyrie.ValkyrieBundle
import com.github.valkyrie.ValkyrieLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class ValkyrieFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage.INSTANCE) {
    override fun getFileType(): FileType = VkFileType.INSTANCE

    override fun toString(): String = ValkyrieBundle.message("action.create_file")
}
package com.github.valkyrie.ide.view

import com.github.valkyrie.VkBundle
import com.github.valkyrie.VkLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class VkFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, VkLanguage.INSTANCE) {
    override fun getFileType(): FileType = VkFileType.INSTANCE

    override fun toString(): String = VkBundle.message("action.create_file")
}
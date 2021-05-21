package com.github.valkyrie.ide.project

import com.github.valkyrie.ide.file.ValkyrieFileNode
import com.github.valkyrie.language.psi_node.ValkyrieNamespaceStatementNode
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentIterator
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.util.CachedValue

// TODO: cache
class ProjectStorage(val project: Project?) : ContentIterator {
    var fileTree: MutableMap<String, MutableList<ValkyrieFileNode>> = mutableMapOf()
    override fun processFile(fileInProject: VirtualFile): Boolean {
        project ?: return false
        val file = PsiManager.getInstance(project).findFile(fileInProject) as? ValkyrieFileNode
        analyzeFile(file)
        return true
    }

    private fun analyzeFile(file: ValkyrieFileNode?) {
        file ?: return
        for (item in file.children) {
            if (item is ValkyrieNamespaceStatementNode) {
                item.getNamespace()
            }
        }
    }
}

package com.github.valkyrie.ide.view


import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.DumbAware


class ValkyrieStructureProvider : TreeStructureProvider, DumbAware {
    override fun modify(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<AbstractTreeNode<*>>,
        settings: ViewSettings?,
    ): List<AbstractTreeNode<out Any>> = children.map { child ->
         if (child is PsiFileNode && child.value is ValkyrieFile) {
             FileNode(child, settings)
         } else {
             child
         }
     }
    private class FileNode(
        original: PsiFileNode,
        viewSettings: ViewSettings?
    ) : PsiFileNode(original.project, original.value, viewSettings) {
        override fun getSortKey(): Int = when {
//            value.name == RsConstants.MOD_RS_FILE -> -2
//            (value as? RsFile)?.isCrateRoot == true -> -1
            else -> 0
        }
    }
}


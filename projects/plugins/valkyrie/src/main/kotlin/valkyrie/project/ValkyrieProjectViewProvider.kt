package valkyrie.project

import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiDirectoryNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import valkyrie.index.ValkyrieProjectService
import valkyrie.project.workspace.ValkyrieWorkspaceNode

/**
 * Valkyrie 项目视图提供器
 * 自定义项目树结构显示
 */
class ValkyrieProjectViewProvider : TreeStructureProvider {
    
    override fun modify(
        parent: AbstractTreeNode<*>,
        children: Collection<AbstractTreeNode<*>>,
        settings: ViewSettings?
    ): Collection<AbstractTreeNode<*>> {
        
        val project = parent.project ?: return children
        val projectManager = ValkyrieProjectService.getInstance(project).getProjectManager()
        
        return children.map { child ->
            when (child) {
                is PsiDirectoryNode -> {
                    val directory = child.value?.virtualFile
                    if (directory != null) {
                        when {
                            projectManager.isValkyrieWorkspace(directory) -> {
                                ValkyrieWorkspaceNode(project, child.value!!, settings)
                            }
                            projectManager.isValkyrieProject(directory) -> {
                                ValkyrieProjectNode(project, child.value!!, settings)
                            }
                            else -> child
                        }
                    } else child
                }
                else -> child
            }
        }
    }
}


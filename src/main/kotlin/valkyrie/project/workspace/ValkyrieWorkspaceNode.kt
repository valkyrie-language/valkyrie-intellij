package valkyrie.project.workspace

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiDirectoryNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import valkyrie.index.ValkyrieProjectService
import valkyrie.language.ValkyrieIcons

/**
 * Valkyrie Workspace 节点
 */
class ValkyrieWorkspaceNode(
    project: Project,
    value: PsiDirectory,
    viewSettings: ViewSettings?
) : PsiDirectoryNode(project, value, viewSettings) {

    override fun getChildrenImpl(): Collection<AbstractTreeNode<*>> {
        // 不再添加自定义的 Packages 节点，外部包现在显示在 External Libraries 中
        return super.getChildrenImpl() ?: emptyList()
    }

    override fun updateImpl(data: PresentationData) {
        super.updateImpl(data)
        data.setIcon(ValkyrieIcons.WORKSPACE)

        val currentProject = project
        if (currentProject != null) {
            try {
                val projectManager = ValkyrieProjectService.Companion.getInstance(currentProject).getProjectManager()
                val workspace = projectManager.getWorkspace(value.virtualFile)
                if (workspace != null) {
                    data.presentableText = "${workspace.name} (Workspace)"
                }
            } catch (e: Exception) {
                // 如果服务获取失败，使用默认显示
                data.presentableText = "Workspace"
            }
        }
    }
}
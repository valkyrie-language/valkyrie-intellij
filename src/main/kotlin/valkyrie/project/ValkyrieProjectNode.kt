package valkyrie.project

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiDirectoryNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import valkyrie.index.ValkyrieProjectService
import valkyrie.language.ValkyrieIcons

/**
 * Valkyrie Project 节点
 */
class ValkyrieProjectNode(
    project: Project,
    value: PsiDirectory,
    viewSettings: ViewSettings?
) : PsiDirectoryNode(project, value, viewSettings) {

    override fun getChildrenImpl(): Collection<AbstractTreeNode<*>> {
        val children = super.getChildrenImpl()?.toMutableList() ?: mutableListOf()
        val projectManager = ValkyrieProjectService.Companion.getInstance(project!!).getProjectManager()

        val valkyrieProject = projectManager.getProject(value.virtualFile)
        if (valkyrieProject != null) {
            // 重新组织子节点，优先显示重要目录
            val organizedChildren = organizeProjectChildren(children, valkyrieProject)
            return organizedChildren
        }

        return children
    }

    private fun organizeProjectChildren(
        children: MutableList<AbstractTreeNode<*>>,
        valkyrieProject: ValkyrieProject
    ): Collection<AbstractTreeNode<*>> {
        val organized = mutableListOf<AbstractTreeNode<*>>()
        val remaining = children.toMutableList()

        // 优先显示 library 目录
        val libraryNode = remaining.find { node ->
            (node as? PsiDirectoryNode)?.value?.name == ValkyrieProjectParser.LIBRARY_DIR
        }
        if (libraryNode != null) {
            organized.add(libraryNode)
            remaining.remove(libraryNode)
        }

        // 然后显示 binary 目录
        val binaryNode = remaining.find { node ->
            (node as? PsiDirectoryNode)?.value?.name == ValkyrieProjectParser.BINARY_DIR
        }
        if (binaryNode != null) {
            organized.add(binaryNode)
            remaining.remove(binaryNode)
        }

        // 然后显示 tests 目录
        val testsNode = remaining.find { node ->
            (node as? PsiDirectoryNode)?.value?.name == ValkyrieProjectParser.TESTS_DIR
        }
        if (testsNode != null) {
            organized.add(testsNode)
            remaining.remove(testsNode)
        }

        // 添加剩余的节点
        organized.addAll(remaining)

        return organized
    }

    override fun updateImpl(data: PresentationData) {
        super.updateImpl(data)
        data.setIcon(ValkyrieIcons.PROJECT)

        val currentProject = project
        if (currentProject != null) {
            try {
                val projectManager = ValkyrieProjectService.Companion.getInstance(currentProject).getProjectManager()
                val valkyrieProject = projectManager.getProject(value.virtualFile)
                if (valkyrieProject != null) {
                    val projectType = when {
                        valkyrieProject.isLibrary() && valkyrieProject.isApplication() -> "Lib+App"
                        valkyrieProject.isLibrary() -> "Library"
                        valkyrieProject.isApplication() -> "Application"
                        else -> "Project"
                    }
                    data.presentableText = "${valkyrieProject.packageInfo.name} ($projectType)"
                }
            } catch (e: Exception) {
                // 如果服务获取失败，使用默认显示
                data.presentableText = "Project"
            }
        }
    }
}
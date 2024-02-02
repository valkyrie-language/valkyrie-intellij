package valkyrie.project

import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiDirectoryNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiManager
import valkyrie.index.ValkyrieProjectService
import valkyrie.language.ValkyrieIcons
import javax.swing.Icon

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
    
    override fun updateImpl(data: com.intellij.ide.projectView.PresentationData) {
        super.updateImpl(data)
        data.setIcon(ValkyrieIcons.WORKSPACE)
        
        val currentProject = project
        if (currentProject != null) {
            try {
                val projectManager = ValkyrieProjectService.getInstance(currentProject).getProjectManager()
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
        val projectManager = ValkyrieProjectService.getInstance(project!!).getProjectManager()
        
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
    
    override fun updateImpl(data: com.intellij.ide.projectView.PresentationData) {
        super.updateImpl(data)
        data.setIcon(ValkyrieIcons.PROJECT)
        
        val currentProject = project
        if (currentProject != null) {
            try {
                val projectManager = ValkyrieProjectService.getInstance(currentProject).getProjectManager()
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

// ValkyriePackagesNode 已移除，外部包现在通过 AdditionalLibraryRootsProvider 显示在 External Libraries 中

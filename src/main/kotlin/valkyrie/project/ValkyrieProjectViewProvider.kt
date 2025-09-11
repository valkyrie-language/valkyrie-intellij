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
        val children = super.getChildrenImpl()?.toMutableList() ?: mutableListOf()
        val projectManager = ValkyrieProjectService.getInstance(project!!).getProjectManager()
        
        val workspace = projectManager.getWorkspace(value.virtualFile)
        if (workspace != null) {
            // 添加特殊的包节点
            val packagesNode = ValkyriePackagesNode(project!!, workspace, settings)
            children.add(0, packagesNode)
        }
        
        return children
    }
    
    override fun updateImpl(data: com.intellij.ide.projectView.PresentationData) {
        super.updateImpl(data)
        data.setIcon(ValkyrieIcons.WORKSPACE)
        
        val projectManager = ValkyrieProjectService.getInstance(project!!).getProjectManager()
        val workspace = projectManager.getWorkspace(value.virtualFile)
        if (workspace != null) {
            data.presentableText = "${workspace.name} (Workspace)"
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
        
        val projectManager = ValkyrieProjectService.getInstance(project!!).getProjectManager()
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
    }
}

/**
 * Valkyrie Packages 节点
 */
class ValkyriePackagesNode(
    private val project: Project,
    private val workspace: ValkyrieWorkspace,
    private val viewSettings: ViewSettings?
) : AbstractTreeNode<ValkyrieWorkspace>(project, workspace) {
    
    override fun getChildren(): Collection<AbstractTreeNode<*>> {
        val psiManager = PsiManager.getInstance(project)
        
        return workspace.packages.mapNotNull { packageDir ->
            val psiDir = psiManager.findDirectory(packageDir)
            if (psiDir != null) {
                ValkyrieProjectNode(project, psiDir, viewSettings)
            } else null
        }
    }
    
    override fun update(data: com.intellij.ide.projectView.PresentationData) {
        data.presentableText = "Packages (${workspace.packages.size})"
        data.setIcon(ValkyrieIcons.PACKAGES)
    }
}

/**
 * Valkyrie 图标定义
 */
object ValkyrieIcons {
    val WORKSPACE: Icon = IconLoader.getIcon("/icons/workspace.svg", ValkyrieIcons::class.java)
    val PROJECT: Icon = IconLoader.getIcon("/icons/project.svg", ValkyrieIcons::class.java)
    val PACKAGES: Icon = IconLoader.getIcon("/icons/packages.svg", ValkyrieIcons::class.java)
}
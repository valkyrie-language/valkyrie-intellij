package valkyrie.project.legion

import com.intellij.ide.highlighter.ModuleFileType
import com.intellij.openapi.module.ModifiableModuleModel
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.util.io.toNioPathOrNull
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.resolveFromRootOrRelative
import valkyrie.language.ValkyrieLanguage
import java.nio.file.Path

class LegionStructureAnalyzer(val project: Project) {
    fun markWorkspace(model: ModifiableModuleModel?) {
        val moduleModel = model ?: ModuleManager.getInstance(project).getModifiableModel()
        val root = moduleModel.newModule(getIML(project.name), ValkyrieLanguage.moduleID)
        val rootMut = ModuleRootManager.getInstance(root).modifiableModel
        val children = findProjects("packages", "projects");
        for (child in children) {
            val sub = moduleModel.newModule(getIML(child.name), ValkyrieLanguage.moduleID);
            rootMut.addModuleOrderEntry(sub)
        }
        if (model == null) {
            moduleModel.commit()
        }
    }

    private fun getIML(name: String): Path {
        val dotIdea = project.projectFile?.findChild(Project.DIRECTORY_STORE_FOLDER);
        val fileName = name + ModuleFileType.DOT_DEFAULT_EXTENSION;
        val dir = dotIdea?.toNioPath() ?: project.basePath?.toNioPathOrNull()
        return dir?.resolve(fileName)!!
    }


    private fun findProjects(vararg dirs: String): Array<VirtualFile> {
        val root = project.guessProjectDir();
        for (dir in dirs) {
            val file = root?.resolveFromRootOrRelative(dir)
            if (file != null && file.exists()) {
                return file.children
            }
        }
        return arrayOf()
    }
}
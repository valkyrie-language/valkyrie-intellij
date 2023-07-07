package valkyrie.project.modules

import com.intellij.openapi.module.ModifiableModuleModel
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.openapi.vfs.refreshAndFindVirtualFileOrDirectory
import com.intellij.openapi.vfs.toNioPathOrNull
import valkyrie.language.ValkyrieLanguage
import java.nio.file.Path
import kotlin.io.path.exists
import kotlin.io.path.listDirectoryEntries


class ValkyrieProjectActivityListener : ProjectActivity {
    override suspend fun execute(project: Project) {
        markModules(project)
    }

    private fun markModules(project: Project) {
        val root = project.guessProjectDir()?.toNioPathOrNull() ?: return
        val workspace = root.resolve("legion.toml")
        val manager = ModuleManager.getInstance(project);
        val model = manager.getModifiableModel();
        if (workspace.exists()) {
            for (entry in workspace.resolve("projects").listDirectoryEntries()) {
                markSingle(entry, model)
            }
        } else {
            markSingle(root, model)
        }
        model.commit()
    }

    private fun markSingle(dir: Path, model: ModifiableModuleModel) {
        val pkg = dir.resolve("package.toml")
        if (pkg.exists()) {
            val module = model.newModule(dir, ValkyrieLanguage.moduleID)
            markModuleRoots(dir, ModuleRootManager.getInstance(module))
        }
    }


    private fun markModuleRoots(path: Path, manager: ModuleRootManager) {
        val modifiableModel = manager.modifiableModel
        val src = path.resolve("src").refreshAndFindVirtualFileOrDirectory()
        if (src != null) {
            val contentEntry = modifiableModel.addContentEntry(src)
            contentEntry.addSourceFolder(src, false)
        }
        val tests = path.resolve("tests").refreshAndFindVirtualFileOrDirectory()
        if (tests != null) {
            val contentEntry = modifiableModel.addContentEntry(tests)
            contentEntry.addSourceFolder(tests, true)
        }
        modifiableModel.commit()
    }
}

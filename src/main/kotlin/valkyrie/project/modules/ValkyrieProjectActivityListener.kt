package valkyrie.project.modules

import com.intellij.openapi.module.ModifiableModuleModel
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.resolveFromRootOrRelative
import valkyrie.language.ValkyrieLanguage


class ValkyrieProjectActivityListener : ProjectActivity {
    override suspend fun execute(project: Project) {

    }
}


class MyToolWindowListener() {
    fun markModules(project: Project, model: ModifiableModuleModel) {
        val root = project.guessProjectDir() ?: return
        val ws = root.resolveFromRootOrRelative("legion.toml")
        val pkg = root.resolveFromRootOrRelative("package.toml")
        when {
            ws != null -> {
                markMono(root, model)
            }

            pkg != null -> {
                markSingle(root, model)
            }
        }
        model.modules.forEach { markModuleRoots(ModuleRootManager.getInstance(it)) }
    }


    private fun markMono(root: VirtualFile, model: ModifiableModuleModel) {
        val projects = root.resolveFromRootOrRelative("projects")?.children ?: arrayOf();
        for (entry in projects) {
            val pkg = entry.resolveFromRootOrRelative("package.toml");
            if (pkg != null) {
                println("markMono: ${pkg.path}")
                model.newModule(pkg.path, ValkyrieLanguage.moduleID)
            }
        }
        // TODO: mark root as group
        // model.loadModule(root.path)
    }

    private fun markSingle(root: VirtualFile, model: ModifiableModuleModel) {
        println("markSingle: $root")
        model.newModule(root.path, ValkyrieLanguage.moduleID)
    }

    private fun markModuleRoots(manager: ModuleRootManager) {
        val root = manager.module.moduleFile ?: return
        val modifiableModel = manager.modifiableModel
        markSources(root, modifiableModel, "library", "source", "src")
        markTests(root, modifiableModel, "test", "tests")
        markTests(root, modifiableModel, "benchmark", "benchmarks", "bench")
        markTests(root, modifiableModel, "example", "examples")
        markExclude(root, modifiableModel, "target", "build", "out", "dist")
        modifiableModel.commit()
    }

    private fun markSources(root: VirtualFile, model: ModifiableRootModel, vararg sources: String) {
        for (source in sources) {
            val src = root.resolveFromRootOrRelative(source)
            if (src != null) {
                val contentEntry = model.addContentEntry(src)
                contentEntry.addSourceFolder(src, false)
                break
            }
        }
    }

    private fun markTests(root: VirtualFile, model: ModifiableRootModel, vararg sources: String) {
        for (source in sources) {
            val src = root.resolveFromRootOrRelative(source)
            if (src != null) {
                val contentEntry = model.addContentEntry(src)
                contentEntry.addSourceFolder(src, true)
                break
            }
        }
    }

    private fun markExclude(root: VirtualFile, model: ModifiableRootModel, vararg sources: String) {
        for (source in sources) {
            val src = root.resolveFromRootOrRelative(source)
            if (src != null) {
                val contentEntry = model.addContentEntry(src)
                contentEntry.addExcludeFolder(src)
            }
        }
    }
}
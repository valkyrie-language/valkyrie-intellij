package valkyrie.project.modules

import com.intellij.ide.JavaUiBundle
import com.intellij.ide.util.projectWizard.importSources.JavaModuleSourceRoot
import com.intellij.ide.util.projectWizard.importSources.JavaSourceRootDetectionUtil
import com.intellij.openapi.module.ModuleConfigurationEditor
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.util.ProgressWindow
import com.intellij.openapi.progress.util.SmoothProgressAdapter
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ui.configuration.*
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.concurrency.SwingWorker
import org.jetbrains.jps.model.java.JavaResourceRootType
import org.jetbrains.jps.model.java.JavaSourceRootType
import java.io.File


class ValkyrieModuleConfiguration : ModuleConfigurationEditorProviderEx {
    override fun createEditors(state: ModuleConfigurationState?): Array<ModuleConfigurationEditor> {
        val module = state?.currentRootModel?.module ?: return arrayOf()
        return when {
            ModuleType.get(module) is ValkyrieModuleType -> {
                arrayOf(ValkyrieModuleDependenciesEditor(module.name, state))
            }

            else -> {
                arrayOf()
            }
        }
    }

    override fun isCompleteEditorSet(): Boolean {
        return false
    }
}

private class ValkyrieModuleDependenciesEditor(moduleName: String?, state: ModuleConfigurationState?) : CommonContentEntriesEditor(
    moduleName,
    state,
    JavaSourceRootType.SOURCE,
    JavaSourceRootType.TEST_SOURCE,
    JavaResourceRootType.RESOURCE,
    JavaResourceRootType.TEST_RESOURCE
) {
    override fun createContentEntryEditor(contentEntryUrl: String): ContentEntryEditor {
        return object : JavaContentEntryEditor(contentEntryUrl, editHandlers) {
            override fun getModel(): ModifiableRootModel {
                return modifiableModel
            }
        }
    }

    private val modifiableModel: ModifiableRootModel
        get() = model

    override fun addContentEntries(files: Array<VirtualFile>): List<ContentEntry> {
        val contentEntries = super.addContentEntries(files)
        if (!contentEntries.isEmpty()) {
            val contentEntriesArray = contentEntries.toTypedArray<ContentEntry>()
            addSourceRoots(myProject, contentEntriesArray) {
                addContentEntryPanels(
                    contentEntriesArray
                )
            }
        }
        return contentEntries
    }

    companion object {
        private fun addSourceRoots(project: Project, contentEntries: Array<ContentEntry>, finishRunnable: Runnable?) {
            val entryToRootMap = HashMap<ContentEntry?, Collection<JavaModuleSourceRoot>?>()
            val fileToEntryMap: MutableMap<File, ContentEntry> = HashMap()
            for (contentEntry in contentEntries) {
                val file = contentEntry.file
                if (file != null) {
                    entryToRootMap[contentEntry] = null
                    fileToEntryMap[VfsUtilCore.virtualToIoFile(file)] = contentEntry
                }
            }

            val progressWindow = ProgressWindow(true, project)
            val progressIndicator: ProgressIndicator = SmoothProgressAdapter(progressWindow, project)

            val searchRunnable = Runnable {
                val process = Runnable {
                    for (file in fileToEntryMap.keys) {
                        progressIndicator.text = JavaUiBundle.message("module.paths.searching.source.roots.progress", file.path)
                        val roots = JavaSourceRootDetectionUtil.suggestRoots(file)
                        entryToRootMap[fileToEntryMap[file]] = roots
                    }
                }
                progressWindow.title = JavaUiBundle.message("module.paths.searching.source.roots.title")
                ProgressManager.getInstance().runProcess(process, progressIndicator)
            }

            val addSourcesRunnable = Runnable {
                for (contentEntry in contentEntries) {
                    val suggestedRoots = entryToRootMap[contentEntry]
                    if (suggestedRoots != null) {
                        for (suggestedRoot in suggestedRoots) {
                            val sourceRoot =
                                LocalFileSystem.getInstance().findFileByIoFile(suggestedRoot.directory)
                            val fileContent = contentEntry.file
                            if (sourceRoot != null && fileContent != null && VfsUtilCore.isAncestor(
                                    fileContent,
                                    sourceRoot,
                                    false
                                )
                            ) {
                                contentEntry.addSourceFolder(sourceRoot, false, suggestedRoot.packagePrefix)
                            }
                        }
                    }
                }
                finishRunnable?.run()
            }

            object : SwingWorker<Any?>() {
                override fun construct(): Any? {
                    searchRunnable.run()
                    return null
                }

                override fun finished() {
                    addSourcesRunnable.run()
                }
            }.start()
        }
    }
}

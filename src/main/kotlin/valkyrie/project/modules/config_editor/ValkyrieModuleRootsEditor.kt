package valkyrie.project.modules.config_editor

import com.intellij.ide.JavaUiBundle
import com.intellij.ide.util.projectWizard.importSources.JavaModuleSourceRoot
import com.intellij.ide.util.projectWizard.importSources.JavaSourceRootDetectionUtil
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.util.ProgressWindow
import com.intellij.openapi.progress.util.SmoothProgressAdapter
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ui.configuration.CommonContentEntriesEditor
import com.intellij.openapi.roots.ui.configuration.ContentEntryEditor
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationState
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.concurrency.SwingWorker
import org.jetbrains.jps.model.java.JavaResourceRootType
import org.jetbrains.jps.model.java.JavaSourceRootType
import java.io.File

class ValkyrieModuleRootsEditor : CommonContentEntriesEditor {
    constructor(moduleName: String, state: ModuleConfigurationState) : super(
        moduleName,
        state,
        JavaSourceRootType.SOURCE,
        JavaSourceRootType.TEST_SOURCE,
        JavaResourceRootType.RESOURCE,
        JavaResourceRootType.TEST_RESOURCE,
    )

    override fun createContentEntryEditor(contentEntryUrl: String): ContentEntryEditor {
        return ValkyrieModuleRootsContentEntry(contentEntryUrl, editHandlers, model)
    }

    override fun addContentEntries(files: Array<VirtualFile>): List<ContentEntry> {
        val contentEntries = super.addContentEntries(files)
        if (contentEntries.isNotEmpty()) {
            val contentEntriesArray = contentEntries.toTypedArray<ContentEntry>()
            addSourceRoots(myProject, contentEntriesArray) {
                addContentEntryPanels(contentEntriesArray)
            }
        }
        return contentEntries
    }

}

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

    NullableAnySwingWorker(searchRunnable, addSourcesRunnable).start()
}

private class NullableAnySwingWorker : SwingWorker<Unit> {
    private val searchRunnable: Runnable
    private val addSourcesRunnable: Runnable

    constructor(searchRunnable: Runnable, addSourcesRunnable: Runnable) : super() {
        this.searchRunnable = searchRunnable
        this.addSourcesRunnable = addSourcesRunnable
    }

    override fun construct() {
        searchRunnable.run()
    }

    override fun finished() {
        addSourcesRunnable.run()
    }
}
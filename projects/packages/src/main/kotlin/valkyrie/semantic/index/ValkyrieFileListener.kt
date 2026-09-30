package valkyrie.semantic.index

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileEvent
import com.intellij.openapi.vfs.VirtualFileListener
import com.intellij.openapi.vfs.VirtualFileMoveEvent
import com.intellij.openapi.vfs.newvfs.events.VFileEvent
import valkyrie.surface.file.ValkyrieFileType
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Listens for Valkyrie / legion manifest changes and updates the symbol index.
 * Prefer incremental per-file reindex; full rebuild only for manifest changes.
 */
class ValkyrieFileListener(private val project: Project) : VirtualFileListener {

    private var symbolIndex: ValkyrieSymbolIndex? = null

    private val rebuildScheduled = AtomicBoolean(false)
    private val pendingFiles = ConcurrentHashMap.newKeySet<VirtualFile>()
    @Volatile
    private var pendingFullRebuild = false

    private val scheduler = Executors.newSingleThreadScheduledExecutor { r ->
        Thread(r, "ValkyrieIndexRebuild").apply {
            isDaemon = true
            priority = Thread.MIN_PRIORITY
        }
    }

    private fun getSymbolIndex(): ValkyrieSymbolIndex {
        if (symbolIndex == null) {
            symbolIndex = ValkyrieSymbolIndex.getInstance(project)
        }
        return symbolIndex!!
    }

    private fun scheduleWork() {
        if (project.isDisposed) return
        if (!rebuildScheduled.compareAndSet(false, true)) {
            return
        }
        scheduler.schedule({
            try {
                if (project.isDisposed) {
                    return@schedule
                }
                val fullRebuild = pendingFullRebuild
                pendingFullRebuild = false
                val files = pendingFiles.toList()
                pendingFiles.clear()

                ApplicationManager.getApplication().runReadAction {
                    if (project.isDisposed) {
                        return@runReadAction
                    }
                    val index = getSymbolIndex()
                    if (fullRebuild) {
                        index.rebuildIndex()
                    } else {
                        for (file in files) {
                            if (!file.isValid) {
                                index.removeFileFromIndex(file)
                            } else if (isValkyrieFile(file)) {
                                index.reindexFile(file)
                            }
                        }
                    }
                }
            } catch (_: Exception) {
                // Keep IDE stable if background indexing fails.
            } finally {
                rebuildScheduled.set(false)
                if ((pendingFullRebuild || pendingFiles.isNotEmpty()) && !project.isDisposed) {
                    scheduleWork()
                }
            }
        }, 500, TimeUnit.MILLISECONDS)
    }

    private fun scheduleFileReindex(file: VirtualFile) {
        pendingFiles.add(file)
        scheduleWork()
    }

    private fun scheduleFullRebuild() {
        pendingFullRebuild = true
        scheduleWork()
    }

    override fun contentsChanged(event: VirtualFileEvent) {
        when {
            isValkyrieFile(event.file) -> scheduleFileReindex(event.file)
            isConfigFile(event.file) -> scheduleFullRebuild()
        }
    }

    override fun fileCreated(event: VirtualFileEvent) {
        when {
            isValkyrieFile(event.file) -> scheduleFileReindex(event.file)
            isConfigFile(event.file) -> scheduleFullRebuild()
        }
    }

    override fun fileDeleted(event: VirtualFileEvent) {
        when {
            isValkyrieFile(event.file) -> scheduleFileReindex(event.file)
            isConfigFile(event.file) -> scheduleFullRebuild()
        }
    }

    override fun fileMoved(event: VirtualFileMoveEvent) {
        when {
            isValkyrieFile(event.file) -> scheduleFileReindex(event.file)
            isConfigFile(event.file) -> scheduleFullRebuild()
        }
    }

    fun handleEvents(events: List<VFileEvent>) {
        if (project.isDisposed) return

        var needFullRebuild = false
        for (event in events) {
            val file = event.file ?: continue
            when {
                isConfigFile(file) -> needFullRebuild = true
                isValkyrieFile(file) -> pendingFiles.add(file)
            }
        }

        if (needFullRebuild) {
            scheduleFullRebuild()
        } else if (pendingFiles.isNotEmpty()) {
            scheduleWork()
        }
    }

    private fun isValkyrieFile(file: VirtualFile): Boolean =
        file.fileType == ValkyrieFileType.INSTANCE

    private fun isConfigFile(file: VirtualFile): Boolean =
        file.name == "legion.json" ||
            file.name == "legions.json" ||
            file.name == "legion.von" ||
            file.name == "legions.von"

    fun dispose() {
        scheduler.shutdown()
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow()
            }
        } catch (_: InterruptedException) {
            scheduler.shutdownNow()
            Thread.currentThread().interrupt()
        }
    }
}

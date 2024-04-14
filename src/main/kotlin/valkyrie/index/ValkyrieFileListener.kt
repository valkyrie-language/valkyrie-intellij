package valkyrie.index

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileEvent
import com.intellij.openapi.vfs.VirtualFileListener
import com.intellij.openapi.vfs.VirtualFileMoveEvent
import com.intellij.openapi.vfs.newvfs.events.VFileEvent
import valkyrie.language.file.ValkyrieFileType
import com.intellij.openapi.application.ApplicationManager
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Valkyrie 文件监听器
 * 监听文件变化并更新符号索引
 */
class ValkyrieFileListener(private val project: Project) : VirtualFileListener {
    
    private var symbolIndex: ValkyrieSymbolIndex? = null
    
    // 优化防抖机制：增加延迟时间，减少频繁重建
    private val rebuildScheduled = AtomicBoolean(false)
    private val scheduler = Executors.newSingleThreadScheduledExecutor { r ->
        Thread(r, "ValkyrieIndexRebuild").apply { 
            isDaemon = true
            priority = Thread.MIN_PRIORITY // 降低线程优先级，避免阻塞UI
        }
    }
    
    // 增加文件变化计数器，批量处理
    private val pendingChanges = AtomicBoolean(false)
    
    private fun getSymbolIndex(): ValkyrieSymbolIndex {
        if (symbolIndex == null) {
            symbolIndex = ValkyrieSymbolIndex.getInstance(project)
        }
        return symbolIndex!!
    }
    
    /**
     * 延迟重建索引，避免频繁操作
     */
    private fun scheduleIndexRebuild() {
        if (project.isDisposed) return
        
        // 设置待处理标志
        pendingChanges.set(true)
        
        if (rebuildScheduled.compareAndSet(false, true)) {
            // 增加延迟时间到2秒，减少频繁重建
            scheduler.schedule({
                try {
                    if (pendingChanges.get() && !project.isDisposed) {
                        ApplicationManager.getApplication().runReadAction {
                            if (!project.isDisposed) {
                                getSymbolIndex().rebuildIndex()
                                pendingChanges.set(false)
                            }
                        }
                    }
                } catch (e: Exception) {
                    // 忽略索引重建错误，避免影响IDE稳定性
                } finally {
                    rebuildScheduled.set(false)
                }
            }, 2000, TimeUnit.MILLISECONDS) // 从500ms增加到2000ms
        }
    }

    override fun contentsChanged(event: VirtualFileEvent) {
        if (isValkyrieFile(event.file)) {
            // 文件内容变化时延迟重建索引，避免频繁操作
            scheduleIndexRebuild()
        }
    }

    override fun fileCreated(event: VirtualFileEvent) {
        if (isValkyrieFile(event.file)) {
            // 新建 Valkyrie 文件时延迟重建索引
            scheduleIndexRebuild()
        }
    }

    override fun fileDeleted(event: VirtualFileEvent) {
        if (isValkyrieFile(event.file)) {
            // 删除 Valkyrie 文件时延迟重建索引
            scheduleIndexRebuild()
        }
    }

    override fun fileMoved(event: VirtualFileMoveEvent) {
        if (isValkyrieFile(event.file)) {
            // 移动 Valkyrie 文件时延迟重建索引
            scheduleIndexRebuild()
        }
    }

    private fun isValkyrieFile(file: VirtualFile): Boolean {
        return file.fileType == ValkyrieFileType.INSTANCE
    }

    /**
     * 处理文件变化事件
     */
    fun handleEvents(events: List<VFileEvent>) {
        if (project.isDisposed) return
        
        var needRebuild = false
        var valkyrieFileCount = 0
        
        for (event in events) {
            val file = event.file
            if (file != null) {
                when {
                    isValkyrieFile(file) -> {
                        valkyrieFileCount++
                        needRebuild = true
                    }
                    isConfigFile(file) -> {
                        needRebuild = true
                    }
                }
            }
        }
        
        // 只有在有实际Valkyrie文件变化时才重建索引
        if (needRebuild && valkyrieFileCount > 0) {
            scheduleIndexRebuild()
        }
    }

    private fun isConfigFile(file: VirtualFile): Boolean {
        return file.name == "legion.json" || file.name == "legions.json"
    }
    
    /**
     * 清理资源
     */
    fun dispose() {
        scheduler.shutdown()
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow()
            }
        } catch (e: InterruptedException) {
            scheduler.shutdownNow()
            Thread.currentThread().interrupt()
        }
    }
}
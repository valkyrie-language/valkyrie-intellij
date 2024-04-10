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
    
    // 防抖机制：避免频繁重建索引
    private val rebuildScheduled = AtomicBoolean(false)
    private val scheduler = Executors.newSingleThreadScheduledExecutor { r ->
        Thread(r, "ValkyrieIndexRebuild").apply { isDaemon = true }
    }
    
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
        if (rebuildScheduled.compareAndSet(false, true)) {
            scheduler.schedule({
                try {
                    getSymbolIndex().rebuildIndex()
                } finally {
                    rebuildScheduled.set(false)
                }
            }, 1000, TimeUnit.MILLISECONDS) // 延迟1秒执行
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
        var needRebuild = false
        
        for (event in events) {
            val file = event.file
            if (file != null && (isValkyrieFile(file) || isConfigFile(file))) {
                needRebuild = true
                break
            }
        }
        
        if (needRebuild) {
            // 批量事件触发的重建使用延迟机制
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
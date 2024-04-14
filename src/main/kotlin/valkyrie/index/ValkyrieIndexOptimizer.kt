package valkyrie.index

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.Logger
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Valkyrie 索引优化器
 * 优化索引性能，减少启动时的索引负载
 */
@Service(Service.Level.PROJECT)
class ValkyrieIndexOptimizer(private val project: Project) {
    
    companion object {
        private val LOG = Logger.getInstance(ValkyrieIndexOptimizer::class.java)
        
        fun getInstance(project: Project): ValkyrieIndexOptimizer {
            return project.getService(ValkyrieIndexOptimizer::class.java)
        }
    }
    
    private val optimizationExecutor = Executors.newSingleThreadScheduledExecutor { r ->
        Thread(r, "ValkyrieIndexOptimizer").apply {
            isDaemon = true
            priority = Thread.MIN_PRIORITY
        }
    }
    
    /**
     * 延迟初始化索引，避免启动时阻塞
     */
    fun scheduleDelayedIndexing() {
        if (project.isDisposed) return
        
        optimizationExecutor.schedule({
            try {
                if (!project.isDisposed) {
                    ApplicationManager.getApplication().runReadAction {
                        if (!project.isDisposed) {
                            LOG.info("Starting delayed Valkyrie indexing for project: ${project.name}")
                            ValkyrieSymbolIndex.getInstance(project).rebuildIndex()
                        }
                    }
                }
            } catch (e: Exception) {
                LOG.warn("Failed to perform delayed indexing", e)
            }
        }, 5, TimeUnit.SECONDS) // 延迟5秒后开始索引
    }
    
    /**
     * 清理资源
     */
    fun dispose() {
        optimizationExecutor.shutdown()
        try {
            if (!optimizationExecutor.awaitTermination(3, TimeUnit.SECONDS)) {
                optimizationExecutor.shutdownNow()
            }
        } catch (e: InterruptedException) {
            optimizationExecutor.shutdownNow()
            Thread.currentThread().interrupt()
        }
    }
}

/**
 * 启动活动，延迟初始化Valkyrie索引
 */
class ValkyrieDelayedIndexingActivity : StartupActivity {
    override fun runActivity(project: Project) {
        // 延迟初始化索引，避免启动时阻塞
        ValkyrieIndexOptimizer.getInstance(project).scheduleDelayedIndexing()
    }
}
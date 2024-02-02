package valkyrie.index

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileEvent
import com.intellij.openapi.vfs.VirtualFileListener
import com.intellij.openapi.vfs.VirtualFileMoveEvent
import com.intellij.openapi.vfs.newvfs.events.VFileEvent
import valkyrie.language.file.ValkyrieFileType

/**
 * Valkyrie 文件监听器
 * 监听文件变化并更新符号索引
 */
class ValkyrieFileListener(private val project: Project) : VirtualFileListener {
    
    private var symbolIndex: ValkyrieSymbolIndex? = null
    
    private fun getSymbolIndex(): ValkyrieSymbolIndex {
        if (symbolIndex == null) {
            symbolIndex = ValkyrieSymbolIndex.getInstance(project)
        }
        return symbolIndex!!
    }
    
    override fun contentsChanged(event: VirtualFileEvent) {
        if (isValkyrieFile(event.file)) {
            // 文件内容变化时重建索引
            getSymbolIndex().rebuildIndex()
        }
    }
    
    override fun fileCreated(event: VirtualFileEvent) {
        if (isValkyrieFile(event.file)) {
            // 新建 Valkyrie 文件时重建索引
            getSymbolIndex().rebuildIndex()
        }
    }
    
    override fun fileDeleted(event: VirtualFileEvent) {
        if (isValkyrieFile(event.file)) {
            // 删除 Valkyrie 文件时重建索引
            getSymbolIndex().rebuildIndex()
        }
    }
    
    override fun fileMoved(event: VirtualFileMoveEvent) {
        if (isValkyrieFile(event.file)) {
            // 移动 Valkyrie 文件时重建索引
            getSymbolIndex().rebuildIndex()
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
            getSymbolIndex().rebuildIndex()
        }
    }
    
    private fun isConfigFile(file: VirtualFile): Boolean {
        return file.name == "legion.json" || file.name == "legions.json"
    }
}
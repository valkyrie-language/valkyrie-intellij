package valkyrie.ide.documentation

/**
 * 文档渲染模式
 */
enum class DocumentRenderMode {
    /**
     * 渲染模式 - 支持Markdown格式化
     */
    RENDERED,
    
    /**
     * 文本模式 - 显示原始文本
     */
    TEXT
}

/**
 * 文档渲染模式管理器
 */
object DocumentRenderModeManager {
    private var currentMode = DocumentRenderMode.RENDERED
    
    /**
     * 获取当前渲染模式
     */
    fun getCurrentMode(): DocumentRenderMode = currentMode
    
    /**
     * 切换渲染模式
     */
    fun toggleMode(): DocumentRenderMode {
        currentMode = when (currentMode) {
            DocumentRenderMode.RENDERED -> DocumentRenderMode.TEXT
            DocumentRenderMode.TEXT -> DocumentRenderMode.RENDERED
        }
        return currentMode
    }
    
    /**
     * 设置渲染模式
     */
    fun setMode(mode: DocumentRenderMode) {
        currentMode = mode
    }
}
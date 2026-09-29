package valkyrie.ide.documentation

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.Presentation
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * 切换文档渲染模式的Action
 */
class ToggleDocumentRenderModeAction : AnAction() {
    
    companion object {
        private val RENDER_ICON: Icon = IconLoader.getIcon("/icons/showCacheable.svg", ToggleDocumentRenderModeAction::class.java)
        private val TEXT_ICON: Icon = IconLoader.getIcon("/icons/untyped.svg", ToggleDocumentRenderModeAction::class.java)
    }
    
    override fun actionPerformed(e: AnActionEvent) {
        val newMode = DocumentRenderModeManager.toggleMode()
        
        // 刷新文档显示
        // 这里可以添加刷新逻辑，比如触发文档重新渲染
    }
    
    override fun update(e: AnActionEvent) {
        val presentation = e.presentation
        val currentMode = DocumentRenderModeManager.getCurrentMode()
        
        when (currentMode) {
            DocumentRenderMode.RENDERED -> {
                presentation.icon = RENDER_ICON
                presentation.text = "Switch to Text Mode"
                presentation.description = "Currently in rendered mode. Click to switch to text mode."
            }
            DocumentRenderMode.TEXT -> {
                presentation.icon = TEXT_ICON
                presentation.text = "Switch to Rendered Mode"
                presentation.description = "Currently in text mode. Click to switch to rendered mode."
            }
        }
        
        presentation.isEnabledAndVisible = true
    }
}
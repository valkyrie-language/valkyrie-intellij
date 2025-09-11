package valkyrie.highlighting

import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

/**
 * Valkyrie 语法高亮工厂
 */
class ValkyrieSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    
    fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
        return ValkyrieSyntaxHighlighter()
    }
}
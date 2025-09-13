package valkyrie.ide.completion

import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegate
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.actionSystem.EditorActionHandler
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiFile
import valkyrie.psi.nodes.ValkyrieFileNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Valkyrie 语言的 Enter 键处理器
 * 主要处理 {|} 格式化问题
 */
class ValkyrieEnterHandlerDelegate : EnterHandlerDelegate {
    
    override fun preprocessEnter(
        file: PsiFile,
        editor: Editor,
        caretOffset: Ref<Int>,
        caretAdvance: Ref<Int>,
        dataContext: DataContext,
        originalHandler: EditorActionHandler?
    ): EnterHandlerDelegate.Result {
        if (file !is ValkyrieFileNode) {
            return EnterHandlerDelegate.Result.Continue
        }
        
        val document = editor.document
        val offset = caretOffset.get()
        
        // 检查光标前后的字符
        if (offset > 0 && offset < document.textLength) {
            val charBefore = document.charsSequence[offset - 1]
            val charAfter = document.charsSequence[offset]
            
            // 检查是否在 {|} 的管道符位置
            if (charBefore == '{' && charAfter == '}') {
                // 在 {} 中间按回车，插入适当的缩进和换行
                val lineStart = document.getLineStartOffset(document.getLineNumber(offset))
                val currentLineText = document.charsSequence.subSequence(lineStart, offset).toString()
                val indent = getIndentString(currentLineText)
                
                // 插入换行和缩进
                document.insertString(offset, "\n${indent}    \n$indent")
                caretOffset.set(offset + indent.length + 5) // 定位到缩进后的位置
                caretAdvance.set(0)
                
                return EnterHandlerDelegate.Result.Stop
            }
            
            // 检查是否在管道符后按回车（这是问题所在）
            if (charBefore == '|' && charAfter == '}') {
                // 在 |} 之间按回车，不添加额外空格
                val lineStart = document.getLineStartOffset(document.getLineNumber(offset))
                val currentLineText = document.charsSequence.subSequence(lineStart, offset).toString()
                val indent = getIndentString(currentLineText)
                
                // 只插入换行和缩进，不添加额外空格
                document.insertString(offset, "\n$indent")
                caretOffset.set(offset + indent.length + 1)
                caretAdvance.set(0)
                
                return EnterHandlerDelegate.Result.Stop
            }
        }
        
        return EnterHandlerDelegate.Result.Continue
    }
    
    /**
     * 获取当前行的缩进字符串
     */
    private fun getIndentString(lineText: String): String {
        val indent = StringBuilder()
        for (char in lineText) {
            if (char == ' ' || char == '\t') {
                indent.append(char)
            } else {
                break
            }
        }
        return indent.toString()
    }
}
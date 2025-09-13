package valkyrie.ide.formatter

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.impl.source.codeStyle.PostFormatProcessor
import valkyrie.psi.nodes.ValkyrieFileNode

/**
 * Valkyrie 格式化后处理器
 * 负责将ASCII兼容输入@.转换为标准符号↯
 */
class ValkyriePostFormatProcessor : PostFormatProcessor {
    
    override fun processElement(source: PsiElement, settings: CodeStyleSettings): PsiElement {
        return source
    }
    
    override fun processText(source: PsiFile, rangeToReformat: TextRange, settings: CodeStyleSettings): TextRange {
        if (source !is ValkyrieFileNode) {
            return rangeToReformat
        }
        
        val document = source.viewProvider.document ?: return rangeToReformat
        val text = document.getText(rangeToReformat)
        
        // 将@.替换为↯
        val newText = text.replace("@.", "↯")
        
        if (newText != text) {
            document.replaceString(rangeToReformat.startOffset, rangeToReformat.endOffset, newText)
            // 返回新的范围，长度可能发生变化
            val lengthDiff = newText.length - text.length
            return TextRange(rangeToReformat.startOffset, rangeToReformat.endOffset + lengthDiff)
        }
        
        return rangeToReformat
    }
}
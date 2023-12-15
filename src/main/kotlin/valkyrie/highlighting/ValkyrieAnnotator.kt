package valkyrie.highlighting

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.nodes.*
import valkyrie.psi.ValkyrieElementNode

/**
 * Valkyrie 语义注解器，专门用于特殊染色如 dead code、错误标记等
 * 常规语义高亮由 ValkyrieSemanticHighlighter 处理
 */
class ValkyrieAnnotator : Annotator {
    
    companion object {
        // 特殊染色颜色定义
        val DEAD_CODE = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_DEAD_CODE",
            DefaultLanguageHighlighterColors.BLOCK_COMMENT
        )
        
        val UNUSED_SYMBOL = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_UNUSED_SYMBOL",
            DefaultLanguageHighlighterColors.BLOCK_COMMENT
        )
    }
    
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        // 这里将来可以添加 dead code 检测、未使用符号检测等特殊染色逻辑
        // 例如：
        // - 检测未使用的变量、方法、类等
        // - 检测不可达的代码
        // - 检测过时的 API 使用
        // - 其他语义错误或警告
        
        // 目前暂时为空，等待后续实现特殊染色功能
    }
}
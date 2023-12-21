package valkyrie.ide.highlight

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement

/**
 * Valkyrie 语言注解器
 * 用于提供语法错误检查和语义分析
 */
class ValkyrieAnnotator : Annotator {
    
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        // 目前暂时不实现具体的注解逻辑
        // 可以在这里添加语法错误检查、语义分析等功能
    }
}
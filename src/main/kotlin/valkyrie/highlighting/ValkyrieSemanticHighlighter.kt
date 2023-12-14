package valkyrie.highlighting

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.psi.nodes.ValkyrieMethodDeclaration

/**
 * Valkyrie 语义高亮访问器
 * 用于提供更精确的语义分析和高亮，特别是静态方法检测
 */
class ValkyrieSemanticHighlighter : HighlightVisitor {
    
    companion object {
        val STATIC_METHOD = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_STATIC_METHOD",
            DefaultLanguageHighlighterColors.STATIC_METHOD
        )
        
        val INSTANCE_METHOD = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_INSTANCE_METHOD",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
        )
    }
    
    private var myHolder: HighlightInfoHolder? = null
    
    override fun suitableForFile(file: PsiFile): Boolean {
        return file.language.id == "valkyrie"
    }
    
    override fun visit(element: PsiElement) {
        when (element) {
            is ValkyrieMethodDeclaration -> {
                highlightMethod(element)
            }
        }
    }
    
    private fun highlightMethod(method: ValkyrieMethodDeclaration) {
        val methodName = method.children.find { it.text != "micro" } ?: return
        
        // 检查方法是否有 self 参数来判断是否为静态方法
        val isStaticMethod = !hasSelParameter(method)
        
        val attributesKey = if (isStaticMethod) STATIC_METHOD else INSTANCE_METHOD
        
        val info = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
            .range(methodName)
            .textAttributes(attributesKey)
            .create()
            
        myHolder?.add(info)
    }
    
    private fun hasSelParameter(method: ValkyrieMethodDeclaration): Boolean {
        // 查找参数列表
        val parameterList = method.children.find { child ->
            child.children.any { it.text == "self" }
        }
        return parameterList != null
    }
    
    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable
    ): Boolean {
        myHolder = holder
        try {
            action.run()
        } finally {
            myHolder = null
        }
        return true
    }
    
    override fun clone(): HighlightVisitor {
        return ValkyrieSemanticHighlighter()
    }
}
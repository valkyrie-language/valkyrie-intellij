package valkyrie.ide.completion

import com.intellij.lang.folding.CustomFoldingProvider
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.*

/**
 * Valkyrie 自定义折叠区域提供者
 * 提供额外的折叠功能，如注释块、导入语句等
 */
class ValkyrieFoldingRegion : CustomFoldingProvider() {

    // CustomFoldingProvider不需要buildLanguageFoldRegions方法

    override fun isCustomRegionStart(elementText: String): Boolean {
        return elementText.startsWith("<#") || elementText.startsWith("using")
    }

    override fun isCustomRegionEnd(elementText: String): Boolean {
        return elementText.endsWith("#>") || elementText.startsWith("using")
    }

    override fun getPlaceholderText(elementText: String): String {
        return when {
            elementText.startsWith("using") -> "using ..."
            elementText.startsWith("<#") -> "<#...#>"
            else -> "..."
        }
    }

    override fun getDescription(): String {
        return "Valkyrie Custom Folding"
    }

    override fun getStartString(): String {
        return "<#"
    }

    override fun getEndString(): String {
        return "#>"
    }
}
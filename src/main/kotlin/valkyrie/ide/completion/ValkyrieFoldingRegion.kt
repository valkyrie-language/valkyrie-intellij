package valkyrie.ide.completion

import com.intellij.lang.folding.CustomFoldingProvider
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

    override fun buildLanguageFoldRegions(
        descriptors: MutableList<CustomFoldingProvider.FoldingDescriptor>,
        root: PsiElement,
        document: Document,
        quick: Boolean
    ) {
        if (root !is ValkyrieFileNode) return
        
        // 折叠连续的导入语句
        addImportFolding(root, descriptors, document)
        
        // 折叠文档注释
        addDocumentationCommentFolding(root, descriptors, document)
        
        // 折叠多行注释
        addMultiLineCommentFolding(root, descriptors, document)
    }

    private fun addImportFolding(
        file: ValkyrieFileNode,
        descriptors: MutableList<CustomFoldingProvider.FoldingDescriptor>,
        document: Document
    ) {
        val usingStatements = PsiTreeUtil.getChildrenOfType(file, ValkyrieUsingStatementNode::class.java)
        if (usingStatements != null && usingStatements.size > 1) {
            val first = usingStatements.first()
            val last = usingStatements.last()
            val range = TextRange(first.textRange.startOffset, last.textRange.endOffset)
            
            if (range.length > 0) {
                descriptors.add(
                    CustomFoldingProvider.FoldingDescriptor(
                        first.node,
                        range,
                        null,
                        "using ...",
                        false
                    )
                )
            }
        }
    }

    private fun addDocumentationCommentFolding(
        file: ValkyrieFileNode,
        descriptors: MutableList<CustomFoldingProvider.FoldingDescriptor>,
        document: Document
    ) {
        // 查找文档注释并添加折叠
        PsiTreeUtil.processElements(file) { element ->
            if (element.text.startsWith("/**") && element.text.endsWith("*/")) {
                val lines = element.text.split("\n")
                if (lines.size > 2) {
                    descriptors.add(
                        CustomFoldingProvider.FoldingDescriptor(
                            element.node,
                            element.textRange,
                            null,
                            "/**...*/",
                            false
                        )
                    )
                }
            }
            true
        }
    }

    private fun addMultiLineCommentFolding(
        file: ValkyrieFileNode,
        descriptors: MutableList<CustomFoldingProvider.FoldingDescriptor>,
        document: Document
    ) {
        // 查找多行注释并添加折叠
        PsiTreeUtil.processElements(file) { element ->
            if (element.text.startsWith("/*") && element.text.endsWith("*/") && !element.text.startsWith("/**")) {
                val lines = element.text.split("\n")
                if (lines.size > 2) {
                    descriptors.add(
                        CustomFoldingProvider.FoldingDescriptor(
                            element.node,
                            element.textRange,
                            null,
                            "/*...*/",
                            false
                        )
                    )
                }
            }
            true
        }
    }

    override fun getLanguagePlaceholderText(node: com.intellij.lang.ASTNode, range: TextRange): String {
        val text = node.text
        return when {
            text.startsWith("using") -> "using ..."
            text.startsWith("/**") -> "/**...*/"
            text.startsWith("/*") -> "/*...*/"
            else -> "..."
        }
    }

    override fun isRegionCollapsedByDefault(node: com.intellij.lang.ASTNode): Boolean {
        // 默认折叠导入语句
        return node.text.startsWith("using")
    }
}